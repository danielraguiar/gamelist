package com.danielraguiar.gamelist.dto;

import com.danielraguiar.gamelist.entities.Game;
import jakarta.persistence.Column;
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

    private String genre;

    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public static GameDTO entityToDto(Game game) {
        GameDTO dto = new GameDTO();
        dto.setId(game.getId());
        dto.setYear(game.getYear());
        dto.setTitle(game.getTitle());
        dto.setImgUrl(game.getImgUrl());
        dto.setGenre(game.getGenre());
        dto.setShortDescription(game.getShortDescription());
        dto.setLongDescription(game.getLongDescription());
        dto.setPlatforms(game.getPlatforms());
        dto.setScore(game.getScore());
        return dto;
    }

    public static List<GameDTO> entityListToDtoList(List<Game> content) {
        return content.stream()
                .map(GameDTO::entityToDto)
                .collect(Collectors.toList());
    }
}
