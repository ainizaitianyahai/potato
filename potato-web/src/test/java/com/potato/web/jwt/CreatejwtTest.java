package com.potato.web.jwt;

import java.util.Date;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class CreatejwtTest {
	public static void main(String[] args) {
		JwtBuilder builder= Jwts.builder().setId("888")
			.setSubject("小白")
			.setIssuedAt(new Date())//用于设置签发时间
			.signWith(SignatureAlgorithm.HS256,"abc123");//用于设置签名秘钥
		System.out.println( builder.compact() );
	}
}
