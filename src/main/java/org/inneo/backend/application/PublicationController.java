package org.inneo.backend.application;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import org.inneo.backend.service.PublicationService;
import org.springframework.data.web.PageableDefault;
import org.inneo.backend.dtos.PublicationRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Sort;

import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/publication")
@SecurityRequirement(name = "javainuseapi")
@Tag(name = "Publication", description = "Controller.")
public class PublicationController {
	private final PublicationService service;
	
	@Operation(summary = "Post publication", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "success" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "403", description = "Unavailable or unauthorized." )
	})
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PublicationRequest request) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@Operation(summary = "Get publication", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "success" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "403", description = "Unavailable or unauthorized." )
	})
	@GetMapping
	public ResponseEntity<?> findAll(@PageableDefault(page = 0, size = 20, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.findPublication(pageable));
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
}
