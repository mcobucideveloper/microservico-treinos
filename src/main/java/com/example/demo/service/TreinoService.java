package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.domain.exception.DefaultException;
import com.example.demo.domain.model.Treino;
import com.example.demo.infrastructure.repository.TreinoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TreinoService {

    private TreinoRepository treinoRepository;


    @Transactional
	public Treino salvar(Treino treino) throws Exception {
		
		
		return treinoRepository.save(treino);	
	}

    public Treino buscarId (Long treinoId){

		return treinoRepository.findById(treinoId).orElseThrow(new DefaultException(HttpStatus.NOT_FOUND,"Treino não encontrado."));

	}

    public Treino atualizar (Long treinoId, Treino treino) throws Exception{

		Treino treinoAtual = buscarId(treinoId);
        

        BeanUtils.copyProperties(treino, treinoAtual, "id");

		return salvar(treinoAtual);

		}

    

    public void excluir (Long treinoId){

		buscarId(treinoId);

		treinoRepository.deleteById(treinoId);


	}
    
    public List<Treino> listar() {
		List<Treino> todosTreinos = treinoRepository.findAll();
		
		return todosTreinos;
    }
    
}
