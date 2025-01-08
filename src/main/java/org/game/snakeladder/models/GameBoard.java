package org.game.snakeladder.models;

import org.game.snakeladder.enums.Dice;
import org.game.snakeladder.service.LadderService;
import org.game.snakeladder.service.SnakeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class GameBoard {

    private final static Logger LOG = LoggerFactory.getLogger(GameBoard.class.getName());
    private final static Random RANDOM = new Random();

    private final Board[][] boards;
    private final SnakeService snakeService;
    private final LadderService ladderService;

    public GameBoard(SnakeService snakeService,
                     LadderService ladderService,
                     Board[][] boards) {
        this.snakeService = snakeService;
        this.ladderService = ladderService;
        this.boards = boards;
    }

    public void startGame() {
        fillBoards();
    }

    public void rollDice(Player player) {
        LOG.info("Rolling the Dice for player => {}" , player.getName());
        Dice dice = getRandomDice();
        Position currentPosition = player.getCurrentPosition();

        LOG.info("Got this side {} for player {}",dice.name(), player.getName());

        if (((currentPosition.getX() * 10) + currentPosition.getY() + dice.getSide()) > 99 ) {
            LOG.info("Exceeds the maximum point ==> Returning");
            return;
        }

        updatePlayerPosition(player, currentPosition, dice.getSide());
        snakeService.checkSnake(player);
        ladderService.checkLadder(player);
    }

    private Dice getRandomDice() {
        int random = RANDOM.nextInt(1, 6);

        return Dice.retrieveSide(random);
    }

    private void updatePlayerPosition(Player player, Position currentPosition, int random) {
        int i = currentPosition.getX();
        int j = currentPosition.getY();

        while (i < 10 && random > 0) {
            if (j > 8) {
                j = 0;
                i++;
            } else {
                j++;
            }
            random--;
        }

        LOG.info("Updated Position X - {} and Y - {} for player {}",i , j, player.getName());
        LOG.info("The Board Position for player {} is {}", player.getName(), boards[i][j].getBoardNo());

        currentPosition.setX(i);
        currentPosition.setY(j);

        // If we are in the last position (i.e 100) for the board (10 x 10)
        var lastPosition = boards.length - 1;
        if ( i == lastPosition && j == lastPosition) {
            player.setWon(true);
        }
        player.setCurrentPosition(currentPosition);
    }

    private void fillBoards() {
        int count = 0;
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards.length; j++) {
                count++;
                boards[i][j] = new Board(count, new Position(i, j));
            }
        }
    }
}
