package com.medicapp.data.model;

import org.springframework.beans.factory.annotation.Value;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	@Value("${jwt.secret}")
	private String secret = "secret_key";
	
	public Staff parseToken(String token){
		try{
			Claims body = Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody();
			Staff s = new Staff();
			s.setUsername(body.getSubject());
			s.setIdstaff(Integer.parseInt((String)body.get("accountId")));
			s.setRole(Integer.parseInt((String)body.get("accountType")));
			return s;
		}catch(JwtException | ClassCastException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public String generateToken(Staff s){
		Claims claims = Jwts.claims().setSubject(s.getUsername());
		claims.put("accountId", s.getIdstaff() + "");
		claims.put("accountType", s.getRole() + "");
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
}
