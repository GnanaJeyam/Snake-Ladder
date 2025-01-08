package org.game.snakeladder.service;

import org.game.snakeladder.models.Player;
import org.game.snakeladder.models.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static java.util.Objects.nonNull;

public class LadderService {
    private final static Logger LOG = LoggerFactory.getLogger(LadderService.class.getName());
    private final Map<Position, Position> ladders;

    public LadderService() {
        this.ladders = getLadders();
    }

    private static Map<Position, Position> getLadders() {

        return Map.of(
           new Position(0,7), new Position(1,7),
           new Position(3, 4), new Position(6, 8),
           new Position(5, 5), new Position(8,8)
        );
    }

    public void checkLadder(Player player) {
        Position position = ladders.get(player.getCurrentPosition());
        if(nonNull(position)) {
            LOG.info("Found Ladder ========> Moving UP >>>>>> for player {}",player.getName());
            player.setCurrentPosition(position);
            LOG.info("Position after Ladder X - {} and Y - {} for player {}", position.getX(), position.getY(), player.getName());
        }
    }
}