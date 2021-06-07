package br.org.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.org.generation.blogpessoal.model.PostagemModel;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

	public List<PostagemModel> findAllByTituloContainingIgnoreCase(String titulo);
}
