package org.inneo.backend.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.inneo.backend.infra.security.JwtService;

import org.springframework.stereotype.Service;
import org.inneo.backend.dtos.UsuarioResponse;
import org.inneo.backend.dtos.UsuarioRequest;

import org.inneo.backend.dtos.TokenResponse;
import org.inneo.backend.reposit.UsuarioRep;
import org.inneo.backend.reposit.ProfileRep;

import jakarta.transaction.Transactional;
import org.inneo.backend.domain.Usuario;
import org.inneo.backend.domain.Profile;

import lombok.RequiredArgsConstructor;
import org.inneo.backend.enums.Role;

@Service
@RequiredArgsConstructor @Transactional
public class UsuarioService {
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final ProfileRep profileRep;
	private final UsuarioRep query;
	
	public TokenResponse create(UsuarioRequest request) {		
		if(request.username() == null && query.findByUsername(request.username()) != null) {
			throw new UsernameNotFoundException("Unavailable or unauthorized.");
		}		
		
	    var usuario = Usuario.builder()	    	
	        .username(request.username())
	        .password(passwordEncoder.encode(request.password()))
	        .role(Role.ROLE_USER)
	        .build();
	    
	    var create = query.save(usuario);
	    var profile = createProfile(request);
	    usuario.setProfileUUID(profile.getUuid());
	    
	    create = query.save(usuario);
	    var token = jwtService.generateToken(usuario);
	    
	    return new TokenResponse(create.getUsername(), token);
	  }

	  public TokenResponse authenticate(UsuarioRequest request) {
	    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	            request.username(),
	            request.password()
	        )
	    );
	    var usuario = query.findByUsername(request.username()).orElseThrow();
	    var token = jwtService.generateToken(usuario);
	    return new TokenResponse(usuario.getUsername(), token);
	  }
		  
	  private Profile createProfile(UsuarioRequest request) {
		  var usuario = query.findByUsername(request.username()).orElseThrow();
		  var profile = Profile.builder()
				  .biografia(request.biografia())
				  .email(request.email())
				  .name(request.name())
				  .usuarioUUID(usuario.getUuid())
				  .build();
		 profile = profileRep.save(profile);
		 return profile;
	  }
	  
	  public UsuarioResponse findUsuario(String username) {
		  return query.findUsuario(username).orElseThrow();
	  }
	  
	  public Usuario getUsuarioLogado() {
		  String  username = SecurityContextHolder.getContext().getAuthentication().getName();
	      Usuario usuario = query.findByUsername(username).orElseThrow();
	      return usuario;
	  }
}
