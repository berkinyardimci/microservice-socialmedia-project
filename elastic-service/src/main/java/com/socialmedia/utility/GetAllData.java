package com.socialmedia.utility;

import com.socialmedia.manager.IUserManager;
import com.socialmedia.repository.entity.UserProfile;
import com.socialmedia.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllData {

    private final UserProfileService userProfileService;

    private final IUserManager userManager;

    //@PostConstruct
    public void initData(){
        List<UserProfile> userProfileList=userManager.findAll().getBody();
        userProfileService.saveAll(userProfileList);
    }
}
