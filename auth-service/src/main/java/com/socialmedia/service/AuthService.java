package com.socialmedia.service;

import com.socialmedia.dto.request.ActivateRequestDto;
import com.socialmedia.dto.request.LoginRequestDto;
import com.socialmedia.dto.request.RegisterRequestDto;
import com.socialmedia.dto.request.UpdateEmailOrUsernameRequestDto;
import com.socialmedia.dto.response.RegisterResponseDto;
import com.socialmedia.exception.AuthManagerException;
import com.socialmedia.exception.ErrorType;
import com.socialmedia.manager.IUserManager;
import com.socialmedia.mapper.IAuthMapper;
import com.socialmedia.repository.IAuthRepository;
import com.socialmedia.repository.entity.Auth;
import com.socialmedia.repository.enums.EStatus;
import com.socialmedia.utility.CodeGenerator;
import com.socialmedia.utility.JwtTokenManager;
import com.socialmedia.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {
    private final IAuthRepository authRepository;
    private final IUserManager userManager;
    private final JwtTokenManager jwtTokenManager;

    public AuthService(IAuthRepository authRepository, IUserManager userManager, JwtTokenManager jwtTokenManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager = userManager;
        this.jwtTokenManager = jwtTokenManager;
    }

    @Transactional
    public RegisterResponseDto register(RegisterRequestDto dto) {
        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);
        auth.setActivationCode(CodeGenerator.genarateCode());
        save(auth);
        try {
            userManager.createUser(IAuthMapper.INSTANCE.toNewCreateUserRequestDto(auth));
        }catch (Exception e){
            throw new AuthManagerException(ErrorType.USER_NOT_CREATED);
        }
        RegisterResponseDto registerResponseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);
        return registerResponseDto;
    }

    public String login(LoginRequestDto dto) {
        Optional<Auth> auth = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (auth.isEmpty()) {
            throw new AuthManagerException(ErrorType.LOGIN_ERROR);
        }
        if (!auth.get().getStatus().equals(EStatus.ACTIVE)){
            throw new AuthManagerException(ErrorType.ACCOUNT_NOT_ACTIVE);
        }
        return jwtTokenManager.createToken(auth.get().getId()
                ,auth.get().getRole()).orElseThrow(()-> {throw new AuthManagerException(ErrorType.TOKEN_NOT_CREATED);});
    }

    public Boolean activateStatus(ActivateRequestDto dto) {
        Optional<Auth> auth=findById(dto.getId());
        if (auth.isEmpty()){
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        if (dto.getActivationCode().equals(auth.get().getActivationCode())){
            auth.get().setStatus(EStatus.ACTIVE);
            update(auth.get());
            userManager.activateStatus(auth.get().getId());
            return true;
        }else {
            throw new AuthManagerException(ErrorType.ACTIVATE_CODE_ERROR);
        }
    }

    public Boolean updateEmailOrUsername(UpdateEmailOrUsernameRequestDto dto) {
        Optional<Auth> auth=authRepository.findById(dto.getAuthId());
        if (auth.isEmpty()){
            throw  new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        auth.get().setUsername(dto.getUsername());
        auth.get().setEmail(dto.getEmail());
        update(auth.get());
        return  true;
    }

    @Transactional
    public Boolean delete(Long id){
        Optional<Auth> auth=findById(id);
        if (auth.isEmpty()){
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        auth.get().setStatus(EStatus.DELETED);
        update(auth.get());
        userManager.delete(id);
        return true;
    }
}