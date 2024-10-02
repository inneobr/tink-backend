package org.inneo.backend.dtos;

import org.inneo.backend.domain.Operador;

public record RegisterRequest(Long id, String email, String username, String password) {

	public RegisterRequest(Operador operador) {
		 this(operador.getId(), operador.getUsername(), operador.getPassword(), operador.getEmail());
	}}
