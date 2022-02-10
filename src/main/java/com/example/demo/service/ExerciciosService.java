package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.api.model.ExerciciosModel;
import com.example.demo.domain.exception.DefaultException;
import com.example.demo.domain.model.Exercicios;
import com.example.demo.infrastructure.repository.ExerciciosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    public List<Exercicios> listar() {
		List<Exercicios> todosExercicios = exerciciosRepository.findAll();
		
		return todosExercicios;
    }

    public void encrontraDescricao ( String descricao ) throws Exception {

        var exercicio = exerciciosRepository.findByDescricao(descricao);
		
        if(exercicio.isPresent()) {
			
			throw new DefaultException(HttpStatus.BAD_REQUEST, "Descrição desse exercicio já existe.");		
		}
	
	}
        
}

    

