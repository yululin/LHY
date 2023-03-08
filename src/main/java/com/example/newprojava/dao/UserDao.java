package com.example.newprojava.dao;

import com.example.newprojava.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User,String> {
}
