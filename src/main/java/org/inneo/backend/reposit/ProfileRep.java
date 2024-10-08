package org.inneo.backend.reposit;

import java.util.UUID;

import org.inneo.backend.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRep extends JpaRepository<Profile, UUID> {
}
