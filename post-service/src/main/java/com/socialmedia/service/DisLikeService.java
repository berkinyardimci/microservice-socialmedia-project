package com.socialmedia.service;

import com.socialmedia.repository.ICommentRepository;
import com.socialmedia.repository.IDisLikeRepository;
import com.socialmedia.repository.entity.Comment;
import com.socialmedia.repository.entity.DisLike;
import com.socialmedia.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class DisLikeService extends ServiceManager<DisLike,String> {

    private final IDisLikeRepository disLikeRepository;
    public DisLikeService(IDisLikeRepository disLikeRepository) {
        super(disLikeRepository);
        this.disLikeRepository = disLikeRepository;
    }
}
