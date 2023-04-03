package ie.tudublin;

import processing.core.PApplet;

public class StarsForAssignment extends PApplet {

    float x, y, z;
    float pz;


    public void star() {
        
        x = random(-width, width);
        y = random(-height, height);
        z = random(width);
    }

    public void update() {
        z = z - 10;
        if(z <  1) {
            z = width;
            x = random(-width, width);
            y = random(-height, height);
            pz = z;
        }   
    }

    public void show() {
        fill(255);
        noStroke();

        float sx = map(x / z, 0, 1, 0, width);
        float sy = map(y / z, 0, 1, 0, height);

        float r = map(z, 0, width, 16, 0);
        ellipse(sx, sy, r, r);

        float px = map(x / pz, 0, 1, 0, width);
        float py = map(y / pz, 0, 1, 0, height);

        stroke(255);
        line(px, py, sx, sy);

    }
}
