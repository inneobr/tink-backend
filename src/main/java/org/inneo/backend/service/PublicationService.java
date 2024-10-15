package org.inneo.backend.service;

import org.inneo.backend.dtos.PublicationRequest;
import org.inneo.backend.reposit.PublicationRep;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.inneo.backend.domain.Publication;

import org.springframework.data.domain.Page;
import org.inneo.backend.reposit.GalleryRep;
import jakarta.transaction.Transactional;

import org.inneo.backend.domain.Gallery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor @Transactional
public class PublicationService {
	private final UsuarioService service;
	private final PublicationRep query;
	private final GalleryRep galleryRep;
	
	public Publication create(PublicationRequest request) {
		var usuario = service.getUsuarioLogado();
		Publication create = Publication.builder()
				.shared(request.shared())
				.description(request.description())
				.usuario(usuario.getUuid())
				.build();	
		
		var publication = query.save(create);
		
		for(Gallery item: request.gallery()) {
			item.setPublication(publication.getUuid());
			galleryRep.save(item);
		}
		return publication;
	}
	
	public Page<Publication> findPublication(Pageable pageable) {	
		return query.findAll(pageable);		
	}
}
