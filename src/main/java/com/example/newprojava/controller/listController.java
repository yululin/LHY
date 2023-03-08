package com.example.newprojava.controller;

import com.example.newprojava.Jwt.Resopense;
import com.example.newprojava.pojo.ListShow;
import com.example.newprojava.resClass.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RestController
@CrossOrigin
@RequestMapping("/list")
public class listController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @PostMapping("/find/v1")
    public Resopense findListShow(@RequestHeader("token") String token){
            Resopense res=new Resopense();
            Data resData=new Data();
        try {
            Iterable<ListShow> data=mongoTemplate.findAll(ListShow.class);
            resData.setUserList(data);
            res.setCode(200);
            res.setStatus(1);
            res.setData(resData);
            System.out.println(token);
            return res;
        }catch (Exception e){
            res.setCode(299);
            res.setError("查询错误");
            res.setStatus(1);
            return res;

        }
    }
    @PostMapping("/insert/v1")
    public Resopense insert(@RequestBody ListShow listShow){
        Data resData=new Data();
        Resopense res=new Resopense();
        try {
            ListShow data= mongoTemplate.insert(listShow);
            resData.setUserList(data);
            res.setCode(200);
            res.setStatus(1);
            res.setData(resData);
            return res;

        }catch (Exception e){
            res.setCode(299);
            res.setError("查询错误");
            res.setStatus(1);
            return res;
        }


    }
}
