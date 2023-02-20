package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;
	int rectSize = 100;
	int rectX = width / 2 - rectSize / 2;
	int rectY = height / 2 - rectSize / 2;

	public void settings() {
		size(800, 800);
		//fullScreen(SPAN);
	}

	public void setup() {
		colorMode(HSB);
	}

	public void keyPressed() {

		mode = key - '0';
		println(mode);
	}

	float off = 0;

	public void draw() {
		background(0);
		fill(255);
		noStroke();

		switch (mode) {
			case 0:
				int numCircles = (int) max(1, mouseX / 50.0f);
				float d = width / numCircles;
				for (int j = 0; j < numCircles; j++) {
					for (int i = 0; i < numCircles; i++) {
						float x = (d * 0.5f) + (d * i);
						float y = (d * 0.5f) + (d * j);
						float c = ((i + j) / ((numCircles - 1) * 2.0f)) * 255.0f;
						fill((c + off) % 256, 255, 255);
						circle(x, y, d);
					}
				}
				off += (mouseY / 50.0f);
				break;
			case 1:
					//First If statement exercise
					fill(255, 100, 100);
					rect(rectX, rectY, rectSize, rectSize);

					if(mouseX >= rectX && mouseX <= rectX + rectSize && mouseY >= rectY && mouseY <= rectY + rectSize)
					{
						
					}
				break;
			case 2:
					//Second If statement exercise
					fill(255, 100, 100);
					rect(rectX, rectY, rectSize, rectSize);
					
					if(mouseX >= rectX && mouseX <= rectX + rectSize && mouseY >= rectY && mouseY <= rectY + rectSize)
					{
						rectX = (int) random(width - rectSize);
						rectY = (int) random(height - rectSize);
						println("Mouse is inside rectangle");
					}
					else
					{
						println("Mouse is outside rectangle");
					}
				break;
		}

	}
}
