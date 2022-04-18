package com.example.demo.api.assembler;

import com.example.demo.api.model.input.TipoProfissionalInput;
import com.example.demo.domain.model.TipoProfissional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TipoProfissionalDisassembler {
    @Autowired
    private ModelMapper modelMapper;
 
    public TipoProfissional toDomainObject(TipoProfissionalInput tipoProfissionalInput) {

        var objeto = modelMapper.map(tipoProfissionalInput, TipoProfissional.class);
        return objeto;
 }

    public void copyToDomainObject(TipoProfissionalInput tipoProfissionalInput, TipoProfissional tipoProfissional) {
        
        modelMapper.map(tipoProfissionalInput, tipoProfissional);
    }
}
