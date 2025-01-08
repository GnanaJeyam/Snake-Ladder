package org.game.snakeladder;


import org.game.snakeladder.models.Board;
import org.game.snakeladder.models.GameBoard;
import org.game.snakeladder.models.Player;
import org.game.snakeladder.models.Position;
import org.game.snakeladder.service.LadderService;
import org.game.snakeladder.service.SnakeService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the Snake and Ladder Game!");

        var snakeService = new SnakeService();
        var ladderService = new LadderService();
        GameBoard gameBoard = new GameBoard(snakeService, ladderService, new Board[10][10]);
        gameBoard.startGame();

        Player player1 = new Player("Jeyam", new Position(0, 0));
        Player player2 = new Player("Stunna", new Position(0, 0));

        while (true) {
            gameBoard.rollDice(player1);
            if (player1.isWon()) {
                System.out.printf("Player %s won \n", player1.getName());
                break;
            }

            gameBoard.rollDice(player2);
            if (player2.isWon()) {
                System.out.printf("Player %s won \n", player2.getName());
                break;
            }
        }

        System.out.println("Game Over!");
    }
}