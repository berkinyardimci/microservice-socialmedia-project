package com.socialmedia.mapper;

import com.socialmedia.dto.request.CreateFollowRequestDto;
import com.socialmedia.repository.entity.Follow;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-06T15:57:35+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IFollowMapperImpl implements IFollowMapper {

    @Override
    public Follow toFollow(CreateFollowRequestDto dto, String userId) {
        if ( dto == null && userId == null ) {
            return null;
        }

        Follow.FollowBuilder<?, ?> follow = Follow.builder();

        if ( dto != null ) {
            follow.followId( dto.getFollowId() );
        }
        follow.userId( userId );

        return follow.build();
    }
}
