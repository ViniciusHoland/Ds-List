package com.devvinicius.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devvinicius.dslist.dto.GameListDTO;
import com.devvinicius.dslist.dto.GameMinDto;
import com.devvinicius.dslist.entities.GameList;
import com.devvinicius.dslist.repositories.GameListRepository;



@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	// o spring indica ao banco de dados que a transação será somente de leitura
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		
		//o game respository retorna tem uma tabela de games e ele retorna esses games para minha variavel result
		// onde vai ter a listagem de todos os games que foram consultados do banco de dados
		List<GameList> result = gameListRepository.findAll();
		
		// stream biblioteca que aceita uma operacao com sequecia de dados 
		// o map transforma objetos em outros no caso o X é o GameList e está transformando o X em GameListDto 
		// e no fim passe tudo para uma lista 
		List<GameListDTO>  dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	
	
	
	
}
