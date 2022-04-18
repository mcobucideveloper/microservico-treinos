package com.example.demo.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.api.model.TipoProfissionalModel;
import com.example.demo.domain.model.TipoProfissional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TipoProfissionalAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public TipoProfissionalModel toModel(TipoProfissional tipoProfissional) {

        return modelMapper.map(tipoProfissional, TipoProfissionalModel.class);
    }

    public List<TipoProfissionalModel> toCollectionModel(List<TipoProfissional> tiposProfissional) {
        return tiposProfissional.stream()
                .map(tipoProfissional -> toModel(tipoProfissional))
                .collect(Collectors.toList());
    }

}
