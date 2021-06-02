package br.org.generation.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.games.model.ProdutosModel;


public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long>{

	public List<ProdutosModel> findAllByNomeContainingIgnoreCase(String nome);
}
