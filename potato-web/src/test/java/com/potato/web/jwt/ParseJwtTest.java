package com.potato.web.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ParseJwtTest {
	public static void main(String[] args) {
		String compactJws="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1ODM1NzUyMDJ9.L6OCckg1dJnrMK68_qvN_m3spo2KY86pIO1IsGxKnXM";
		Claims claims = Jwts.parser().setSigningKey("abc123").parseClaimsJws(compactJws).getBody();
		System.out.println("id:"+claims.getId());
		System.out.println("subject:"+claims.getSubject());
		System.out.println("IssuedAt:"+claims.getIssuedAt());
	}
}
