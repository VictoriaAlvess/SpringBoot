package br.org.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.model.TemaModel;
import br.org.generation.blogpessoal.repository.TemaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {

	@Autowired
	private TemaRepository repository;

	// consultar todos os temas
	@GetMapping
	public ResponseEntity<List<TemaModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// consultar tema por id
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	// consultar tema pelo nome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<TemaModel>> getByName(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}

	// gravar tema
	@PostMapping
	public ResponseEntity<TemaModel> post(@RequestBody TemaModel tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}

	// atualizar tema
	@PutMapping
	public ResponseEntity<TemaModel> put(@RequestBody TemaModel tema) {
		return ResponseEntity.ok(repository.save(tema));
	}

	// deletar tema
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
