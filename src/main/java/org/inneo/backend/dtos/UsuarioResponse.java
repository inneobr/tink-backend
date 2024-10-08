package org.inneo.backend.dtos;

import org.inneo.backend.domain.Profile;
import org.inneo.backend.domain.Usuario;
import org.inneo.backend.enums.Role;
import java.util.UUID;

public record UsuarioResponse(UUID uuid, String username, Profile profile, Role role) {
	public UsuarioResponse(Usuario usuario){
        this(usuario.getUuid(), usuario.getUsername(), usuario.getProfile(), usuario.getRole());
    }
}
