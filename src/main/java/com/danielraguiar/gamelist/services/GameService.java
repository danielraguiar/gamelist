package com.danielraguiar.gamelist.services;

import com.danielraguiar.gamelist.dto.GameDTO;
import com.danielraguiar.gamelist.dto.GameShortDTO;
import com.danielraguiar.gamelist.entities.Game;
import com.danielraguiar.gamelist.projections.GameShortProjection;
import com.danielraguiar.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameShortDTO> findAll() {
       List<Game> games = gameRepository.findAll();
       return GameShortDTO.entityListToDtoList(games);
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return GameDTO.entityToDto(result);
    }

    @Transactional(readOnly = true)
    public List<GameShortDTO> findByList(Long listId) {
        List<GameShortProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(GameShortDTO::new).toList();
    }
}
