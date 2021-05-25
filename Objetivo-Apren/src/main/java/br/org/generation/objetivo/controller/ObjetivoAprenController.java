package br.org.generation.objetivo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjetivoAprenController {
	
	@GetMapping("/OBJ")
	public String obj() {
		return ("Quero explorar ainda mais o framework Spring Boot,"
				+ "visando meu aprendizado pessoal e meu aprendizado \npara desenvolver o projeto integrador.");
	}
}
