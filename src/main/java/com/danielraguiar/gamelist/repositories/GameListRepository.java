package com.danielraguiar.gamelist.repositories;

import com.danielraguiar.gamelist.entities.Game;
import com.danielraguiar.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
