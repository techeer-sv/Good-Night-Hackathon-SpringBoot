package com.techeer.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TecheerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecheerApplication.class, args);
	}

}
