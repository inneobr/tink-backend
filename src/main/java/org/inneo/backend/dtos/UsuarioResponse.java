package org.inneo.backend.dtos;

import java.util.UUID;

public interface UsuarioResponse {
	UUID getUuid(); 
	String getUsername();
	String getName();
	String getBiografia(); 
	String getEmail();
	byte[] getBits();
}
