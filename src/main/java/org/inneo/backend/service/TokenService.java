package org.inneo.backend.service;

import org.springframework.beans.factory.annotation.Value;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;
import org.inneo.backend.domain.Operador;
import java.time.LocalDateTime;

import java.time.ZoneOffset;
import com.auth0.jwt.JWT;
import java.time.Instant;

@Service
public class TokenService {
	@Value("${api.security.token.secret}")
	private String secret;

	public String generateToken(Operador request) {
		Algorithm algorithm = Algorithm.HMAC256(secret);

		String token = JWT.create().withIssuer("/api/auth").withSubject(request.getEmail())
				.withSubject(request.getUsername()).withExpiresAt(this.generateExpirationDate()).sign(algorithm);
		return token;		
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer("/api/auth").build().verify(token).getSubject();
		} catch (JWTVerificationException exception) {
			return null;
		}
	}

	private Instant generateExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
