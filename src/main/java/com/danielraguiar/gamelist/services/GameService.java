package com.danielraguiar.gamelist.services;

import com.danielraguiar.gamelist.dto.GameDTO;
import com.danielraguiar.gamelist.entities.Game;
import com.danielraguiar.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    public List<GameDTO> findAll() {
       List<Game> games = gameRepository.findAll();
       return GameDTO.entityListToDtoList(games);
    }
}
