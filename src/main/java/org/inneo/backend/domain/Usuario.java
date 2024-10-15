package org.inneo.backend.domain;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Enumerated;
import org.inneo.backend.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Collection;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder()
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario extends GenericEntity implements UserDetails{	
	private static final long serialVersionUID = 1L;
	
	@Column(name= "profile_uuid", unique = true)
	private UUID profileUUID;

	@NotBlank
	@Column(unique = true, nullable = false)
	private String username;
	
	@NotBlank
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}	
}
