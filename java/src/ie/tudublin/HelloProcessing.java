package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		//colorMode(HSB);
		background(255, 0, 0);
	}

	public void draw()
	{	
		// stroke(255);
		// line(10, 10, 100, 100); // x1, y1, x2, y2
		// circle(300, 250, 70); // cx, cy, d
		// fill(0, 255, 0); //red, green, blue
		// rect(10, 300, 20, 100); //tlx, tly, w, h
		// stroke(127);
		// fill(0, 0, 255);
		// noStroke();
		// noFill();
		// strokeWeight(1);
		// triangle(40, 90, 300, 20, 80, 70);
		// fill(0, 0, 255);

		noStroke();
		fill(255,255, 0);
		circle(250, 250, 400);
		fill(0, 255, 255);
		triangle(250, 10, 50, 400, 450, 400);
		fill(255, 255, 255);
		ellipse(250, 200, 180, 100);
		fill(0, 0, 0);
		ellipse(250, 200, 60, mouseY);
	}
}
