package com.jeffmathieu.game;

public class Game {
    private Board board;
    private int score;

    public Game() {
        board = new Board();
        score = 0;
        board.spawnRandomTile();
    }

    public Board getBoard() {
        return board;
    }

    public int getScore() {
        return score;
    }

    public void move(Direction dir) {
        int gained = board.move(dir);
        if (gained > 0) {
            score += gained;
        }
    }
}
