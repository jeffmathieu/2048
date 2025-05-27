package com.jeffmathieu.game;

public class Game {
    private Board board;
    private int score;

    public Game() {
        this.board = new Board();
        this.score = 0;
        this.board.spawnRandomTile();
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

    public boolean isGameOver() {
        return !board.hasAvailableMoves();
    }

    public void restart() {
        board.restart();
    }
}
