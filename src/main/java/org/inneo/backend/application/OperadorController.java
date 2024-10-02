package org.inneo.backend.application;

import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.inneo.backend.dtos.RegisterRequest;

import org.springframework.http.ResponseEntity;
import org.inneo.backend.service.OperadorService;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/operador")
@SecurityRequirement(name = "javainuseapi")
@Tag(name = "Operadores", description = "Apis de operadores.")
public class OperadorController {
	private final OperadorService service;

	@Operation(summary = "Cadastro de dados", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cadastrado com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "" )
	})
	@PostMapping
	public ResponseEntity<?> create(@RequestBody RegisterRequest request) {
		try {
			service.create(request);
			return ResponseEntity.ok("success");
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@Operation(summary = "Update de dados", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cadastrado com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "" )
	})
	@PutMapping
	public ResponseEntity<?> update(@RequestBody RegisterRequest request) {
		try {
			service.update(request);
			return ResponseEntity.ok("success");
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
}
