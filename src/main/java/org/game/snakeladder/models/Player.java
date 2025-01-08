package org.game.snakeladder.models;


public class Player {
    private String name;
    private Position currentPosition;
    private boolean isWon;

    public Player(String name, Position currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }
}
