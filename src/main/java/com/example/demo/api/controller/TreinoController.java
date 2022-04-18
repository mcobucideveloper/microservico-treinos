package com.example.demo.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.api.assembler.TreinoAssembler;
import com.example.demo.api.assembler.TreinoDisassembler;
import com.example.demo.api.model.TreinoModel;
import com.example.demo.api.model.input.TreinoInput;
import com.example.demo.domain.model.Treino;
import com.example.demo.service.TreinoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/treino")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @Autowired
    private TreinoDisassembler treinoDisassembler;

    @Autowired
    private TreinoAssembler treinoAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TreinoModel adicionar (@RequestBody @Valid TreinoInput treinoInput) throws Exception {
        
        Treino treino = treinoDisassembler.toDomainObject(treinoInput);
        treino = treinoService.salvar(treino);

        var objeto = treinoAssembler.toModel(treino);

        return objeto;
    } 
 

    @DeleteMapping("/{treinoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long treinoId) {

		treinoService.excluir(treinoId);
	}

     @GetMapping
	public List<TreinoModel> listar() {
		List<Treino> todosTreinos = treinoService.listar();
		
		return treinoAssembler.toCollectionModel(todosTreinos);
    }

    @GetMapping("/{treinoId}")
	public TreinoModel buscar(@PathVariable Long treinoId) {

		var treino = treinoService.buscarId(treinoId);

        return treinoAssembler.toModel(treino);
	}

    @PutMapping("/{treinoId}")
	public Treino atualizar(@PathVariable Long treinoId, @RequestBody Treino treino) throws Exception {

      return treinoService.atualizar(treinoId, treino);

    }
    
    
    

    
}
