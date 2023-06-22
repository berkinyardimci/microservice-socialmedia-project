package com.socialmedia.controller;

import com.socialmedia.dto.request.NewCreateUserRequestDto;
import com.socialmedia.dto.request.UserProfileUpdateRequestDto;
import com.socialmedia.repository.entity.UserProfile;
import com.socialmedia.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(ACTIVATESTATUS+"/{authId}")
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authId){
        return ResponseEntity.ok(userProfileService.activateStatus(authId));
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
    public ResponseEntity<List<UserProfile>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }

}