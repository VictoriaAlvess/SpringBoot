package br.org.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.blogpessoal.model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel,Long> {
	
	public List<TemaModel> findAllByDescricaoContainingIgnoreCase(String descricao);
}
