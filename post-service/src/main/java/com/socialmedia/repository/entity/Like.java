package com.socialmedia.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Like extends BaseEntity{

    @Id
    private String id;
    private String userId;
    private String postId;
    private String username;

}
