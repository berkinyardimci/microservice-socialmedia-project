package com.socialmedia.controller;

import com.socialmedia.dto.request.ActivateRequestDto;
import com.socialmedia.dto.request.LoginRequestDto;
import com.socialmedia.dto.request.RegisterRequestDto;
import com.socialmedia.dto.request.UpdateEmailOrUsernameRequestDto;
import com.socialmedia.dto.response.RegisterResponseDto;
import com.socialmedia.repository.entity.Auth;
import com.socialmedia.repository.enums.ERole;
import com.socialmedia.service.AuthService;
import com.socialmedia.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.socialmedia.constant.ApiUrls.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtTokenManager tokenManager;

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(REGISTER + "2")
    public ResponseEntity<RegisterResponseDto> register2(@RequestBody @Valid RegisterRequestDto dto) {
        return ResponseEntity.ok(authService.registerWithRabbitMq(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<?> login(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping(ACTIVATESTATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody ActivateRequestDto dto) {
        return ResponseEntity.ok(authService.activateStatus(dto));
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(FINDALL)
    public ResponseEntity<List<Auth>> findAll() {
        return ResponseEntity.ok(authService.findAll());
    }

    @GetMapping("/createtoken")
    public ResponseEntity<String> createToken(Long id, ERole role) {
        return ResponseEntity.ok(tokenManager.createToken(id, role).get());
    }

    @GetMapping("/createtoken2")
    public ResponseEntity<String> createToken(Long id) {
        return ResponseEntity.ok(tokenManager.createToken(id).get());
    }

    @GetMapping("/getidfromtoken")
    public ResponseEntity<Long> getIdFromToken(String token) {
        return ResponseEntity.ok(tokenManager.getIdFromToken(token).get());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getrolefromtoken")
    public ResponseEntity<String> getRoleFromToken(String token) {
        return ResponseEntity.ok(tokenManager.getRoleFromToken(token).get());
    }

    @PutMapping("/updateemailorusername")
    public ResponseEntity<Boolean> updateEmailOrUsername(@RequestHeader(value = "Authorization")String token,@RequestBody UpdateEmailOrUsernameRequestDto dto) {
        return ResponseEntity.ok(authService.updateEmailOrUsername(dto));
    }

    @DeleteMapping(DELETEBYID)
    public ResponseEntity<Boolean> delete(Long id) {
        return ResponseEntity.ok(authService.delete(id));
    }

    @GetMapping(FINDBYROLE)
    public ResponseEntity<List<Long>> findByRole(@RequestHeader(value = "Authorization")String token, @RequestParam String role) {
        return ResponseEntity.ok(authService.findByRole(role));
    }
}
