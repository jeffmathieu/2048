package com.jeffmathieu.game;

public class MoveResult {

    private final boolean moved;
    private final int pointsGained;

    public MoveResult(boolean moved, int pointsGained) {
        this.moved = moved;
        this.pointsGained = pointsGained;
    }

    public boolean isMoved() {
        return moved;
    }

    public int getPointsGained() {
        return pointsGained;
    }
}
