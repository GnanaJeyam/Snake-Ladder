package org.game.snakeladder.models;

public class Board {
    private final int boardNo;
    private final Position boardPosition;

    public Board(int boardNo, Position boardPosition) {
        this.boardNo = boardNo;
        this.boardPosition = boardPosition;
    }

    public int getBoardNo() {
        return boardNo;
    }
}
