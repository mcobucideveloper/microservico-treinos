package com.example.demo.infrastructure.repository;

import java.util.Optional;

import com.example.demo.domain.model.TipoProfissional;

import org.springframework.stereotype.Repository;

@Repository
public interface TipoProfissionalRepository extends  CustomJpaRepository<TipoProfissional, Long> { 

    Optional<TipoProfissional> findByDescricao(String descricao);
    
}
