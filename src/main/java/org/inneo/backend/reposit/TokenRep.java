package org.inneo.backend.reposit;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.inneo.backend.domain.Token;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TokenRep extends JpaRepository<Token, UUID>{
	@Query(value = """
			select t from Token t inner join Usuario u 
			on t.usuario.uuid = u.uuid 
			where u.uuid = :uuid and (t.expired = false or t.revoked = false)""")
	 List<Token> findAllValidTokenByUsuario(UUID uuid);	
	 Optional<Token> findByToken(String token);
}
