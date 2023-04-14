package ie.tudublin;

import processing.core.PApplet;

public class Stars extends PApplet{
    float x, y,z;

    public void Star(){
        x = random(0, width);
        y = random(0, height);
        z = random(0, width);
    }

    public void update(){

    }

    public void show(){
        fill(255);
        noStroke();
        ellipse(x, y, 8, 8);
    }
}
