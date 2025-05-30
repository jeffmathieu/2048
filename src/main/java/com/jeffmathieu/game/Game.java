package com.jeffmathieu.game;

import java.io.*;

public class Game {
    private static final String HIGHSCORE_FILE = System.getProperty("user.home") + "/.2048_highscore.txt";
    private Board board;
    private int score;
    private int highScore;

    public Game() {
        this.board = new Board();
        this.score = 0;
        this.board.spawnRandomTile();
        this.highScore = retrieveHighScore();
    }

    public Board getBoard() {
        return board;
    }

    public int getScore() {
        return score;
    }

    private void resetScore() {
        this.score = 0;
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
        if (score > retrieveHighScore()) saveHighScore(score);
        resetScore();
        board.restart();
        this.highScore = retrieveHighScore();
    }

    public int getHighScore() {
        return highScore;
    }

    private int retrieveHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HIGHSCORE_FILE))) {
            String line = reader.readLine();
            return line != null ? Integer.parseInt(line) : 0;
        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }

    private void saveHighScore(int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HIGHSCORE_FILE))) {
            writer.write(Integer.toString(score));
        } catch (IOException e) {
            // Handle error if needed
        }
    }
}

