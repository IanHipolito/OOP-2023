package ie.tudublin;

import processing.core.PApplet;

public class SunSlit extends PApplet {

  // RGB colors
  int[] sunColors = {
      color(212, 202, 11),
      color(214, 198, 30),
      color(211, 170, 26),
      color(216, 157, 51),
      color(217, 124, 64),
      color(213, 104, 81),
      color(212, 51, 98),
      color(215, 29, 121),
      color(217, 11, 139),
      color(217, 0, 151)
  };

  int bgColor = color(37, 25, 53);
  float sunRadius = 300;
  float topSlitY;
  Rectangle[] slits;

  class Rectangle {
    float x, y, w, h;

    Rectangle(float y, float h) {
      this.x = width / 2 - sunRadius;
      this.w = 2 * sunRadius;
      this.y = y;
      this.h = h;
    }

    void draw() {
      fill(bgColor);
      rect(x, y, w, h);
    }

    void update() {
      y -= 0.5;

      if (y < topSlitY) {
        y = height / 2 + sunRadius;
      }

      h = map(y, topSlitY, height / 2 + sunRadius, 1.0f, 40.0f);
    }
  }

  public void settings() {
    size(1200, 800);
  }

  public void setup() {
    topSlitY = height / 2 - (sunRadius / 4);

    slits = new Rectangle[6];

    float y = topSlitY;
    float h = 1.0f;
    for (int i = 0; i < slits.length; i++) {
      slits[i] = new Rectangle(y, h);

      y += ((height / 2 + sunRadius) - topSlitY) / slits.length;
      h = map(y, topSlitY, height / 2 + sunRadius, 1.0f, 40.0f);
    }
  }

  public void draw() {
    background(bgColor);

    noStroke();
    fill(sunColors[0]);
    ellipse(width / 2, height / 2, 2 * sunRadius, 2 * sunRadius);

    loadPixels();

    for (int i = 0; i < pixels.length; i++) {

      if (pixels[i] == sunColors[0]) {
        int y = i / width;

        float step = map(y, height / 2 - sunRadius, height / 2 + sunRadius, 0, 1.0f);

        pixels[i] = interpolateColor(sunColors, step);
      }

    }

    updatePixels();

    for (Rectangle r : slits) {
      r.update();
      r.draw();
    }
  }

  public int interpolateColor(int[] arr, float step) {
    int sz = arr.length;
    
    if (sz == 1 || step <= 0.0f) {
      return arr[0];
    } 
    else if (step >= 1.0f) {
      return arr[sz - 1];
    } 
    else {
      float f = step * (sz - 1);
      int i = (int) f;
      float p = f - i;
      return lerpColor(arr[i], arr[i + 1], p);
    }
  }
}
     

