package org.inneo.backend.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Transient;
import jakarta.persistence.ManyToOne;

import org.apache.commons.codec.binary.Base64;

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
@Table(name = "publication")
public class Publication extends GenericEntity{
	private static final long serialVersionUID = 1L;
		
	@Lob
	@Column(name = "bits")
	private byte[] bits;
	
	@Column(name = "link")
	private String link;	
	
	@Column(name = "descricao")
	private String descricao;	
	
	@ManyToOne
	@JoinColumn(name = "usuario_uuid")
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
