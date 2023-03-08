package com.example.newprojava.Jwt;

import com.example.newprojava.pojo.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class CreateJwt {
    private static long time = 1000*60*60*24;
    private static String signature = "admin";
    public static String createToken(UserLogin user){
        HashMap<String,Object> map=new HashMap<>();
        Calendar instance  =Calendar.getInstance() ;
        map.put("user",user);
        JwtBuilder jwtBuilder= Jwts.builder().setHeaderParam("type","JWT")
                .setHeaderParam("alg","HS256")
                .setClaims(map)
                .setSubject("admin")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .signWith(SignatureAlgorithm.HS256,signature);
        String jwtToken=jwtBuilder.compact();
        return jwtToken;

    }



}
