package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import processing.data.*;

public class StarMap extends PApplet {

    //Global variable 
    ArrayList<Star> stars = new ArrayList<Star>();
    
    public float border;

    //Code to draw the gridlines with labels 
    void drawGrid()
    {
        stroke(255, 255, 255);
        textAlign(CENTER, CENTER);
        textSize(20);

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
    }

    //Prints contents of of the ArrayList and is called from setup
    void printStars()
    {
        for(Star s:stars)
        {
            System.out.println(s);
        }
    }

    //Method that loads the data from the CSV file and is called from setup
    void loadData()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow r:table.rows())
        {
            Star s = new Star(r);
            stars.add(s);
        }
    }

    public void settings() {
        size(800, 800);
    }

    Star first = null;
    Star second = null;



    public void mouseClicked()
    {
        for(Star s:stars)
        {
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            if (dist(mouseX, mouseY, x, y) < 20)
            {
                if (first == null)
                {
                    first = s;
                    break;
                }
                else if (second == null)
                {
                    second = s;
                    break;
                } 
                else
                {
                    first = s;
                    second = null;
                    break;
                }
            }
        }
    }

    public void setup() {
        colorMode(RGB);
        loadData();
        printStars();

        border = width * 0.1f;
    }

    public void drawStars()
    {
        for(Star s:stars)
        {
            s.render(this);
        }
    }

    //Plot the stars onto the grid
    public void draw() 
    {
        background(0);
        drawGrid();
        drawStars();
        
        //The code first maps the x and y coordinates of "first" (obtained from calling its "getxG()" and "getyG()" methods) from a range of -5 to 5 to a range of "border" to "width - border" and "border" to "height - border".
        if (first != null)
        {

            float x = map(first.getxG(), -5, 5, border, width - border);
            float y = map(first.getyG(), -5, 5, border, height - border);

            //If a variable "second" is not null, the code then maps the x and y coordinates of "second" in the same way as for "first", and draws a line between the two points.
            //The code also calculates the distance between "first" and "second" using their x, y, and z coordinates (obtained from calling their "getxG()", "getyG()", and "getzG()" methods) and assigns it to a variable "dist".
            if (second != null)
            {
                float x2 = map(second.getxG(), -5, 5, border, width - border);
                float y2 = map(second.getyG(), -5, 5, border, height - border);

                stroke(255, 255, 0);
                line(x, y, x2, y2);

                float dist = dist(first.getxG(), first.getyG(), first.getzG(), second.getxG(), second.getyG(), second.getzG());
                
                //Displays the distance between "first" and "second" with their display names (obtained from calling their "getDisplayName()" methods) in the center of the screen using white text color.
                fill(255);
                textAlign(CENTER, CENTER);
                text("Distance between: " + first.getDisplayName() + " and " + second.getDisplayName() + " is " + dist + " parsecs", width / 2, height - (border * 0.5f));
            }
            else
            {
                stroke(255, 255, 0);
                line(x, y, mouseX, mouseY);
            }
        }
    }
}