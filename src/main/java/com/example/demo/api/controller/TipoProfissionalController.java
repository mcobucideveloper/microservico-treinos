package com.example.demo.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.api.assembler.TipoProfissionalAssembler;
import com.example.demo.api.assembler.TipoProfissionalDisassembler;
import com.example.demo.api.model.TipoProfissionalModel;
import com.example.demo.api.model.input.TipoProfissionalInput;
import com.example.demo.domain.model.TipoProfissional;
import com.example.demo.service.TipoProfissionalService;

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
@RequestMapping(value = "/tipoProfissional")
public class TipoProfissionalController {

	@Autowired
    private TipoProfissionalService tipoProfissionalService;

    @Autowired
    private TipoProfissionalDisassembler tipoProfissionalDisassembler;

    @Autowired
    private TipoProfissionalAssembler tipoProfissionalAssembler;

	@GetMapping
	public List<TipoProfissionalModel> listar() {
		List<TipoProfissional> todosTiposProfissional = tipoProfissionalService.listar();
		
		return tipoProfissionalAssembler.toCollectionModel(todosTiposProfissional);
    }
    
    

    @GetMapping("/{tipoProfissionalId}")
	public TipoProfissionalModel buscar(@PathVariable Long tipoProfissionalId) {

		var tipoProfissional = tipoProfissionalService.buscarId(tipoProfissionalId);

        return tipoProfissionalAssembler.toModel(tipoProfissional);
	}
 

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoProfissionalModel adicionar (@RequestBody @Valid TipoProfissionalInput tipoProfissionalInput) throws Exception {
        
        TipoProfissional tipoProfissional = tipoProfissionalDisassembler.toDomainObject(tipoProfissionalInput);
        tipoProfissional = tipoProfissionalService.salvar(tipoProfissional);

        var objeto = tipoProfissionalAssembler.toModel(tipoProfissional);

        return objeto;
    } 


    @DeleteMapping("/{tipoProfissionalId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long tipoProfissionalId) {

		tipoProfissionalService.excluir(tipoProfissionalId);
	}

	
    @PutMapping("/{tipoProfissionalId}")
	public TipoProfissional atualizar(@PathVariable Long tipoProfissionalId, @RequestBody TipoProfissional tipoProfissional) throws Exception {

      return tipoProfissionalService.atualizar(tipoProfissionalId, tipoProfissional);

    }

}

    

