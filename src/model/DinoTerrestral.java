package model;

import processing.core.PApplet;
import processing.core.PImage;

public class DinoTerrestral extends Elements implements Runnable{
	
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
	}

	public void goBackMap() {
		centerX += 4;
	}

	@Override
	public void run() {

			advanceMap();
			
			try {

				Thread.sleep(10);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		
	}

}
