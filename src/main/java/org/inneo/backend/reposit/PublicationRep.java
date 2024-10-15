package org.inneo.backend.reposit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.inneo.backend.domain.Publication;
import java.util.UUID;

@Repository
public interface PublicationRep extends JpaRepository<Publication, UUID> {
}
