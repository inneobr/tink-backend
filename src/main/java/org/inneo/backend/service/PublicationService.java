package org.inneo.backend.service;

import org.inneo.backend.dtos.PublicationResponse;
import org.springframework.data.domain.PageImpl;
import org.inneo.backend.reposit.PublicationRep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.inneo.backend.domain.Publication;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor @Transactional
public class PublicationService {
	private final UsuarioService service;
	private final PublicationRep query;
	
	public Publication create(Publication request) {
		var usuario =service.getUsuarioLogado();
		request.setUsuario(usuario);
		return query.save(request);
	}
	
	public Page<PublicationResponse> findAll(Pageable pageable) {	
		Page<Publication> pagination = query.findAll(pageable);		
		List<PublicationResponse> response = pagination.stream().map(PublicationResponse::new).toList();
		return new PageImpl<>(response, pageable, pagination.getTotalElements());
	}
}
