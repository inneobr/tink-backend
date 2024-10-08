package org.inneo.backend.domain;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Date;

import java.util.UUID;
import lombok.Data;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class GenericEntity implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid;    
    
	@CreationTimestamp
	private Date date;
}
