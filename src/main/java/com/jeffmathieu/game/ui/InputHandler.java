package com.jeffmathieu.game.ui;

import com.jeffmathieu.game.Game;
import com.jeffmathieu.game.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    private Game game;
    private GamePanel gamePanel;

    public InputHandler(Game game, GamePanel gamePanel) {
        this.game = game;
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!game.isGameOver()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    game.move(Direction.UP);
                    break;
                case KeyEvent.VK_RIGHT:
                    game.move(Direction.RIGHT);
                    break;
                case KeyEvent.VK_DOWN:
                    game.move(Direction.DOWN);
                    break;
                case KeyEvent.VK_LEFT:
                    game.move(Direction.LEFT);
                    break;
                default:
                    break;
            }
        }
        gamePanel.repaint();
    }
}
