package org.inneo.backend.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder()
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profile")
public class Profile extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name", nullable = true)
	private String name;
	
	@Column(name = "bio", nullable = true)
	private String biografia;
	
	@NotBlank
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@OneToOne
	@JoinColumn(name = "usuario_uuid")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public Usuario usuario;
}
