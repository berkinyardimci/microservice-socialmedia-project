package com.socialmedia.mapper;

import com.socialmedia.dto.request.CreateNewPostRequestDto;
import com.socialmedia.repository.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IPostMapper {


    IPostMapper INSTANCE= Mappers.getMapper(IPostMapper.class);

    Post toPost(final CreateNewPostRequestDto dto);
}
