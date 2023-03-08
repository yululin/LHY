package com.example.newprojava.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserS implements Serializable {
    private String username;
    private String password;
    private String address;
}
