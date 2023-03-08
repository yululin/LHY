package com.example.newprojava.pojo;

import lombok.Data;

@Data
public class ListShow {
    private String name;
    private String wxId;
    private String mail;
    private String phone;

    @Override
    public String toString() {
        return "ListShow{" +
                "name='" + name + '\'' +
                ", wxId='" + wxId + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
