package com.socialmedia.service;

import com.socialmedia.dto.request.CreateNewPostRequestDto;
import com.socialmedia.mapper.IPostMapper;
import com.socialmedia.repository.IPostRepository;
import com.socialmedia.repository.entity.Post;
import com.socialmedia.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PostService extends ServiceManager<Post,String> {

    private final IPostRepository postRepository;
    public PostService(IPostRepository postRepository) {
        super(postRepository);
        this.postRepository = postRepository;
    }

    public Post createPost(CreateNewPostRequestDto dto) {
        return save(IPostMapper.INSTANCE.toPost(dto));
    }
}
