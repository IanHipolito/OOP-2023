package ie.tudublin;

import processing.core.PApplet;

public class StickFigure extends PApplet {
  
  float headX, bodySX, bodyEX, armULSX, armULEX, armLLSX, armLLEX, armURSX, armUREX, armLRSX, armLREX, legULSX, legULEX, legLLSX, legLLEX, legURSX, legUREX, legLRSX, legLREX;
  int smY = 205;
  int smX = 25;
  int rotation = 0;
  float t = 0;
  
  public void settings() {
    size(300, 300);
  }
  
  public void setup() {
    frameRate(30);
  }
  
  public void draw() {
    background(255);
    translate(smX, smY);
    rotate(rotation);
    
    // Stickman animation code here
    headX = 0;
    bodySX = 0;
    bodyEX = 0;
    armULSX = 0;
    armULEX = 10;
    armLLSX = 10;
    armLLEX = 22;
    armURSX = 0;
    armUREX = -10;
    armLRSX = -10;
    armLREX = -22;
    legULSX = 0;
    legULEX = 13;
    legLLSX = 13;
    legLLEX = 30;
    legURSX = 0;
    legUREX = -13;
    legLRSX = -13;
    legLREX = -30;
    
    // Draw stickman
    fill(255);
    stroke(0);
    strokeWeight(5);
    ellipse(headX+15, 15, 16, 16);
    line(bodySX+15, 30, bodyEX+15, 57);
    line(armURSX+15, 30, armUREX+20, 43);
    line(armLRSX+20, 43, armLREX+30, 57);
    line(armULSX+15, 30, armULEX+10, 43);
    line(armLLSX+10, 43, armLLEX+8, 57);
    line(legURSX+15, 57, legUREX+23, 75);
    line(legLRSX+23, 75, legLREX+30, 90);
    line(legULSX+15, 57, legULEX+10, 75);
    line(legLLSX+10, 75, legLLEX, 90);
    
    // Update animation values
    armULEX = 10*sin(t);
    armLLEX = 22*sin(t);
    legUREX = -13*sin(t);
    legLREX = -30*sin(t);
    
    // Increment time for animation
    t += 0.1;
    
    // Increment position for movement
    smX += 1;
    if (smX > 243) {
      smX = 25;
    }
    
    // Increment rotation for spinning
    // rotation += 1;
    // if (rotation >= 360) {
    //   rotation = 0;
    // }
  }
  
  public static void main(String[] args) {
    PApplet.main("StickMan");
  }

}
