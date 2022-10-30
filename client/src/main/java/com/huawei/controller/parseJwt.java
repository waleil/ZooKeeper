package com.huawei.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * @Auther: csx
 * @Date: 2022/1/27 21:37
 * @Description:
 */
//登录成功的一瞬间生产token   客户端不用对token做解析严重，直接拿token访问，再次访问的时候，如果需要权限，需要对token做解析，解析第一步要知道盐
public class  parseJwt {
    public static void main(String[] args) {
        Claims claims = Jwts.parser().setSigningKey("itcast").parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJhdWQiOiJ3ZXIiLCJpYXQiOjE2NDMyOTA1NjV9.2-KHAXuq3QKg0hizK2alJE1EWHVFiXJuTAGqdDx3QyY")
                .getBody();
        System.out.println("用户id："+claims.getId());
        System.out.println("用户名："+claims.getSubject());
        System.out.println("登录时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("自定义key-value："+claims.get("rol"));
    }
}
