package com.example.demo.api.controller;

import javax.validation.Valid;

import com.example.demo.api.assembler.ExerciciosAssembler;
import com.example.demo.api.assembler.ExerciciosDisassembler;
import com.example.demo.api.model.ExerciciosModel;
import com.example.demo.api.model.input.ExerciciosInput;
import com.example.demo.domain.model.Exercicios;
import com.example.demo.service.ExerciciosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exercicios")
public class ExerciciosController {

    @Autowired
    private ExerciciosService exerciciosService;

    @Autowired
    private ExerciciosDisassembler exerciciosDisassembler;

    @Autowired
    private ExerciciosAssembler exerciciosAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExerciciosModel adicionar (@RequestBody @Valid ExerciciosInput exerciciosInput) throws Exception {
        
        Exercicios exercicios = exerciciosDisassembler.toDomainObject(exerciciosInput);
        exercicios = exerciciosService.salvar(exercicios);

        var objeto = exerciciosAssembler.toModel(exercicios);

        return objeto;
    } 
}
