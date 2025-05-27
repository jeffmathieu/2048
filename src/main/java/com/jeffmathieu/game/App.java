package com.jeffmathieu.game;

import com.jeffmathieu.game.ui.GameFrame;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameFrame::new);
    }

}
