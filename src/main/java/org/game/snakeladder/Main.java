package org.game.snakeladder;


import org.game.snakeladder.models.Board;
import org.game.snakeladder.models.GameBoard;
import org.game.snakeladder.models.Player;
import org.game.snakeladder.models.Position;
import org.game.snakeladder.service.LadderService;
import org.game.snakeladder.service.SnakeService;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the Snake and Ladder Game!");

        var snakeService = new SnakeService();
        var ladderService = new LadderService();
        var gameBoard = new GameBoard(snakeService, ladderService, new Board[10][10]);
        gameBoard.startGame();

        var playerQueue = new LinkedList<>(List.of(
            new Player("Jeyam", new Position(0, 0)),
            new Player("Stunna", new Position(0, 0))
        ));

        while (!playerQueue.isEmpty()) {
            var currentPlayer = playerQueue.poll();
            gameBoard.rollDice(currentPlayer);
            if (currentPlayer.isWon()) {
                System.out.printf("Player %s won \n", currentPlayer.getName());
                break;
            }
            playerQueue.add(currentPlayer);
        }

        System.out.println("Game Over!");
    }
}