package com.jeffmathieu.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    public void testInit() {
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

    private void setFalseGrid(Board board) {
        board.clearGrid();
        Tile[][] newGrid = new Tile[board.getSIZE()][board.getSIZE()];
        int x = 2;
        for (int i = 0; i < board.getSIZE(); i++) {
            for (int j = 0; j < board.getSIZE(); j++){
                newGrid[i][j] =new Tile(x);
                x = x*2;
            }
        }
        board.setGrid(newGrid);
    }

    @Test
    public void testSetNewGrid() {
        setNewGrid(board);

        assertEquals(2, board.getGrid()[0][0].getValue());
        assertEquals(2, board.getGrid()[0][1].getValue());
        assertEquals(2, board.getGrid()[1][0].getValue());
    }

    @Test
    public void testMoveLeft() {
        setNewGrid(board);

        board.move(Direction.LEFT);

        assertEquals(4, board.getGrid()[0][0].getValue());
        assertEquals(2, board.getGrid()[1][0].getValue());

        board.move(Direction.LEFT);

        assertEquals(4, board.getGrid()[0][0].getValue());
        assertEquals(2, board.getGrid()[1][0].getValue());
    }

    @Test
    public void testMoveRight() {
        setNewGrid(board);

        board.move(Direction.RIGHT);

        assertEquals(4, board.getGrid()[0][3].getValue());
        assertEquals(2, board.getGrid()[1][3].getValue());
    }

    @Test
    public void testMoveUp() {
        setNewGrid(board);

        board.move(Direction.UP);

        assertEquals(4, board.getGrid()[0][0].getValue());
        assertEquals(2, board.getGrid()[0][1].getValue());
    }

    @Test
    public void testMoveDown() {
        setNewGrid(board);

        board.move(Direction.DOWN);

        assertEquals(4, board.getGrid()[3][0].getValue());
        assertEquals(2, board.getGrid()[3][1].getValue());
    }

    @Test
    public void availableMovesTest() {
        setNewGrid(board);
        assertTrue(board.hasAvailableMoves());
    }

    @Test
    public void noAvailableMovesTest() {
        setFalseGrid(board);
        assertFalse(board.hasAvailableMoves());
    }

    @Test
    public void restartTest() {
        setNewGrid(board);
        assertEquals(2, board.getGrid()[0][0].getValue());
        board.restart();
        assertNull(board.getGrid()[0][0]);

    }

}
