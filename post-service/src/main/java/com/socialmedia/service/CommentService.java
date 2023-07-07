package com.socialmedia.service;

import com.socialmedia.repository.ICommentRepository;
import com.socialmedia.repository.entity.Comment;
import com.socialmedia.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends ServiceManager<Comment,String> {

    private final ICommentRepository commentRepository;
    public CommentService(ICommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }
}
