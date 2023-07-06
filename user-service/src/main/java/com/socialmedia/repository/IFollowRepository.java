package com.socialmedia.repository;

import com.socialmedia.repository.entity.Follow;
import com.socialmedia.repository.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IFollowRepository extends MongoRepository<Follow,String> {

    Optional<Follow> findByUserIdAndFollowId(String userId, String followId);

}
