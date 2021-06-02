package br.org.generation.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.games.model.CategoriasModel;


public interface CategoriasRepository extends JpaRepository<CategoriasModel, Long>  {
	
	public List<CategoriasModel> findAllByDescricaoContainingIgnoreCase(String descricao);
}
