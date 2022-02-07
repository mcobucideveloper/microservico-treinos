package com.example.demo;


import com.example.demo.infrastructure.CustomJpaRepositoryImpl;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class MircoservicoTreinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoservicoTreinoApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
	   ModelMapper modelMapper = new ModelMapper();
	   return modelMapper;
	}

}
