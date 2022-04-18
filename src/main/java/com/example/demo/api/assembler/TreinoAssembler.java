package com.example.demo.api.assembler;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.api.model.TreinoModel;
import com.example.demo.domain.model.Treino;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TreinoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public TreinoModel toModel(Treino treino) {

        return modelMapper.map(treino, TreinoModel.class);
    }

    public List<TreinoModel> toCollectionModel(List<Treino> Treinos) {
        return Treinos.stream()
                .map(treino -> toModel(treino))
                .collect(Collectors.toList());
    }

}