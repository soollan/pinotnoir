package com.wine.pinotnoir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PinotnoirApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinotnoirApplication.class, args);
	}

}
