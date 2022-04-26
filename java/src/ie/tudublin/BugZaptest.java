package ie.tudublin;

import processing.core.PApplet;

public class BugZaptest extends PApplet {

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        colorMode(RGB);
        smooth();
        playerX = width / 2;
        playerY = height - 50;
    }

    float playerX, playerY;
    float playerSpeed = 10;
    float playerWidth = 40;
    float halfPwidth = playerWidth / 2;

    float bugX, bugY, bugWidth = 20;
    float halfbugWidth = bugWidth / 2;

    int score = 0;

    public void reset() {

    }

    public void drawPlayer(float x, float y, float w) {
        stroke(255);
        noFill();
        rectMode(CENTER);
        rect(x, y, w, 20);
        line(x, y - 10, x, y - 20);

    }

    public void drawBug(float x, float y, float w) {
    }

    public void draw() {
        background(0);
        drawPlayer(playerX, playerY, playerWidth);
    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            System.out.println("Left arrow pressed");
        }
        if (keyCode == RIGHT) {
            System.out.println("Right arrow pressed");
        }
        if (key == ' ') {
            System.out.println("SPACE key pressed");
        }
    }

}
