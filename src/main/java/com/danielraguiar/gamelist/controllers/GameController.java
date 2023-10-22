package com.danielraguiar.gamelist.controllers;

import com.danielraguiar.gamelist.dto.GameDTO;
import com.danielraguiar.gamelist.entities.Game;
import com.danielraguiar.gamelist.projections.GameShortProjection;
import com.danielraguiar.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.danielraguiar.gamelist.dto.GameShortDTO;
import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameShortDTO> findAll() {
        List<GameShortDTO> result = gameService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }
}
