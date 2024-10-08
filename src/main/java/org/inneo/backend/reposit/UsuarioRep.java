package org.inneo.backend.reposit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.inneo.backend.domain.Usuario;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRep extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByUsername(String username);
}
