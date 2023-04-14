package ie.tudublin;

import processing.core.PApplet;

public class StarField extends PApplet{
    Star[] stars = new Star[100];


    public void setup(){
        size(800, 800);
        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star();
        }
    }

    public void draw(){
        background(0);
        for(int i = 0; i < stars.length; i++)
        {
            stars[i].update();
            stars[i].show();
        }
    }
}
