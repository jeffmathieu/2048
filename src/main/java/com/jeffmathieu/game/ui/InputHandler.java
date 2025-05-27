package com.jeffmathieu.game.ui;

import com.jeffmathieu.game.Board;
import com.jeffmathieu.game.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    private Board board;
    private GamePanel gamePanel;

    public InputHandler(Board board, GamePanel gamePanel) {
        this.board = board;
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                board.move(Direction.UP);
                break;
            case KeyEvent.VK_RIGHT:
                board.move(Direction.RIGHT);
                break;
            case KeyEvent.VK_DOWN:
                board.move(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                board.move(Direction.LEFT);
                break;
            case KeyEvent.VK_R:
                //TODO: extra functionality.
                break;
            default:
                break;
        }
    }
}
