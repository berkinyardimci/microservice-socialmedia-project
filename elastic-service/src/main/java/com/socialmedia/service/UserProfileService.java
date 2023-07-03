package com.socialmedia.service;


import com.socialmedia.mapper.IElasticMapper;
import com.socialmedia.rabbitmq.model.RegisterElasticModel;
import com.socialmedia.repository.IUserProfileRepository;
import com.socialmedia.repository.entity.UserProfile;

import com.socialmedia.utility.ServiceManager;

import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile, String> {

    private final IUserProfileRepository userProfileRepository;


    public UserProfileService(IUserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile createUserWithRabbitMq(RegisterElasticModel model) {
        return  save(IElasticMapper.INSTANCE.toUserProfile(model));
    }
}

