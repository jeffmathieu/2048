package com.jeffmathieu.game.ui;

import javax.swing.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GameFrameTest {

    private GameFrame frame;

    @BeforeEach
    void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> frame = new GameFrame());
    }

    @AfterEach
    void tearDown() throws Exception {
        SwingUtilities.invokeAndWait(frame::dispose);
    }

    @Test
    public void titleIs2048() {
        assertEquals("2048", frame.getTitle());
    }

    @Test
    public void containsGamePanel() {
        Component content = frame.getContentPane().getComponent(0);
        assertInstanceOf(GamePanel.class, content, "GameFrame should hold a GamePanel");
    }

}