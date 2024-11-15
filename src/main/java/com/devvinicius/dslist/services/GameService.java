package com.devvinicius.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devvinicius.dslist.dto.GameDTO;
import com.devvinicius.dslist.dto.GameMinDto;
import com.devvinicius.dslist.entities.Game;
import com.devvinicius.dslist.projections.GameMinProjection;
import com.devvinicius.dslist.repositories.GameRepository;



@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	// o spring indica ao banco de dados que a transação será somente de leitura
	@Transactional(readOnly = true)
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
	
	// o spring indica ao banco de dados que a transação será somente de leitura
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		
		Game result = gameRepository.findById(id).get();
		
		// agora sim eu passo minha entidade game e chamo meu construtor passando a entidade e vai preencher 
		// na minha classe gameDTo sem precisar da conversão que fiz no metodo findAll
		GameDTO dto = new GameDTO(result);
		
		return dto;
	}
	
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findByList(Long listId){
		
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		
		List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
		return dto;
		
	}
	
	
	
	
}
