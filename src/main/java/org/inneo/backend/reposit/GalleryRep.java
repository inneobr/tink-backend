package org.inneo.backend.reposit;

import java.util.UUID;
import org.inneo.backend.domain.Gallery;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GalleryRep extends JpaRepository<Gallery, UUID> {
}
