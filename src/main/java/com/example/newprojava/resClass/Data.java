package com.example.newprojava.resClass;

import com.example.newprojava.pojo.User;
import org.omg.CORBA.Any;

import java.lang.reflect.Array;
import java.util.List;

@lombok.Data
public class Data {
    private String token;
    private Object userList;
}
