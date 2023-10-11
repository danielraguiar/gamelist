package com.danielraguiar.gamelist.dto;

import com.danielraguiar.gamelist.entities.Game;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;


    public static GameDTO entityToDto(Game game) {
        GameDTO dto = new GameDTO();
        dto.setId(game.getId());
        dto.setYear(game.getYear());
        dto.setTitle(game.getTitle());
        dto.setImgUrl(game.getImgUrl());
        dto.setShortDescription(game.getShortDescription());
        return dto;
    }

    public static List<GameDTO> entityListToDtoList(List<Game> content) {
        return content.stream()
                .map(GameDTO::entityToDto)
                .collect(Collectors.toList());

    }
}
