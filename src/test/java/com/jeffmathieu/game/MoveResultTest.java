package com.jeffmathieu.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveResultTest {

    @Test
    public void testInit() {
        MoveResult result = new MoveResult(true, 10);

        assertTrue(result.isMoved());
        assertEquals(10, result.getPointsGained());
    }

}