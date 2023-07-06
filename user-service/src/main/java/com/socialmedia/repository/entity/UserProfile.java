package com.socialmedia.repository.entity;


import com.socialmedia.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Document
public class UserProfile extends BaseEntity{

    @Id
    private String id;
    private Long authId;
    private String username;
    private String email;
    private String phone;
    private String avatar;
    private String address;
    private String about;
    @Builder.Default
    private EStatus status=EStatus.PENDING;
    @Builder.Default
    private List<String> follows=new ArrayList<>();
    @Builder.Default
    private List<String> follower=new ArrayList<>();

}
