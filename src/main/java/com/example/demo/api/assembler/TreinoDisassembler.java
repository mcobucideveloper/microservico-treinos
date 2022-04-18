package com.example.demo.api.assembler;


import com.example.demo.api.model.input.TreinoInput;
import com.example.demo.domain.model.Treino;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TreinoDisassembler {
    @Autowired
    private ModelMapper modelMapper;
 
    public Treino toDomainObject(TreinoInput treinoInput) {

        var objeto = modelMapper.map(treinoInput, Treino.class);
        return objeto;
 }

    public void copyToDomainObject(TreinoInput treinoInput, Treino treino) {
        
        modelMapper.map(treinoInput, treino);
    }
}
