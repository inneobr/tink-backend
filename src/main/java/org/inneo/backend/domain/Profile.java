package org.inneo.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	private String name;
	private String biografia;	
}
