package com.techeer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GoodNightApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodNightApiApplication.class, args);
    }
}
