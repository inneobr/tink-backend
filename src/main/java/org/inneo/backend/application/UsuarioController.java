package org.inneo.backend.application;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.inneo.backend.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.inneo.backend.dtos.UsuarioRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuario")
@SecurityRequirement(name = "javainuseapi")
@Tag(name = "Usuários", description = "Controller.")
public class UsuarioController {
	private final UsuarioService service;

	@Operation(summary = "Post usuário", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "success" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "403", description = "Unavailable or unauthorized." )
	})
	@PostMapping
	public ResponseEntity<?> create(@RequestBody UsuarioRequest request) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@Operation(summary = "Get usuário", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "success" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "403", description = "Unavailable or unauthorized." )
	})
	@GetMapping
	public ResponseEntity<?> findByUsername(@RequestParam(name="username") String username) {
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.findByUsername(username));
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	
}
