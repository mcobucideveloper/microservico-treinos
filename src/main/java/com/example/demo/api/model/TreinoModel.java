package com.example.demo.api.model;

import lombok.Data;

@Data
public class TreinoModel {

    private Long id;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}
