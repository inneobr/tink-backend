package org.inneo.backend.application;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Data;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class ServerController {
	
	@GetMapping
	public Status running() {
		return Status.builder().status(true).message("Aplication is runing...").build();
	}
}

@Data @Builder
class Status {
	private Boolean status;
	private String  message;	
}