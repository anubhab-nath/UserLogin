package com.example.userlogin.profiles;


import com.example.userlogin.common.BaseEntity;

import javax.persistence.Entity;

@Entity(name = "profiles")
public class ProfileEntity extends BaseEntity {
    private String mobile;
}
