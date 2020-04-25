package com.technocrats.creatingjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CreatingJoyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreatingJoyApplication.class, args);
	}

}
