package com.jeffmathieu.game.ui;

import javax.swing.*;

import com.jeffmathieu.game.Game;
import com.jeffmathieu.game.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    private GamePanel panel;
    private InputHandler handler;

    @BeforeEach
    public void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            panel = new GamePanel();
            for (KeyListener kl : panel.getKeyListeners()) {
                if (kl instanceof InputHandler) {
                    handler = (InputHandler) kl;
                    break;
                }
            }
        });
        assertNotNull(handler, "InputHandler should be installed on the panel");
    }

    private Tile[][] setUpBoard() {
        panel.getBoard().clearGrid();
        Tile[][] newGrid = new Tile[panel.getBoard().getSIZE()][panel.getBoard().getSIZE()];
        int x = 2;
        for (int i = 0; i < panel.getBoard().getSIZE(); i++) {
            for (int j = 0; j < panel.getBoard().getSIZE(); j++){
                newGrid[i][j] =new Tile(x);
                x = x*2;
            }
        }
        return newGrid;
    }

    @Test
    public void pressingArrowKeyDoesNotThrow() throws Exception {
        setUpBoard();

        KeyEvent evt = new KeyEvent(panel, KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0,
                KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        SwingUtilities.invokeAndWait(() -> {
            handler.keyPressed(evt);
        });

        KeyEvent evt1 = new KeyEvent(panel, KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0,
                KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        SwingUtilities.invokeAndWait(() -> {
            handler.keyPressed(evt1);
        });

        KeyEvent evt2 = new KeyEvent(panel, KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0,
                KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        SwingUtilities.invokeAndWait(() -> {
            handler.keyPressed(evt2);
        });

        KeyEvent evt3 = new KeyEvent(panel, KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0,
                KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);
        SwingUtilities.invokeAndWait(() -> {
            handler.keyPressed(evt3);
        });
    }
}