package org.inneo.backend.reposit;

import java.util.Optional;

import org.inneo.backend.domain.Operador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperadorRep extends JpaRepository<Operador, Long> {
    Operador findByEmailOrUsername(String email, String username);
    Optional<Operador> findByUsername(String username);
    Operador findByEmail(String email);
}
