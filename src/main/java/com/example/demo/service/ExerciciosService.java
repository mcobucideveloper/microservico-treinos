package com.example.demo.service;

import javax.transaction.Transactional;

import com.example.demo.domain.model.Exercicios;
import com.example.demo.infrastructure.repository.ExerciciosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ExerciciosService {

    @Autowired
    private ExerciciosRepository exerciciosRepository;

    @Transactional
	public Exercicios salvar(Exercicios exercicios) throws Exception {
		
		encrontraDescricao(exercicios.getDescricao());
		
		return exerciciosRepository.save(exercicios);	
	}


    public void encrontraDescricao ( String descricao ) throws Exception {
		
		
        var Exercicos =  exerciciosRepository.findByDescricao(descricao);
        
    }

    
}
