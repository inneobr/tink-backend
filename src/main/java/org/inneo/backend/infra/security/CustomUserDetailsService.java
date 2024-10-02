package org.inneo.backend.infra.security;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;
import org.inneo.backend.reposit.OperadorRep;
import org.inneo.backend.domain.Operador;

import lombok.RequiredArgsConstructor;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final OperadorRep query;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Operador operador = this.query.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
        return new org.springframework.security.core.userdetails.User(operador.getUsername(), operador.getPassword(), new ArrayList<>());
    }

}
