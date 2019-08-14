package com.feri.shop.newretail.common.jwt;

import com.feri.shop.newretail.common.config.SystemConfig;
import com.feri.shop.newretail.common.util.TimeUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-14 10:48
 */
public class JwtUtil {
    //生成令牌
    /*
    * @param json 要生成的令牌内容*/
    public static String createJWT(String json){
        //1、创建加密规则
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        //2、创建JWT对象
        JwtBuilder jwtBuilder= Jwts.builder();
        //3、设置令牌内容
        jwtBuilder.setSubject(json);
        jwtBuilder.setIssuedAt(new Date());//设置起始时间
        jwtBuilder.setExpiration(TimeUtil.getMinutes(SystemConfig.TOKENTIMES));//设置有效期
        jwtBuilder.signWith(signatureAlgorithm,createKey());//设置加密规则和秘钥
        //4、生成令牌
        return jwtBuilder.compact();
    }
    //生成秘钥
    private static Key createKey(){
        return new SecretKeySpec(SystemConfig.TOKENKEY.getBytes(),"AES");
    }
    //解析令牌
    /*
    * 解析令牌
    * @param token jwt的令牌字符串*/
    public static String parseJWT(String token){
        Claims claim=Jwts.parser().setSigningKey(createKey()).parseClaimsJws(token).getBody();
        return claim.getSubject();
    }
    //校验令牌
    public static boolean checkJWT(String token){
        return parseJWT(token)!=null;
    }
}
