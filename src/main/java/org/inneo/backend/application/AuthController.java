package org.inneo.backend.application;

import lombok.RequiredArgsConstructor;
import org.inneo.backend.dtos.AuthRequest;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.inneo.backend.service.OperadorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
@Tag(name = "Authenticação", description = "Apis de authenticação.")
public class AuthController {
	private final OperadorService service;

	@Operation(summary = "Autenticação", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Publicado com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	@PostMapping
	public ResponseEntity<?> authenticar(@RequestBody AuthRequest request) {
		try {
			return ResponseEntity.status(201).body(service.authenticar(request));
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
