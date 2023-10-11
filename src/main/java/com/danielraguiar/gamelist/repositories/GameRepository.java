package com.danielraguiar.gamelist.repositories;

import com.danielraguiar.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
