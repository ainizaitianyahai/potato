package com.potato.web.jwt;

import java.util.Date;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class CreateJwtTest2 {
	public static void main(String[] args) {
		//为了方便测试，我们将过期时间设置为1分钟
		long now = System.currentTimeMillis();//当前时间
		long exp = now + 1000*60;//过期时间为1分钟
		JwtBuilder builder= Jwts.builder().setId("888")
	        .setSubject("小白")
	        .setIssuedAt(new Date())
	        .signWith(SignatureAlgorithm.HS256,"abc123")
	        .setExpiration(new Date(exp));//用于设置过期时间
			System.out.println( builder.compact() );
		}
}
