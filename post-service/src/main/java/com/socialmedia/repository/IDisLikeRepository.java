package com.socialmedia.repository;


import com.socialmedia.repository.entity.DisLike;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDisLikeRepository extends MongoRepository<DisLike,String> {
}
