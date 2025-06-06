package com.example.controleponto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class ControlepontoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlepontoApplication.class, args);
	}

}
