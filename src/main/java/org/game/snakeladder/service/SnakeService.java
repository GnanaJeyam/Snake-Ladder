package org.game.snakeladder.service;

import org.game.snakeladder.models.Player;
import org.game.snakeladder.models.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static java.util.Objects.nonNull;

public class SnakeService {
    private final static Logger LOG = LoggerFactory.getLogger(SnakeService.class.getName());
    private final Map<Position, Position> snakes;

    public SnakeService() {
        this.snakes = getSnakes();
    }

    private static Map<Position, Position> getSnakes() {

        return Map.of(
                new Position(3,5), new Position(1,5),
                new Position(8, 5), new Position(5, 3),
                new Position(6,1), new Position(4, 7)
        );
    }

    public void checkSnake(Player player) {
        Position position = snakes.get(player.getCurrentPosition());
        if(nonNull(position)) {
            LOG.info("Found Snake ========> Moving Down <<<<<<<<< for player {}",player.getName());
            player.setCurrentPosition(position);
            LOG.info("Position after SnakeBite X - {} and Y - {} for player {}", position.getX(), position.getY(), player.getName());
        }
    }
}
