package com.cmed.PrescriptionSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.cmed")
@EntityScan(basePackages = { "com.cmed.model" })
@EnableJpaRepositories(basePackages = { "com.cmed" })
public class PrescriptionSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrescriptionSystemApplication.class, args);
	}

}
