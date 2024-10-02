package org.inneo.backend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.inneo.backend.dtos.RegisterRequest;

import org.inneo.backend.reposit.OperadorRep;
import org.inneo.backend.dtos.TokenResponse;
import org.inneo.backend.dtos.AuthRequest;

import org.inneo.backend.domain.Operador;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor @Transactional
public class OperadorService {
	private final PasswordEncoder passwordEncoder;
	private final TokenService service;
	private final OperadorRep query;
	
	public TokenResponse create(RegisterRequest request) {		
		Operador operador = Operador.builder()
				.username(request.username())
				.password(passwordEncoder.encode(request.password()))
				.email(request.email())
				.build();	
		return save(operador);
	}
	
	public Operador update(RegisterRequest request) {		
		Operador operador = this.query.getReferenceById(request.id());
		BeanUtils.copyProperties(request, operador);	
		return query.save(operador);
	}
	
	public TokenResponse authenticar(AuthRequest request) {
		Operador operador = this.query.findByUsername(request.username()).orElseThrow(() -> new RuntimeException("Unauthorized"));
		if (passwordEncoder.matches(request.password(), operador.getPassword())) {
			String token = this.service.generateToken(operador);
			return new TokenResponse(operador.getUsername(), token);
		}
		throw new RuntimeException("Unauthorized");
	}
	
	private TokenResponse save(Operador operador) {
		operador = query.save(operador);
		String token = this.service.generateToken(operador);
		return new TokenResponse(operador.getUsername(), token);
	}
}
