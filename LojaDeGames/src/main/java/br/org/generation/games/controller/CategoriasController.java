package br.org.generation.games.controller;

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

import br.org.generation.games.model.CategoriasModel;
import br.org.generation.games.repository.CategoriasRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriasController {
	
	@Autowired
	private CategoriasRepository repository;
	
	//findAllCategoria = um endPoint com a capacidade de trazer todas as categorias
	@GetMapping
	public ResponseEntity<List<CategoriasModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	//findByIDCategoria = um endPoint com a função de trazer uma única categoria por id.
	@GetMapping("/{id}") 
	public ResponseEntity<CategoriasModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	//findByDescricaoCategoria = um endPoint com a função de trazer uma categoria turma por Descricao.
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<CategoriasModel>> GetByTitle(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	//postCategoria = um endPoint com a função de gravar uma nova categoria no banco de dados.
	@PostMapping
	public ResponseEntity<CategoriasModel> post(@RequestBody CategoriasModel newCategoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newCategoria));
	}
	
	//putCategoria = um endPoint com a função de atualizar dados de uma categoria.
	@PutMapping
	public ResponseEntity<CategoriasModel> put(@RequestBody CategoriasModel uptadeCategoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(uptadeCategoria));
	}
	
	//deleteCategoria = um endPoint com a função de apagar uma categoria do banco de dados).
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
	
}
