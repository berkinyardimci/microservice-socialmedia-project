package com.socialmedia.mapper;

import com.socialmedia.dto.request.CreateNewPostRequestDto;
import com.socialmedia.repository.entity.Post;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-07T02:24:46+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IPostMapperImpl implements IPostMapper {

    @Override
    public Post toPost(CreateNewPostRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Post.PostBuilder<?, ?> post = Post.builder();

        post.userId( dto.getUserId() );
        post.username( dto.getUsername() );
        post.title( dto.getTitle() );
        post.content( dto.getContent() );
        post.mediaUrl( dto.getMediaUrl() );

        return post.build();
    }
}
