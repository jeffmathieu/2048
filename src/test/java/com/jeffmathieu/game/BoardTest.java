package com.jeffmathieu.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testInit() {
        Board board = new Board();
        Tile[][] grid = board.getGrid();
        int length = grid.length;
        int width = grid[0].length;
        assertEquals(board.getSIZE(), length);
        assertEquals(board.getSIZE(), width);
    }

    private void setNewGrid(Board board) {
        board.clearGrid();
        Tile[][] grid = new Tile[board.getSIZE()][board.getSIZE()];
        grid[0][0] = new Tile(2);
        grid[0][1] = new Tile(2);
        grid[1][0] = new Tile(2);
        board.setGrid(grid);
    }

    @Test
    public void testSetNewGrid() {
        Board board = new Board();
        setNewGrid(board);

        assertEquals(2, board.getGrid()[0][0].getValue());
        assertEquals(2, board.getGrid()[0][1].getValue());
        assertEquals(2, board.getGrid()[1][0].getValue());
    }

    @Test
    public void testMoveLeft() {
        Board board = new Board();
        setNewGrid(board);

        board.move(Direction.LEFT);

        assertEquals(4, board.getGrid()[0][0].getValue());
        assertEquals(2, board.getGrid()[1][0].getValue());
    }

    @Test
    public void testMoveRight() {
        Board board = new Board();
        setNewGrid(board);

        board.move(Direction.RIGHT);

        assertEquals(4, board.getGrid()[0][3].getValue());
        assertEquals(2, board.getGrid()[1][3].getValue());
    }

    @Test
    public void testMoveUp() {
        Board board = new Board();
        setNewGrid(board);

        board.move(Direction.UP);

        assertEquals(4, board.getGrid()[0][0].getValue());
        assertEquals(2, board.getGrid()[0][1].getValue());
    }

    @Test
    public void testMoveDown() {
        Board board = new Board();
        setNewGrid(board);

        board.move(Direction.DOWN);

        assertEquals(4, board.getGrid()[3][0].getValue());
        assertEquals(2, board.getGrid()[3][1].getValue());
    }
}
