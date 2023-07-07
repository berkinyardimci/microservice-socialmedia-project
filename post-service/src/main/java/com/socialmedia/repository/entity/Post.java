package com.socialmedia.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Post extends BaseEntity{

    @Id
    private String id;
    private String userId;
    private String username;
    private String title;
    private String content;
    private String mediaUrl;
    private  int like;
    private int disLike;

}
