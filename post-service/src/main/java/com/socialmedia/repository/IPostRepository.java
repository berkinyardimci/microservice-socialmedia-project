package com.socialmedia.repository;


import com.socialmedia.repository.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPostRepository extends MongoRepository<Post,String> {
}
