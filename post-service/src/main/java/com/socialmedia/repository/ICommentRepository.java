package com.socialmedia.repository;

import com.socialmedia.repository.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICommentRepository extends MongoRepository<Comment,String> {
}
