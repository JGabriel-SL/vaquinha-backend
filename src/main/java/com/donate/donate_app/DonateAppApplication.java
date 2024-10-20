package com.donate.donate_app;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DonateAppApplication {
	Dotenv dotenv = Dotenv.load();
	public static void main(String[] args) {
		SpringApplication.run(DonateAppApplication.class, args);
	}

}
