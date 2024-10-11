package org.inneo.backend.reposit;

import java.util.List;
import java.util.UUID;
import org.inneo.backend.domain.Gallery;
import org.inneo.backend.domain.Token;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface GalleryRep extends JpaRepository<Gallery, UUID> {
	@Query(value = """
			select g from Gallery g inner join Publication p 
			on g.publication.uuid = p.uuid""")
	 List<Token> findAllByPublication(UUID uuid);	
}
