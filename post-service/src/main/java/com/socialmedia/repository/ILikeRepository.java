package com.socialmedia.repository;


import com.socialmedia.repository.entity.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILikeRepository extends MongoRepository<Like,String> {
}
