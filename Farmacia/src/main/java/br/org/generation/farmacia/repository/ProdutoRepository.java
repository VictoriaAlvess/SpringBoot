package br.org.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.farmacia.model.ProdutoModel;


public interface ProdutoRepository  extends JpaRepository<ProdutoModel, Long> {
	public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);
}
