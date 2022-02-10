package com.example.demo.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.api.model.ExerciciosModel;
import com.example.demo.domain.model.Exercicios;

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

    public List<ExerciciosModel> toCollectionModel(List<Exercicios> exercicios) {
        return exercicios.stream()
                .map(exercicio -> toModel(exercicio))
                .collect(Collectors.toList());
    }

}
    

