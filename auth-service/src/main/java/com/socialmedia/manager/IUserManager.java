package com.socialmedia.manager;

import com.socialmedia.dto.request.ActivateStatusDto;
import com.socialmedia.dto.request.NewCreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.socialmedia.constant.ApiUrls.ACTIVATESTATUS;
import static com.socialmedia.constant.ApiUrls.DELETEBYID;


@FeignClient(url = "http://localhost:7070/api/v1/user", decode404 = true, name = "auth-userprofile")
public interface IUserManager {


    @PostMapping("/create")
    public ResponseEntity<Boolean> createUser(@RequestBody NewCreateUserRequestDto dto);

    @PostMapping(ACTIVATESTATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestHeader(value = "Authorization") String token);

    @DeleteMapping(DELETEBYID)
    public ResponseEntity<Boolean> delete(@RequestParam Long authId);


}
