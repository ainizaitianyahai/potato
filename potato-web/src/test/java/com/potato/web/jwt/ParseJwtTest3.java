package com.potato.web.jwt;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ParseJwtTest3 {
	public static void main(String[] args) {
		String compactJwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1ODM1NzU5NzksImV4cCI6MTU4MzU3NjAzOSwicm9sZXMiOiJhZG1pbiIsImxvZ28iOiJsb2dvLnBuZyJ9.skSWnbg9SMFxNDDHnF5h19ikrpFcggvm--5KNl8NXEo";
        Claims claims=Jwts.parser().setSigningKey("abc123").parseClaimsJws(compactJwt).getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("roles:"+claims.get("roles"));
        System.out.println("logo:"+claims.get("logo"));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
        System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sdf.format(new Date()) );
	}
	//测试运行，当未过期时可以正常读取，当过期时会引发io.jsonwebtoken.ExpiredJwtException异常。

}
