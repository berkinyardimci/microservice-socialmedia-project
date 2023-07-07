package com.socialmedia.service;

import com.socialmedia.repository.ILikeRepository;
import com.socialmedia.repository.IPostRepository;
import com.socialmedia.repository.entity.Like;
import com.socialmedia.repository.entity.Post;
import com.socialmedia.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class LikeService extends ServiceManager<Like,String> {

    private final ILikeRepository likeRepository;
    public LikeService(ILikeRepository likeRepository) {
        super(likeRepository);
        this.likeRepository = likeRepository;
    }
}
