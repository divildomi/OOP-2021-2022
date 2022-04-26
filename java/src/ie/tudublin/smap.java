package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class smap extends PApplet {

    ArrayList<startest> stars = new ArrayList<startest>();

    public float border;

    void drawGrid() {

        stroke(255, 0, 255); // purple
        textAlign(CENTER, CENTER);
        textSize(20);
        for (int i = -5; i <= 5; i++) {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }

    }

    void printStars() {
        for (startest s : stars) {
            System.out.println(s);
        }

    }

    void loadStars() {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for (TableRow r : table.rows()) // enhanced for loop
        {
            startest s = new startest(r);
            stars.add(s);
        }
    }

    public void settings() {
        size(800, 800);
    }

    public void mouseClicked() {

    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();

        border = width * 0.1f; // 0.1f = 10%
    }

    public void drawStars() {
        for (startest s : stars) {
            s.render(this);
        }
    }

    public void draw() {

        background(0);
        drawGrid();
        drawStars();

    }
}
