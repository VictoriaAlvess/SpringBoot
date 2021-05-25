package br.org.generation.habilimentali.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Annotation que indica que é uma classe controladora
public class HabiliMentaliController {
	
	@GetMapping("/HabiliMentali")
	public String HM() {
		return ("Mentalidade: Persistência"
				+ "\nHabilidade: Orientação aos detalhes");
		
	}
}
