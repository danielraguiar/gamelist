package com.danielraguiar.gamelist.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Position {

    @EmbeddedId
    private PositionPK id;

    private Integer position;
}
