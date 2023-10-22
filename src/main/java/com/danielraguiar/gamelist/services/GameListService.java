package com.danielraguiar.gamelist.services;

import com.danielraguiar.gamelist.dto.GameListDTO;
import com.danielraguiar.gamelist.dto.GameShortDTO;
import com.danielraguiar.gamelist.entities.Game;
import com.danielraguiar.gamelist.entities.GameList;
import com.danielraguiar.gamelist.projections.GameShortProjection;
import com.danielraguiar.gamelist.repositories.GameListRepository;
import com.danielraguiar.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return GameListDTO.entityListToDtoList(result);
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameShortProjection> list = gameRepository.searchByList(listId);
        GameShortProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for( int i = min ; i <= max ; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
