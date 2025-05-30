package com.jeffmathieu.game.ui;

import javax.swing.*;
import java.awt.*;

import com.jeffmathieu.game.Board;
import com.jeffmathieu.game.Game;
import com.jeffmathieu.game.Tile;

public class GamePanel extends JPanel {
    private Game game;
    private Board board;
    private JLabel score;

    private boolean gameOverMessageShown = false;

    private static final int PADDING = 10;
    private static final int CELL_PADDING = 10;


    public GamePanel() {
        setPreferredSize(new Dimension(400, 400));

        this.game = new Game();
        this.board = game.getBoard();

        score = new JLabel("HighScore: " + game.getHighScore(), SwingConstants.CENTER);
        add(score, BorderLayout.NORTH);

        setFocusable(true);
        addKeyListener(new InputHandler(game, this));
    }

    public Board getBoard() {
        return board;
    }

    public Game getGame() {
        return game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        score.setText("Score: " + game.getScore() + " HighScore: " + game.getHighScore());

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0x9293AA));
        g2.fillRect(0, 0, getWidth(), getHeight());

        Tile[][] grid = board.getGrid();
        int rows = grid.length;
        int available = getWidth() - 2 * PADDING - (rows - 1) * CELL_PADDING;
        int cellSize = available / rows;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < rows; c++) {
                int x = PADDING + c * (cellSize + CELL_PADDING);
                int y = PADDING + r * (cellSize + CELL_PADDING);

                Tile tile = grid[r][c];
                if (tile == null) {
                    g2.setColor(new Color(0xcdc1b4));
                } else {
                    int val = tile.getValue();
                    g2.setColor(getTileColor(val));
                }
                g2.fillRoundRect(x, y, cellSize, cellSize, 15, 15);

                if (tile != null) {
                    int val = tile.getValue();
                    String s = String.valueOf(val);
                    g2.setFont(getFont(val));
                    FontMetrics fm = g2.getFontMetrics();
                    int textWidth = fm.stringWidth(s);
                    int textHeight = fm.getAscent();

                    g2.setColor(getTextColor(val));
                    int tx = x + (cellSize - textWidth) / 2;
                    int ty = y + (cellSize + textHeight) / 2 - fm.getDescent();
                    g2.drawString(s, tx, ty);
                }
            }
        }
        if (game.isGameOver() && !gameOverMessageShown) {
            gameOverMessageShown = true;
            if (game.getScore() > game.getHighScore()) {
                SwingUtilities.invokeLater(() -> {
                    this.paintImmediately(0, 0, getWidth(), getHeight());


                    JOptionPane.showMessageDialog(
                            this,
                            "Congratulations!\nYour new High Score: " + game.getScore(),
                            "Game Over!",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    // now reset and repaint
                    game.restart();
                    //score.setText("Score: 0");
                    gameOverMessageShown = false;
                    repaint();
                });
            } else {
                SwingUtilities.invokeLater(() -> {
                    this.paintImmediately(0, 0, getWidth(), getHeight());


                    JOptionPane.showMessageDialog(
                            this,
                            "Game Over!\nYour score: " + game.getScore(),
                            "Game Over!",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    // now reset and repaint
                    game.restart();
                    //score.setText("Score: 0");
                    gameOverMessageShown = false;
                    repaint();
                });
            }
        }
    }

    private Color getTileColor(int value) {
        return switch (value) {
            case 2 -> new Color(0xeee4da);
            case 4 -> new Color(0xede0c8);
            case 8 -> new Color(0xf2b179);
            case 16 -> new Color(0xf59563);
            case 32 -> new Color(0xf67c5f);
            case 64 -> new Color(0xf65e3b);
            case 128 -> new Color(0xFD4013);
            case 256 -> new Color(0x9E2716);
            case 512 -> new Color(0xA30E60);
            case 1024 -> new Color(0xE11181);
            case 2048 -> new Color(0xFF00FC);
            default -> new Color(0xedcf72);
        };
    }

    private Color getTextColor(int value) {
        return value < 8 ? new Color(0x776e65) : Color.WHITE;
    }

    private Font getFont(int value) {
        int fontSize = (value < 100) ? 36 : (value < 1000) ? 32 : 24;
        return new Font("SansSerif", Font.BOLD, fontSize);
    }
}

