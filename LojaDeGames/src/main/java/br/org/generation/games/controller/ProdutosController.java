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

import br.org.generation.games.model.ProdutosModel;
import br.org.generation.games.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository repository;
	
	//findAllProduto = um endPoint com a capacidade de trazer todos os Produtos
	@GetMapping
	public ResponseEntity<List<ProdutosModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	//findByIDProduto = um endPoint com a função de trazer uma único Produto por id.
	@GetMapping("/{id}")
	public ResponseEntity<ProdutosModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	//findByDescricaoTitulo = um endPoint com a função de trazer um único Produto por Titulo.
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutosModel>> GetByTitle(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	//postProduto = um endPoint com a função de gravar um novo Produto no banco de dados.
	@PostMapping
	public ResponseEntity<ProdutosModel> post(@RequestBody ProdutosModel newProduto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newProduto));
	}
	
	//putProduto = um endPoint com a função de atualizar dados de um Produto
	@PutMapping
	public ResponseEntity<ProdutosModel> put(@RequestBody ProdutosModel uptadeProduto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(uptadeProduto));
	}
	
	//deleteProduto = um endPoint com a função de apagar um Produto do banco de dados).
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
