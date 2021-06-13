package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Obstacles extends Elements{
	
	private PImage obstacleImg;

	public Obstacles(String filename, float posX, float posY, PApplet app) {
		
	super(filename, posX, posY, app);
	obstacleImg = app.loadImage(filename);
	
	}
	
	  public void draw(){
		  app.imageMode (PApplet.CENTER);
		     app.image(obstacleImg, centerX, centerY);
		     obstacleImg.resize(150, 150);
		  }
	  
	  public void advanceMap(){
	     centerX -= 5;
	     ///centerY += changeY;
	  }
	  
	  public void goBackMap() {
		  centerX += 5;
	  }

}
