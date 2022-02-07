package com.example.demo.infrastructure.repository;

import java.util.Optional;

import com.example.demo.domain.model.Exercicios;

import org.springframework.stereotype.Repository;



@Repository
public interface ExerciciosRepository extends  CustomJpaRepository<Exercicios, Long> {
	
	Optional<Exercicios> findByDescricao(String descricao);	









	
}
