package org.inneo.backend.infra.security;

import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import org.inneo.backend.reposit.TokenRep;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler{
	private final TokenRep tokenRep;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    
    jwt = authHeader.substring(7);
    
    var storedToken = tokenRep.findByToken(jwt).orElse(null);
    
    if (storedToken != null) {
      storedToken.setExpired(true);
      storedToken.setRevoked(true);
      tokenRep.save(storedToken);
      SecurityContextHolder.clearContext();
    }
  }

}
