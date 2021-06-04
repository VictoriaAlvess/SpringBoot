package br.org.generation.farmacia.controller;

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

import br.org.generation.farmacia.model.CategoriaModel;
import br.org.generation.farmacia.repository.CategoriaRepository;


//classe controladora
@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	// trazer todas as categorias
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	// trazer uma única categoria por id.
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	//trazer uma categoria turma por Descricao.
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<CategoriaModel>> GetByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	//gravar uma nova categoria no banco de dados.
	@PostMapping
	public ResponseEntity<CategoriaModel> post(@RequestBody CategoriaModel newCategorias) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newCategorias));
	}
	
	//atualizar dados de uma categoria.
	@PutMapping
	public ResponseEntity<CategoriaModel> put(@RequestBody CategoriaModel updateCategorias) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(updateCategorias));
	}
	
	//apagar uma categoria do banco de dados.
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
