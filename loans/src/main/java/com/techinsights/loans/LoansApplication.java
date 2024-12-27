package com.techinsights.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "FinSafe Bank Loans microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Ramesh Yadav",
						email = "tech.insights@gmail.com",
						url = "https://www.techinsights.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.techinsights.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "FinSafe Bank Loans microservice REST API Documentation",
				url = "https://www.techinsights.com/swagger-ui.html"
		)
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
