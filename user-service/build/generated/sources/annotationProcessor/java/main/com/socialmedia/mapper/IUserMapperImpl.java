package com.socialmedia.mapper;

import com.socialmedia.dto.request.NewCreateUserRequestDto;
import com.socialmedia.dto.request.UpdateEmailOrUsernameRequestDto;
import com.socialmedia.dto.request.UserProfileUpdateRequestDto;
import com.socialmedia.rabbitmq.model.RegisterElasticModel;
import com.socialmedia.rabbitmq.model.RegisterModel;
import com.socialmedia.repository.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-06T15:57:34+0300",
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

    @Override
    public UserProfile toUserProfile(RegisterModel model) {
        if ( model == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.authId( model.getAuthId() );
        userProfile.username( model.getUsername() );
        userProfile.email( model.getEmail() );

        return userProfile.build();
    }

    @Override
    public RegisterElasticModel toRegisterElasticModel(UserProfile userProfile) {
        if ( userProfile == null ) {
            return null;
        }

        RegisterElasticModel.RegisterElasticModelBuilder registerElasticModel = RegisterElasticModel.builder();

        registerElasticModel.id( userProfile.getId() );
        registerElasticModel.authId( userProfile.getAuthId() );
        registerElasticModel.username( userProfile.getUsername() );
        registerElasticModel.email( userProfile.getEmail() );

        return registerElasticModel.build();
    }
}
