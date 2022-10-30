package com.huawei.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Auther: csx
 * @Date: 2022/1/27 21:26
 * @Description:
 */
public class CreateJwt {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")
                .setSubject("小马")
                .setAudience("wer")
                .setIssuedAt(new Date())
                .claim("rol", "jswoeiei")
                //此处以上信息是载荷
                .signWith(SignatureAlgorithm.HS256,"itcast");//指定头，头中有两个参数一个是加密算法，一个是盐
        System.out.println(jwtBuilder.compact());
    }
}
