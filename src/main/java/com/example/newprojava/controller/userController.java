package com.example.newprojava.controller;

import com.example.newprojava.Jwt.CreateJwt;
import com.example.newprojava.Jwt.Resopense;
import com.example.newprojava.Jwt.UserLogin;
import com.example.newprojava.dao.UserDao;
import com.example.newprojava.pojo.User;
import com.example.newprojava.resClass.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MongoTemplate mongoTemplate;
    @GetMapping("/find")
    public Resopense findUser(){
        List<User> userList=mongoTemplate.findAll(User.class);
        Resopense res=new Resopense(200,"666",200,"find");
        Data data=new Data();
        data.setUserList(userList);
        res.setData(data);
        return res;
    }
    @PostMapping("/insert")
    public String insert(@RequestBody User user){
        userDao.insert(user);
        return "添加成功";
    }
    @PostMapping("/del")
    public String delInfo(@RequestParam String id){
        userDao.deleteById(id);
        return "删除成功";
    }
    @PostMapping("/update")
    public User update(@RequestParam String id,@RequestBody User user){
        user.setId(id);
        userDao.save(user);
        return userDao.save(user);
    }
    @PostMapping("/login")
    public Resopense login(@RequestBody UserLogin user) {
        String username = user.getUsername();
        String password = user.getPassword();
        Resopense resopense = new Resopense();
        try {
            Query query = new Query(Criteria.where("username").is(username));
            List<User> userList = mongoTemplate.find(query, User.class);
            UserLogin userInfo = new UserLogin();
            for (User user1 : userList) {
                System.out.println(user1);
                userInfo.setUsername(user1.getUsername());
                userInfo.setPassword(user1.getPassword());
            }
            String sqlToken = CreateJwt.createToken(userInfo);
            System.out.println(sqlToken);
            if (userInfo.getPassword().equals(password)) {
                System.out.println("yes");
                resopense.setStatus(200);
                resopense.setCode(200);
                resopense.setMessage("登录成功");
                resopense.setError("");
                Data data=new Data();
                data.setToken(sqlToken);
                resopense.setData(data);
            } else {
                resopense.setStatus(200);
                resopense.setCode(299);
                resopense.setMessage("登录失败");
                resopense.setError("密码错误");
                resopense.setData(null);
            }
            return resopense;

        } catch (NullPointerException e) {
            System.out.println(e);
            resopense.setStatus(704);
            resopense.setCode(299);
            resopense.setMessage("登录失败");
            resopense.setError("账号不存在");
            resopense.setData(null);
            return  resopense;
        }


    }


}

