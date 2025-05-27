package com.jeffmathieu.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.*;

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
}
