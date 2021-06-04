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

import br.org.generation.farmacia.model.ProdutoModel;
import br.org.generation.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	// trazer todos os produtos
		@GetMapping
		public ResponseEntity<List<ProdutoModel>> GetAll() {
			return ResponseEntity.ok(repository.findAll());
		}
		
		// trazer um unico produto por id.
		@GetMapping("{id}")
		public ResponseEntity<ProdutoModel> GetById(@PathVariable long id) {
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
		// trazer trazer um unico produto por nome.
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<ProdutoModel>> GetByDescricao(@PathVariable String nome) {
			return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		}
		
		//gravar um produto
		@PostMapping
		public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel newProduto) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newProduto));
		}
		
		// atualizar produto
		@PutMapping
		public ResponseEntity<ProdutoModel> put(@RequestBody ProdutoModel uptadeProduto) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(uptadeProduto));
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}
	
}
