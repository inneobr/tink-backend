package org.inneo.backend.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.apache.commons.codec.binary.Base64;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Transient;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Lob;

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
	
	@Lob
	@Column(name = "bits")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private byte[] bits;
	
	@OneToOne
	@JoinColumn(name = "usuario_uuid")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public Usuario usuario;
	
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
