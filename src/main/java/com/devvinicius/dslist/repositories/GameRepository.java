package com.devvinicius.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devvinicius.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
