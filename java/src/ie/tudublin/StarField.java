package ie.tudublin;

import processing.core.PApplet;

public class StarField extends PApplet {

  Star[] stars;
  
  public void settings() {
    size(800, 800);
  }
  
  public void setup() {
    background(0);
    stars = new Star[800];
    for (int i = 0; i < stars.length; i++) 
    {
      stars[i] = new Star();
    }
  }
  
  public void draw() {
    background(0);
    translate(width / 2, height / 2);
    for (Star s : stars) 
    {
      s.update();
      s.show();
    }
  }

  
  class Star {
    
    float x, y, z;
    float px, py, pz;
    
    Star() {
      x = random(-width / 2, width / 2);
      y = random(-height / 2, height / 2);
      z = random(width / 2);
      pz = z;
    }
    
    void update() {
      z = z - 10;
      if (z < 1) 
      {
        z = width/2;
        x = random(-width / 2, width / 2);
        y = random(-height / 2, height / 2);
        pz = z;
      }
    }
    
    void show() {
      float sx = map(x / z, 0, 1, 0, width);
      float sy = map(y / z, 0, 1, 0, height);
      float r = map(z, 0, width/2, 16, 0);

      ellipse(sx/2, sy/2, r/2, r/2);

      float px = map(x / pz, 0, 1, 0, width);
      float py = map(y / pz, 0, 1, 0, height);

      stroke(255, 128);
    
      line(sx, sy, px, py);
      

      px = sx;
      py = sy;
    }
    
  }
  
}
