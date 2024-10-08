package org.inneo.backend.domain;

import org.inneo.backend.enums.TokenType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "token")
public class Token extends GenericEntity{
	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	public String token;

	@Enumerated(EnumType.STRING)
	public TokenType tokenType;

	@Column(name = "renovado")
	private boolean revoked;
	
	@Column(name = "expirado")
	private boolean expired;

	@ManyToOne
	@JoinColumn(name = "usuario_uuid")
	public Usuario usuario;
}
