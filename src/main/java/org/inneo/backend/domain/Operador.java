package org.inneo.backend.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder()
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "operador")
public class Operador extends GenericEntity{
	private static final long serialVersionUID = 1L;			
	
	@NotBlank
	@Column(name = "username", unique = true, nullable = false)
    private String username;
	
	@NotBlank
	@Column(name = "pasword", nullable = false)
    private String password;
	
	@NotBlank
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id", referencedColumnName = "id")
	private Profile profile;
}
