package com.socialmedia.mapper;

import com.socialmedia.dto.request.NewCreateUserRequestDto;
import com.socialmedia.dto.request.RegisterRequestDto;
import com.socialmedia.dto.response.RegisterResponseDto;
import com.socialmedia.rabbitmq.model.RegisterMailModel;
import com.socialmedia.rabbitmq.model.RegisterModel;
import com.socialmedia.repository.entity.Auth;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-02T16:43:00+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IAuthMapperImpl implements IAuthMapper {

    @Override
    public Auth toAuth(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Auth.AuthBuilder<?, ?> auth = Auth.builder();

        auth.username( dto.getUsername() );
        auth.email( dto.getEmail() );
        auth.password( dto.getPassword() );

        return auth.build();
    }

    @Override
    public RegisterResponseDto toRegisterResponseDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        RegisterResponseDto.RegisterResponseDtoBuilder registerResponseDto = RegisterResponseDto.builder();

        registerResponseDto.id( auth.getId() );
        registerResponseDto.activationCode( auth.getActivationCode() );
        registerResponseDto.username( auth.getUsername() );

        return registerResponseDto.build();
    }

    @Override
    public NewCreateUserRequestDto toNewCreateUserRequestDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        NewCreateUserRequestDto.NewCreateUserRequestDtoBuilder newCreateUserRequestDto = NewCreateUserRequestDto.builder();

        newCreateUserRequestDto.authId( auth.getId() );
        newCreateUserRequestDto.username( auth.getUsername() );
        newCreateUserRequestDto.email( auth.getEmail() );

        return newCreateUserRequestDto.build();
    }

    @Override
    public RegisterModel toRegisterModel(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        RegisterModel.RegisterModelBuilder registerModel = RegisterModel.builder();

        registerModel.authId( auth.getId() );
        registerModel.username( auth.getUsername() );
        registerModel.email( auth.getEmail() );

        return registerModel.build();
    }

    @Override
    public RegisterMailModel toRegisterMailModel(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        RegisterMailModel.RegisterMailModelBuilder registerMailModel = RegisterMailModel.builder();

        registerMailModel.email( auth.getEmail() );
        registerMailModel.username( auth.getUsername() );
        registerMailModel.activationCode( auth.getActivationCode() );

        return registerMailModel.build();
    }
}
