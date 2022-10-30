package com.huawei.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @Auther: csx
 * @Date: 2022/1/26 23:00
 * @Description:
 */
public class JWTUtil {
    public static final String secret = "!sdsfsdgfdg";

    //获取token
    public static String getToken(Map<String, String> map){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);// 默认7天过期

        JWTCreator.Builder builder = JWT.create();

        map.forEach((k,v) -> builder.withClaim(k,v));

        String token = builder.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    //验证合法性并获取参数
    public static DecodedJWT getDDecodedJWT(String token){
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);//若报错 则说明token不合法
    }

}
