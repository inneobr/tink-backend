package org.inneo.backend.application;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.inneo.backend.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.inneo.backend.dtos.UsuarioRequest;
import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
@SecurityRequirement(name = "javainuseapi")
@Tag(name = "Auth", description = "Authentication.")
public class AuthController {
	private final UsuarioService service;
	
	@Operation(summary = "Authentication", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "success" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "403", description = "Unavailable or unauthorized." )
	})
	@PostMapping
	public ResponseEntity<?> auth(@RequestBody UsuarioRequest request) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.authenticate(request));
	}
}
