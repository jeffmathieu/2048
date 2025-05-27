package com.jeffmathieu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private Tile[][] grid;
    private final int SIZE = 4;
    private Random random = new Random();

    public Board() {
        this.grid = new Tile[SIZE][SIZE];
        //testGrid();
        spawnRandomTile();
    }

    private void testGrid() {
        int x = 2;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                this.grid[i][j] =new Tile(x);
                x = x*2;
            }
        }
    }

    public void clearGrid() {
        this.grid = new Tile[SIZE][SIZE];
    }

    public void setGrid(Tile[][] newGrid) {
        this.grid = newGrid;
    }

    public Tile[][] getGrid() {
        return this.grid;
    }

    public int getSIZE(){
        return this.SIZE;
    }

    public void spawnRandomTile() {
        List<int[]> empty = new ArrayList<>();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (grid[r][c] == null) empty.add(new int[]{r, c});
            }
        }
        if (empty.isEmpty()) return;
        int[] rc = empty.get(random.nextInt(empty.size()));
        int val = random.nextDouble() < 0.9 ? 2 : 4;
        grid[rc[0]][rc[1]] = new Tile(val);
    }

    public MoveResult move(Direction dir) {
        int[][] before = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                before[r][c] = grid[r][c] == null ? 0 : grid[r][c].getValue();

        int points;
        switch (dir) {
            case UP: points = moveUp(); break;
            case DOWN: points = moveDown(); break;
            case LEFT: points = moveLeft(); break;
            case RIGHT: points = moveRight(); break;
            default: points = 0; break;
        };

        boolean moved = false;
        for (int r = 0; r < SIZE && !moved; r++) {
            for (int c = 0; c < SIZE; c++) {
                int now = grid[r][c] == null ? 0 : grid[r][c].getValue();
                if (before[r][c] != now) {
                    moved = true;
                    break;
                }
            }
        }

        return new MoveResult(moved, points);
    }

    public int moveUp() {
        int gained = 0;

        for (int c = 0; c < SIZE; c++) {
            List<Integer> vals = new ArrayList<>();
            for (int r = 0; r < SIZE; r++) if (grid[r][c] != null) vals.add(grid[r][c].getValue());
            List<Integer> merged = new ArrayList<>();
            for (int i = 0; i < vals.size(); i++) {
                if (i + 1 < vals.size() && vals.get(i).equals(vals.get(i + 1))) {
                    int m = vals.get(i) * 2;
                    merged.add(m);
                    gained += m;
                    i++;
                } else {
                    merged.add(vals.get(i));
                }
            }
            while (merged.size() < SIZE) merged.add(0);
            for (int r = 0; r < SIZE; r++) {
                int v = merged.get(r);
                grid[r][c] = v == 0 ? null : new Tile(v);
            }
        }
        return gained;
    }

    public int moveDown() {
        int gained = 0;

        for (int c = 0; c < SIZE; c++) {
            List<Integer> vals = new ArrayList<>();
            for (int r = SIZE - 1; r >= 0; r--) if (grid[r][c] != null) vals.add(grid[r][c].getValue());
            List<Integer> merged = new ArrayList<>();
            for (int i = 0; i < vals.size(); i++) {
                if (i + 1 < vals.size() && vals.get(i).equals(vals.get(i + 1))) {
                    int m = vals.get(i) * 2;
                    merged.add(m);
                    gained += m;
                    i++;
                } else {
                    merged.add(vals.get(i));
                }
            }
            while (merged.size() < SIZE) merged.add(0);
            for (int r = SIZE - 1, m = 0; r >= 0; r--, m++) {
                int v = merged.get(m);
                grid[r][c] = v == 0 ? null : new Tile(v);
            }
        }
        return gained;
    }

    public int moveLeft() {
        int gained = 0;

        for (int r = 0; r < SIZE; r++) {
            List<Integer> vals = new ArrayList<>();
            for (int c = 0; c < SIZE; c++) if (grid[r][c] != null) vals.add(grid[r][c].getValue());
            List<Integer> merged = new ArrayList<>();
            for (int i = 0; i < vals.size(); i++) {
                if (i + 1 < vals.size() && vals.get(i).equals(vals.get(i + 1))) {
                    int m = vals.get(i) * 2;
                    merged.add(m);
                    gained += m;
                    i++;
                } else {
                    merged.add(vals.get(i));
                }
            }
            while (merged.size() < SIZE) merged.add(0);
            for (int c = 0; c < SIZE; c++) {
                int v = merged.get(c);
                grid[r][c] = v == 0 ? null : new Tile(v);
            }
        }
        return gained;
    }

    public int moveRight() {
        int gained = 0;

        for (int r = 0; r < SIZE; r++) {
            List<Integer> vals = new ArrayList<>();
            for (int c = SIZE - 1; c >= 0; c--) if (grid[r][c] != null) vals.add(grid[r][c].getValue());
            List<Integer> merged = new ArrayList<>();
            for (int i = 0; i < vals.size(); i++) {
                if (i + 1 < vals.size() && vals.get(i).equals(vals.get(i + 1))) {
                    int m = vals.get(i) * 2;
                    merged.add(m);
                    gained += m;
                    i++;
                } else {
                    merged.add(vals.get(i));
                }
            }
            while (merged.size() < SIZE) merged.add(0);
            for (int c = SIZE - 1, m = 0; c >= 0; c--, m++) {
                int v = merged.get(m);
                grid[r][c] = v == 0 ? null : new Tile(v);
            }
        }
        return gained;
    }

}
