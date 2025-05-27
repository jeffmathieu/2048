package com.jeffmathieu.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TileTest {

    @Test
    public void testInit(){
        Tile tile = new Tile(2);
        assertEquals(2, tile.getValue());
    }

    @Test
    public void testChangeValue(){
        Tile tile = new Tile(2);
        tile.setValue(4);
        assertEquals(4, tile.getValue());
    }


}