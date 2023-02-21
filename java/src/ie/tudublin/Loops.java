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
			case 3:
					//Third If statement exercise
				break;
			case 4:
					//Using a for loop, rect and the HSB colour space to make moving bars.
					int bars = (int) (mouseX / 10.0f);
					float barWidth = width / (float) bars;

					for(int i = 0; i < bars; i++)
					{
						noStroke();
						fill(map(i, 0, bars, 0, 255), 255, 255);
						rect(map(i, 0, bars, 0, width), 0, barWidth, height);
					}
				break;
			case 5:
					//Using a for loop, rect and the HSB colour space that react to mouse position 
					int squares = (int) (mouseX / 10.0f);
					float squareHeight = width / (float) squares;

					for(int i = 0; i < squares; i++)
					{
						for(int j = 0; j < squares; j++)
						{
							noStroke();
							fill(map(i, 0, squares, 0, 255), 255, 255);
							float x = map(i, 0, squares, 0, width);
							rect(x, x, squareHeight, squareHeight);
							rect((width - squareHeight) - x, x, squareHeight, squareHeight);
						}
					}

				break;
			case 6:
					//Using for loop to create a grid
					stroke(255, 255, 255);
					textAlign(CENTER, CENTER);
					textSize(20);

					float border = 50.0f;

					//Grid lines go from -5 parcecs to 5 parsecs on the x and y axis
					for(int i = -5; i <=5; i ++)
					{
						float x = map(i, -5, 5, border, width - border);
						line(x, border, x, height - border);
						line(border, x, width - border, x);
						fill(100);
						text(i, x, border * 0.5f);
						text(i, border * 0.5f, x);
					}
				break;
		}

	}
}
