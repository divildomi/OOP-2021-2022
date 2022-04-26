package ie.tudublin;

import processing.core.PApplet;

public class lboardtest {

    boolean[][] board;
    boolean[][] next;
    int size;
    float cellsize;
    PApplet pa;

    public lboardtest(int size, PApplet pa) {
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.size = size;
        this.pa = pa;

        cellsize = pa.width / (float) size;

    }

    public void randomise() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = pa.random(1.0f) > 0.5f;
            }
        }
    }

    public void update() {
        // if cell is alive
        // if cell has 2 or 3 life neighbours cell lives
        // if dead w 3 cells comes back to life
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                int count = countcellsaround(row, col);

                // if alive
                if (isAlive(row, col)) {
                    // if 2 or 3 neighbours
                    if (count == 2 || count == 3) {
                        next[row][col] = true;
                    } else {
                        next[row][col] = false;
                    }
                    // if dead
                } else {
                    // if 3 neighbours
                    if (count == 3) {
                        next[row][col] = true;
                    } else {
                        next[row][col] = false;
                    }
                }
            }
        }

        boolean[][] temp;
        temp = board;
        board = next;
        next = temp;
    }

    public int countcellsaround(int row, int col) {
        int count = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (!(i == row && j == col)) {
                    if (isAlive(i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean isAlive(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return board[row][col];
        } else {
            return false;
        }
    }

    public void render() {
        pa.background(0);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                float x = PApplet.map(col, 0, size, 0, pa.width);
                float y = PApplet.map(row, 0, size, 0, pa.height);

                // or x = cellsize * col;
                // y = cellSize * row;

                if (board[row][col]) {
                    pa.fill(255, 192, 203); // pink colour :)
                    // 255,105,180 for darker pink
                    // 0,255,0 for green
                } else {
                    pa.noFill();
                }
                pa.rect(x, y, cellsize, cellsize);
            }
        }
    }

}
