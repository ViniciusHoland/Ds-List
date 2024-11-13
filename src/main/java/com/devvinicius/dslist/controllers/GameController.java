package com.devvinicius.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devvinicius.dslist.dto.GameMinDto;
import com.devvinicius.dslist.entities.Game;
import com.devvinicius.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDto> findAll(){
		
		List<GameMinDto> result = gameService.findAll();
		
		return result;
	}
	
}
