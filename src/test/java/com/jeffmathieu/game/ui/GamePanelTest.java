package com.jeffmathieu.game.ui;

import javax.swing.*;

import com.jeffmathieu.game.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyListener;

import static org.junit.jupiter.api.Assertions.*;

class GamePanelTest {

    private GamePanel panel;

    @BeforeEach
    public void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            panel = new GamePanel();
        });
    }

    @Test
    public void preferredSizeIs4TilesBy4Tiles() {
        Dimension d = panel.getPreferredSize();
        assertEquals(400, d.width);
        assertEquals(400, d.height);
    }


    @Test
    public void hasInputHandlerKeyListener() {
        boolean found = false;
        for (KeyListener kl : panel.getKeyListeners()) {
            if (kl instanceof InputHandler) {
                found = true;
                break;
            }
        }
        assertTrue(found, "GamePanel should register an InputHandler");
    }
}