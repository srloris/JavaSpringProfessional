package com.devsuperior.relacionamentosJPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RelacionamentosJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RelacionamentosJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicação iniciada. Pressione CTRL+C para encerrar...");
		Thread.currentThread().join();
	}
}
