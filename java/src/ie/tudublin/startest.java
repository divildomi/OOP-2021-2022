package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class startest {

    private boolean hab;
    private String displayName;
    private float distance;
    private float xG;
    private float yG;
    private float zG;
    private float absMag;

    // right click -> source action -> generate tostring

    @Override
    public String toString() {
        return "startest [absMag=" + absMag + ", displayName=" + displayName + ", distance=" + distance + ", hab=" + hab
                + ", xG=" + xG + ", yG=" + yG + ", zG=" + zG + "]";
    }

    // right click TableRow + import
    // constructor chaining
    public startest(TableRow tr) {
        this(
                tr.getInt("Hab?") == 1,
                tr.getString("Display Name"),
                tr.getFloat("Distance"),
                tr.getFloat("Xg"),
                tr.getFloat("Yg"),
                tr.getFloat("Zg"),
                tr.getFloat("AbsMag"));
    }

    // right click -> source action -> generate constructors
    public startest(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag) {
        // 'this' disambiguates betweeen parameter n keyword
        this.hab = hab;
        this.displayName = displayName;
        this.distance = distance;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
    }

    // right click -> source action -> generate getters + setters
    public boolean isHab() {
        return hab;
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getxG() {
        return xG;
    }

    public void setxG(float xG) {
        this.xG = xG;
    }

    public float getyG() {
        return yG;
    }

    public void setyG(float yG) {
        this.yG = yG;
    }

    public float getzG() {
        return zG;
    }

    public void setzG(float zG) {
        this.zG = zG;
    }

    public float getAbsMag() {
        return absMag;
    }

    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

    public void render(smap pa) {
        float x = PApplet.map(xG, -5, 5, pa.border, pa.width - pa.border);
        float y = PApplet.map(yG, -5, 5, pa.border, pa.height - pa.border);

        pa.stroke(255, 255, 0); // yellow
        pa.line(x, y - 5, x, y + 5);
        pa.line(x - 5, y, x + 5, y);
        pa.stroke(255, 0, 0); // red
        pa.noFill();
        pa.circle(x, y, absMag);
        pa.fill(255); // white
        pa.textSize(16);
        // horizontally aligned to left + vertically centred
        // static fields in papplet class
        pa.textAlign(PApplet.LEFT, PApplet.CENTER);
        pa.text(displayName, x + 20, y);
    }
}
