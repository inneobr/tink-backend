package org.inneo.backend.infra.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;

import jakarta.servlet.ServletException;
import org.springframework.lang.NonNull;
import lombok.RequiredArgsConstructor;

import jakarta.servlet.FilterChain;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter  extends OncePerRequestFilter{
	private final JwtService jwtService;
	private final UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(
		@NonNull HttpServletRequest request,
		@NonNull HttpServletResponse response,
		@NonNull FilterChain filterChain) throws ServletException, IOException {
    	final String authHeader = request.getHeader("Authorization");
    	final String username;
    	final String jwt;
    	
    	if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
    		filterChain.doFilter(request, response);
    		return;
    	}
    	
    	try {
    		jwt = authHeader.substring(7);	
    		username = jwtService.extractUsername(jwt); 	 
    		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
    			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);	
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); 
        
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));				 
				SecurityContextHolder.getContext().setAuthentication(authToken);				 
    			
    		}	 
		 	filterChain.doFilter(request, response);
		 	
    	}catch (Exception e) {	    		  
    		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    		Map<String, String> unauthorized = new HashMap<>();
    		unauthorized.put("unauthorized", "Token invalido ou expirado!");
    		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    		new ObjectMapper().writeValue(response.getOutputStream(), unauthorized);    		
    	}		 	
	}		

}
