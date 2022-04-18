package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.domain.exception.DefaultException;
import com.example.demo.domain.model.TipoProfissional;
import com.example.demo.infrastructure.repository.TipoProfissionalRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TipoProfissionalService {

	@Autowired
    private TipoProfissionalRepository tipoProfissionalRepository;
	
	@Transactional
	public TipoProfissional salvar(TipoProfissional tipoProfissional) throws Exception {
		return tipoProfissionalRepository.save(tipoProfissional);	
	}

  
	public TipoProfissional buscarId (Long tipoProfissionalId){

		return tipoProfissionalRepository.findById(tipoProfissionalId).orElseThrow(new DefaultException(HttpStatus.NOT_FOUND,"Profissional não encontrado"));

	}
	
	public  List<TipoProfissional> listar() {
		List<TipoProfissional> todosTipoProfissional = tipoProfissionalRepository.findAll();
		
		return todosTipoProfissional;
    }

	public void encrontraDescricao ( String descricao ) throws Exception {

        var tipoProfissional = tipoProfissionalRepository.findByDescricao(descricao);
		
        if(tipoProfissional.isPresent()) {
			
			throw new DefaultException(HttpStatus.BAD_REQUEST, "Descrição desse Tipo Profissional já existe.");		
		}
	
	}

    public void excluir (Long tipoProfissionalId){

		buscarId(tipoProfissionalId);

		tipoProfissionalRepository.deleteById(tipoProfissionalId);
		
	}
   
	public TipoProfissional atualizar (Long tipoProfissionalId, TipoProfissional tipoProfissional) throws Exception{

		TipoProfissional tipoProfissionalAtual = buscarId(tipoProfissionalId);
        

        BeanUtils.copyProperties(tipoProfissional, tipoProfissionalAtual, "id");

		return salvar(tipoProfissionalAtual);

	} 
}
