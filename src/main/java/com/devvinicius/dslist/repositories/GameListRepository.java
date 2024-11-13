package com.devvinicius.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devvinicius.dslist.entities.Game;
import com.devvinicius.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
