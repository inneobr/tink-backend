package org.inneo.backend.dtos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.inneo.backend.domain.Gallery;
import org.inneo.backend.domain.Publication;

public record PublicationResponse(String username, String avatar, UUID uuid, Date publish, String descricao, String share, List<Gallery> gallery) {
	public PublicationResponse(Publication publication){
        this(publication.getUsuario().getUsername(), publication.getUsuario().getProfile().getBase64(), publication.getUuid(), publication.getDate(), publication.getDescricao(), publication.getLink(), publication.gallery);
    }
}
