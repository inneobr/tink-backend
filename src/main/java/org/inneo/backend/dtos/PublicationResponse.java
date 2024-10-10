package org.inneo.backend.dtos;

import java.util.Date;
import java.util.UUID;
import org.inneo.backend.domain.Publication;

public record PublicationResponse(UUID uuid, Date publish,  String descricao, String base64, String share,String username) {
	public PublicationResponse(Publication publication){
        this(publication.getUuid(), publication.getDate(), publication.getDescricao(), publication.getBase64(), publication.getLink(), publication.getUsuario().getUsername());
    }
}
