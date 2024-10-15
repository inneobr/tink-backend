package org.inneo.backend.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder()
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publication")
public class Publication extends GenericEntity{
	private static final long serialVersionUID = 1L;
			
	@Column(name = "shared")
	private String shared;	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "usuario_uuid")
	private UUID usuario;		
	
	
	@Transient
	private String username;
	
	@Transient
	private byte[] bits;
	
	@OneToMany(mappedBy = "publication",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Gallery> gallery;
	
	@Transient
	private String base64;

	public String getBase64() {
		if(this.bits == null) return null;
		return new String(Base64.decodeBase64(this.bits));
	}
	
	public void setBase64(String base64) {
		this.bits = Base64.encodeBase64(base64.getBytes());
	}
}
