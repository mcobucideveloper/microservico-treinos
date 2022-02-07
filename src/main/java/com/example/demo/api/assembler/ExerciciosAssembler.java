package com.example.demo.api.assembler;

import com.example.demo.domain.model.Exercicios;
import com.example.demo.api.model.ExerciciosModel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExerciciosAssembler {



    @Autowired
    private ModelMapper modelMapper;

    public ExerciciosModel toModel(Exercicios exercicios) {

        return modelMapper.map(exercicios, ExerciciosModel.class);
    }
}


    

