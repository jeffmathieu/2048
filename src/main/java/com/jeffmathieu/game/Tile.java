package com.jeffmathieu.game;

public class Tile {

    private int value;

    public Tile(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }

}
