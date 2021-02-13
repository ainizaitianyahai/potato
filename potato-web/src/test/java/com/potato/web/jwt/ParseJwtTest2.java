package com.potato.web.jwt;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ParseJwtTest2 {
	public static void main(String[] args) {
		String compactJws="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1ODM1NzU1MTUsImV4cCI6MTU4MzU3NTU3NH0.G_iGQQl6iCUJEbT22_15r61prZPCRhPgX-ZRq76-yFM";
		Claims claims =Jwts.parser().setSigningKey("abc123").parseClaimsJws(compactJws).getBody();
		System.out.println("id:"+claims.getId());
		System.out.println("subject:"+claims.getSubject());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
		System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
		System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
		System.out.println("当前时间:"+sdf.format(new Date()) );
	}
	//测试运行，当未过期时可以正常读取，当过期时会引发io.jsonwebtoken.ExpiredJwtException异常。

}
