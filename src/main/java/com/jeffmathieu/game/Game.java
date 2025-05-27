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
        MoveResult res = board.move(dir);
        if (res.isMoved()) {
            score += res.getPointsGained();
            board.spawnRandomTile();
        }
    }
}
