package model;

import processing.core.PApplet;
import processing.core.PImage;

public class DinoTerrestral extends Elements{
	
	private PImage dinoTImg;

	public DinoTerrestral(String filename, float posX, float posY, PApplet app) {
		super(filename, posX, posY, app);
		dinoTImg = app.loadImage(filename);
	}
	
	public void draw() {
		app.imageMode(PApplet.CENTER);

		app.image(dinoTImg, centerX, centerY + 30);
		dinoTImg.resize(120, 88);

	}

	public void advanceMap() {
		centerX -= 4;
		/// centerY += changeY;
	}

	public void goBackMap() {
		centerX += 4;
	}

}
