package com.onufrei.sn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SnSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
