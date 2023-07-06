package com.socialmedia.controller;


import com.socialmedia.dto.request.CreateFollowRequestDto;
import com.socialmedia.repository.entity.Follow;
import com.socialmedia.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import  static  com.socialmedia.constant.ApiUrls.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(FOLLOW)
public class FollowController {

    private final FollowService followService;

    @PostMapping(CREATE)
    public ResponseEntity<?> createFollow(@RequestBody CreateFollowRequestDto dto){
        return ResponseEntity.ok(followService.createFollow(dto));
    }
}
