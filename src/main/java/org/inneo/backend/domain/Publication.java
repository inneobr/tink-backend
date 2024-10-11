package org.inneo.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Builder;
import java.util.List;
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
			
	@Column(name = "link")
	private String link;	
	
	@Column(name = "descricao")
	private String descricao;	
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "publication",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Gallery> gallery;
	
	@ManyToOne
	@JoinColumn(name = "usuario_uuid")
	public Usuario usuario;	
	
}
