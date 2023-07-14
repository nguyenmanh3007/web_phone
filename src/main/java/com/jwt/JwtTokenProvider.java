package com.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.security.CustomUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider {
	@Value("${com.jwt.secret}")
	private String JWT_SECRET;
	@Value("${com.jwt.expiration}")
	private int JWT_EXPIRATION;
	//Tao jwt tu thong tin user(Dua vao thong tin customdetail de sinh ra chuoi jwt duy nhat)
	public String generateToken(CustomUserDetails customUserDetails) {
		Date now = new Date();
		Date dateExpired = new Date(now.getTime()+JWT_EXPIRATION);
		//Tao chuoi jwt tu username cua user
		return Jwts.builder().setSubject(customUserDetails.getUsername())
				.setIssuedAt(now)
				.setExpiration(dateExpired)
				.signWith(SignatureAlgorithm.HS512,JWT_SECRET).compact();
	}
	//lay thong tin user tu jwt 
	public String getUserNameFromJwt(String token) {
		Claims claims= Jwts.parser().setSigningKey(JWT_SECRET)
				.parseClaimsJws(token).getBody()
				;
		//tra lai username 
		return claims.getSubject();
	}
	//validate thong tin cua chuoi jwt
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET)
			.parseClaimsJws(token);
			return true;
		}
		catch(MalformedJwtException ex) {
			log.error("Invalid JWT token");
		}
		catch(ExpiredJwtException ex) {
			log.error("Expired JWT token");
		}
		catch(UnsupportedJwtException ex) {
			log.error("Unsupported JWT token");
		}
		catch(IllegalArgumentException ex) {
			log.error("JWT claims String is empty");
		}
		return false;
	}
}
