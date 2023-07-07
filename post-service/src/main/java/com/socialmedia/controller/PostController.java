package com.socialmedia.controller;

import com.socialmedia.dto.request.CreateNewPostRequestDto;
import com.socialmedia.repository.entity.Post;
import com.socialmedia.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static  com.socialmedia.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(POST)
public class PostController {

    private final PostService postService;

    @PostMapping(CREATE)
    public ResponseEntity<Post> createPost(@RequestBody CreateNewPostRequestDto dto){
        return  ResponseEntity.ok(postService.createPost(dto));
    }

    @GetMapping(FINDALL)
    public  ResponseEntity<List<Post>> findAll(){
        return  ResponseEntity.ok(postService.findAll());
    }
}
