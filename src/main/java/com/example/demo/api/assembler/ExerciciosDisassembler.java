package com.example.demo.api.assembler;

import com.example.demo.api.model.input.ExerciciosInput;
import com.example.demo.domain.model.Exercicios;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExerciciosDisassembler {
    @Autowired
    private ModelMapper modelMapper;
 
    public Exercicios toDomainObject(ExerciciosInput exerciciosInput) {

        var objeto = modelMapper.map(exerciciosInput, Exercicios.class);
        return objeto;
 }

    public void copyToDomainObject(ExerciciosInput exerciciosInput, Exercicios exercicios) {
        
        modelMapper.map(exerciciosInput, exercicios);
    }
}
