package com.example.demo4.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtUtil {

    private static String SECRET ="1314520大魔王大帅哥大帅比";

    public static String createToken(String username,String password) throws Exception{

        //签发时间
        Date iatDate=new Date();

        //过期时间
        Calendar nowTime=Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,2);
        Date expiresDate=nowTime.getTime();


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)//header
                .withClaim("username", username)//payload
                .withClaim("password", password)
                .withExpiresAt(expiresDate)          //设置过期时间-过期时间要大于签发时间
                .withIssuedAt(iatDate)               //设置签发时间
                .sign(Algorithm.HMAC256(SECRET));//加密
        return token;
    }

    public static String verifyToken(String token) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        return claims.get("username").asString();
    }

    public static void main(String[] args) throws Exception {
        String token=JwtUtil.createToken("guqianwei","123456");
        System.out.println(token);

        /*JwtUtil.verifyToken(
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImV4cCI6MTUyNzEzMDYyOCwiaWF0IjoxNTI3MTMwNTA3LCJ1c2VybmFtZSI6Imd1cWlhbndlaSJ9.YhDtJEgJdG6J8KQNFRmrcRZbZa3bWNNshxAc9ZLzIE4"
                ,SECRET);*/
    }
}
