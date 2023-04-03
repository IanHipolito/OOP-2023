package ie.tudublin;

import processing.core.PApplet;

public class StarFieldAssignment extends PApplet{
    
    StarsForAssignment[] stars = new StarsForAssignment[800];

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        for(int i = 0; i < stars.length; i++) {
            stars[i] = new StarsForAssignment();
        }
    }

    public void draw() {
        background(0);
        translate(width / 2, height / 2);
        for(int i = 0; i < stars.length; i++) {
            stars[i].update();
            stars[i].show();
        }
    }
}
