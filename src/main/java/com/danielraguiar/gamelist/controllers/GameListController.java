package com.danielraguiar.gamelist.controllers;

import com.danielraguiar.gamelist.dto.GameDTO;
import com.danielraguiar.gamelist.dto.GameListDTO;
import com.danielraguiar.gamelist.dto.GameShortDTO;
import com.danielraguiar.gamelist.projections.GameShortProjection;
import com.danielraguiar.gamelist.services.GameListService;
import com.danielraguiar.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;
    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameShortDTO> findByList(@PathVariable Long listId) {
        List<GameShortDTO> result = gameService.findByList(listId);
        return result;
    }
}
