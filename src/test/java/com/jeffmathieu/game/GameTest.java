package com.jeffmathieu.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    public void initialTest() {
        assertNotNull(game.getBoard());
        assertEquals(0, game.getScore());
    }

    @Test
    public void gameNotOverOnInit() {
        assertFalse(game.isGameOver());
    }

    @Test
    public void restartTest() {
        game.restart();
        assertFalse(game.isGameOver());
    }

    @Test
    public void moveTest() {
        game.move(Direction.LEFT);
        assertFalse(game.isGameOver());
    }

    private void setUnmovableBoard() {
        game.getBoard().clearGrid();
        Tile[][] newGrid = new Tile[game.getBoard().getSIZE()][game.getBoard().getSIZE()];
        int x = 2;
        for (int i = 0; i < game.getBoard().getSIZE(); i++) {
            for (int j = 0; j < game.getBoard().getSIZE(); j++){
                newGrid[i][j] =new Tile(x);
                x = x*2;
            }
        }
        game.getBoard().setGrid(newGrid);
    }

    @Test
    public void unmovableTest() {
        setUnmovableBoard();
        game.move(Direction.LEFT);
        assertTrue(game.isGameOver());
    }


}
