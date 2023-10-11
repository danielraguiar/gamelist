package com.danielraguiar.gamelist.services;

import com.danielraguiar.gamelist.dto.GameListDTO;
import com.danielraguiar.gamelist.dto.GameShortDTO;
import com.danielraguiar.gamelist.entities.Game;
import com.danielraguiar.gamelist.entities.GameList;
import com.danielraguiar.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return GameListDTO.entityListToDtoList(result);
    }
}
