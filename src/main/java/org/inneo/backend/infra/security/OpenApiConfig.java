package org.inneo.backend.infra.security;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
			.info(new Info().title("INNEO _V1.0")
			.version("1.0")
			.description("INNEO SERVICES API")	
			.license(new License()
					.name("Apache License Version 2.0")
					.url("https://www.apache.org/licenses/LICENSE-2.0.txt"))
			);
	}
}
