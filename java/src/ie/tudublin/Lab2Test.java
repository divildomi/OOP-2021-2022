package ie.tudublin;

import processing.core.PApplet;

public class Lab2Test extends PApplet {

    int mode = 0;

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        colorMode(HSB);

    }

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
        println(mode);
    }

    float magicMap(float a, float b, float c, float d, float e) {
        float output;
        a -= b;
        c -= b;
        e -= d;

        output = ((a / c) * e) + d;

        return output;
    }

    float magicMap1(float a, float b, float c, float d, float e) {
        float r1 = c - b;
        float r2 = e - d;
        float howFar = a - b;

        return d + ((howFar / r1) * r2);
    }

    float offset = 0;

    public void draw() {
        switch (mode) {
            case 0:
                background(0);
                int bars = (int) (mouseX / 20.0f);
                float w = width / (float) bars;
                for (int i = 0; i < bars; i++) {
                    noStroke();
                    fill(map(i, 0, bars, 0, 255), 255, 255);
                    rect(map(i, 0, bars, 0, 500), 0, w, height);
                }
                break;
            case 1:
                background(0);
                int squares = (int) (mouseX / 20.0f);
                float h = width / (float) squares;
                for (int i = 0; i < squares; i++) {
                    noStroke();
                    fill(map(i, 0, squares, 0, 255), 255, 255);
                    float x = map(i, 0, squares, 0, width);
                    rect(x, x, h, h);
                }
                break;
            case 2:
                background(0);
                int squares2 = (int) (mouseX / 20.0f);
                float h2 = width / (float) squares2;
                for (int i = 0; i < squares2; i++) {
                    noStroke();
                    fill(map(i, 0, squares2, 0, 255), 255, 255);
                    float x = map(i, 0, squares2, 0, width);
                    rect(x, x, h2, h2);
                    rect((width - h2) - x, x, h2, h2);
                }
                break;
            case 3: {
                background(0);
                ellipseMode(CENTER);
                int circles = (int) (mouseX / 20.0f);
                float d = width / (float) circles; // d = diameter
                for (int i = 0; i < circles; i++) {
                    fill(map(i, 0, circles, 0, 255), 255, 255);
                    float x = map(i, 0, circles, 0, 255);
                    circle(x, x, d);
                }

            }

                break;
            case 4: {
                background(255);
                int circles = (int) (mouseX / 20.0f);
                float d = width / (float) circles;
                for (int i = 0; i < circles; i++) {
                    noStroke();
                    float c = map(i, 0, circles * 2, 0, 255) % 256;
                    fill(c, 250, 250);
                    float x = map(i, 0, circles - 1, d / 2.0f, width - (d / 2.0f));
                    circle(x, d, d);
                }

            }

                break;
            case 5: {
                background(255);
                int circs = (int) (mouseX / 20.f);
                float d2 = width / (float) circs;
                for (int j = 0; j < circs; j++) {
                    for (int i = 0; i < circs; i++) {
                        noStroke();
                        float c = map(i, 0, circs * 2, 0, 255) % 256;
                        fill(c, 250, 250);
                        float x = map(i, 0, circs - 1, d2 / 2.0f, width - (d2 / 2.0f));
                        float y = map(i, 0, circs - 1, d2 / 2.0f, width - (d2 / 2.0f));
                        circle(x, y, d2);
                    }
                }
            }
                break;
            // map(a,b,c,d,e)
            // a = input
            // b and c = start and end of first range
            // d and e = start and end of end range
            // map (-2, 10, 90, 200, 233)
            // r1 = c - b
            // r2 = e - d0
            // return ((a-b)/ r1 * r2 + d
            // r1 = 90 - 10 = 80
            // r2 = 233 - 200 = 33
            // ((-2 - 10)/80) * 33 + 200
            // (-12/80) * 33 + 200
            // -1.5 * 33 + 200
            // - 4.95 + 200 = 195.05

            // map(1, 0, 10, 100, 200)
            // 110
        }
    }
}