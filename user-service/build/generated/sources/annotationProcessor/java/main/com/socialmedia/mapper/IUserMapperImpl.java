package com.socialmedia.mapper;

import com.socialmedia.dto.request.NewCreateUserRequestDto;
import com.socialmedia.dto.request.UpdateEmailOrUsernameRequestDto;
import com.socialmedia.dto.request.UserProfileUpdateRequestDto;
import com.socialmedia.repository.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-21T02:19:08+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserProfile toUserProfile(NewCreateUserRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.authId( dto.getAuthId() );
        userProfile.username( dto.getUsername() );
        userProfile.email( dto.getEmail() );

        return userProfile.build();
    }

    @Override
    public UpdateEmailOrUsernameRequestDto toUpdateEmailOrUsernameRequestDto(UserProfileUpdateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UpdateEmailOrUsernameRequestDto.UpdateEmailOrUsernameRequestDtoBuilder updateEmailOrUsernameRequestDto = UpdateEmailOrUsernameRequestDto.builder();

        updateEmailOrUsernameRequestDto.username( dto.getUsername() );
        updateEmailOrUsernameRequestDto.email( dto.getEmail() );

        return updateEmailOrUsernameRequestDto.build();
    }
}
