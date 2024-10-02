package org.inneo.backend.service;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.inneo.backend.dtos.RegisterRequest;

import org.inneo.backend.domain.Operador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

@ExtendWith(MockitoExtension.class)
public class TokenServiceTest {

	@InjectMocks
	TokenService service;
	
	RegisterRequest request;
	Operador operador;
	String token;
	
	@BeforeEach
	public void setUp() {		
		operador = new Operador("projeto", "tulipa", "inneobr@gmail.com", null);
		request = new RegisterRequest(operador);
	}
	
	@Test
	void deveRetornarAccessTokenSuccess() {
	}
}
