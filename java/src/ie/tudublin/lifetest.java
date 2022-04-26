package ie.tudublin;

import processing.core.PApplet;

public class lifetest extends PApplet {

    lboardtest board;

    public void settings() {
        size(500, 500);
        board = new lboardtest(100, this);
        board.randomise();
        println(board.countcellsaround(1, 1));
    }

    public void setup() {
        colorMode(RGB);
    }

    public void draw() {
        board.render();
        board.update();

    }

}
