package org.inneo.backend.dtos;

import java.util.List;
import org.inneo.backend.domain.Gallery;

public record PublicationRequest(String shared, String description, List<Gallery> gallery) {

}
