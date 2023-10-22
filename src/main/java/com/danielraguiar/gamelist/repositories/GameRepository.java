package com.danielraguiar.gamelist.repositories;

import com.danielraguiar.gamelist.entities.Game;
import com.danielraguiar.gamelist.projections.GameShortProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_position.position
			FROM tb_game
			INNER JOIN tb_position ON tb_game.id = tb_position.game_id
			WHERE tb_position.list_id = :listId
			ORDER BY tb_position.position
				""")
	List<GameShortProjection> searchByList(Long listId);
}
