package com.danielraguiar.gamelist.dto;

import com.danielraguiar.gamelist.entities.GameList;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter
public class GameListDTO {
    private Long id;
    private String name;

    public static GameListDTO entityToDto(GameList list) {
        GameListDTO dto = new GameListDTO();
        dto.setId(list.getId());
        dto.setName(list.getName());
        return dto;
    }

    public static List<GameListDTO> entityListToDtoList(List<GameList> content) {
        return content.stream()
                .map(GameListDTO::entityToDto)
                .collect(Collectors.toList());
    }
}
