package com.example.userlogin.users;

import com.example.userlogin.common.BaseEntity;
import com.example.userlogin.profiles.ProfileEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Getter @Setter
@Entity(name = "users")
public class UsersEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String password;

    @OneToOne
    private ProfileEntity profileEntity;
}
