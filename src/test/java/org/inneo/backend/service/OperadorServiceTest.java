package org.inneo.backend.service;
/*
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.hamcrest.MatcherAssert.assertThat;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.inneo.backend.reposit.OperadorRep;
import static org.hamcrest.CoreMatchers.is;
import org.inneo.backend.domain.Operador;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.Optional;
import org.mockito.Mock;*/

//@ExtendWith(MockitoExtension.class)
public class OperadorServiceTest {

	//@InjectMocks
	//OperadorService service;
	
	//@Mock
	//private PasswordEncoder bcrypt;	
	
	//@Mock
	//OperadorRep query;	
	
	//Operador operador;
	
	//@BeforeEach
	public void setUp() {
	}	
	
	/*
	@Test
	@DisplayName("Deve cadastrar um novo operador")
	void createNewOperadorSuccess() throws Exception {
		when(query.save(operador)).thenReturn(operador);
		service.create(request);
		verify(query).save(operador);
		verifyNoMoreInteractions(query);
	}
	
	@Test
	@DisplayName("Deve authenticar um operador")
	void authSuccess() {
		authRequest = new AuthRequest("projeto", "tulipa");
		when(query.findByUsername(operador.getUsername())).thenReturn(Optional.of(operador));
		token = service.authenticar(authRequest);	
	}
	
	@Test
	@DisplayName("Devegerar uma exception por senha incorreta")
	void authNotAuthorized() throws Exception {
		authRequest = new AuthRequest("projeto", "projeto");
		when(query.findByUsername(operador.getUsername())).thenThrow(new RuntimeException("Unauthorized"));		
		
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			this.service.authenticar(authRequest);
		});
		
        assertThat(e.getMessage(), is("Unauthorized"));
        verify(query).findByUsername(operador.getUsername());
	}*/
}
