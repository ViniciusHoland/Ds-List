package com.devvinicius.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devvinicius.dslist.dto.GameDTO;
import com.devvinicius.dslist.dto.GameListDTO;
import com.devvinicius.dslist.dto.GameMinDto;
import com.devvinicius.dslist.entities.Game;
import com.devvinicius.dslist.services.GameListService;
import com.devvinicius.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		
		List<GameListDTO> result = gameListService.findAll();
		
		return result;
	}
	
	@GetMapping(value = "/{id}/games")
	public List<GameMinDto> findByList(@PathVariable Long id){
		 
		List<GameMinDto> result = gameService.findByList(id);
		
		return result;
	}
	
	
}
