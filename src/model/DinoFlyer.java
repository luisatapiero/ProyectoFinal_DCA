package model;

import processing.core.PApplet;
import processing.core.PImage;

public class DinoFlyer extends Elements{
	
	private PImage dinoFlyerImg;

	public DinoFlyer(String filename, float posX, float posY, PApplet app) {
		super(filename, posX, posY, app);
		dinoFlyerImg = app.loadImage(filename);
	}
	
	
	public void draw() {
		app.imageMode(PApplet.CENTER);

		app.image(dinoFlyerImg, centerX, centerY + 30);
		dinoFlyerImg.resize(120, 88);

	}

	public void advanceMap() {
		centerX -= 4;
	}

	public void goBackMap() {
		centerX += 4;
	}

}
