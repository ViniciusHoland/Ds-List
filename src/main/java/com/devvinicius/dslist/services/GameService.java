package com.devvinicius.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devvinicius.dslist.dto.GameMinDto;
import com.devvinicius.dslist.entities.Game;
import com.devvinicius.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDto> findAll() {
		
		//o game respository retorna tem uma tabela de games e ele retorna esses games para minha variavel result
		// onde vai ter a listagem de todos os games que foram consultados do banco de dados
		List<Game> result = gameRepository.findAll();
		
		// stream biblioteca que aceita uma operacao com sequecia de dados 
		// o map transforma objetos em outros no caso o X é o Game e está transformando o X em GameMinDto 
		// e no fim passe tudo para uma lista 
		List<GameMinDto>  dto = result.stream().map(x -> new GameMinDto(x)).toList();
		return dto;
	}
	
	
}
