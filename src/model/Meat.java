package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Meat extends Elements{
	
	private PImage meatImg;

	public Meat(String filename, float posX, float posY, PApplet app) {
		super(filename, posX, posY, app);
		meatImg = app.loadImage(filename);
	}
	
	public void draw() {

		app.imageMode(PConstants.CENTER);
		app.image(meatImg, centerX, centerY);

	}

}
