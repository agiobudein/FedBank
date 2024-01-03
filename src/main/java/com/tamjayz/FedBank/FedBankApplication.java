package com.tamjayz.FedBank;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "The FedBank Banking App",
				description = "The Backend RestFul API app for Credit, Debit and Transfer Operations",
				version = "v1.0",
				contact = @Contact(
						name = "Dein Agiobu",
						email = "agiobudein@gmail.com",
						url = "https://github.com/agiobudein/FedBank"
				),
				license = @License(
						name = "The FedBank App",
						url = "https://github.com/agiobudein/FedBank"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "The FedBank Documentation",
				url = "https://github.com/agiobudein/FedBank"
		)
)
public class FedBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(FedBankApplication.class, args);
	}

}
