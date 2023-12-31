package com.socialmedia.controller;

import com.socialmedia.dto.request.ActivateStatusDto;
import com.socialmedia.dto.request.NewCreateUserRequestDto;
import com.socialmedia.dto.request.UserProfileUpdateRequestDto;
import com.socialmedia.repository.entity.UserProfile;
import com.socialmedia.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.socialmedia.constant.ApiUrls.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createUser(@RequestBody NewCreateUserRequestDto dto){
        return  ResponseEntity.ok(userProfileService.createUser(dto));
    }

    @PostMapping(ACTIVATESTATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestHeader(value = "Authorization") String token){
        return ResponseEntity.ok(userProfileService.activateStatus(token));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody UserProfileUpdateRequestDto dto){
        return ResponseEntity.ok(userProfileService.update(dto));
    }

    @DeleteMapping(DELETEBYID)
    public ResponseEntity<Boolean> delete(@RequestParam Long authId){
        return ResponseEntity.ok(userProfileService.delete(authId));
    }

    @GetMapping(FINDALL)
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<UserProfile>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping("/findbyusername")
    public ResponseEntity<UserProfile> findByUsername(@RequestParam  String username){
        return  ResponseEntity.ok(userProfileService.findByUsername(username));
    }
    @GetMapping(FINDBYROLE)
    public ResponseEntity<List<UserProfile>> findByRole(@RequestHeader(value = "Authorization")String token, @RequestParam  String role){
        return  ResponseEntity.ok(userProfileService.findByRole(role,token));
    }
}
