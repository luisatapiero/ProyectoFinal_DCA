package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Caveman extends Elements implements Runnable {

	private float speed;
	private PImage cavemanImg;
	private PApplet app;

	public Caveman(String filename, float posX, float posY, PApplet app) {
		super(filename, posX, posY, app);
		speed = (float) 3.5;
		cavemanImg = app.loadImage(filename);
		//this.posX = posX;
		//this.posY = posY;
		this.app = app;
		
		//centerX = 5; 
		//centerY = 565;
	}

	public void draw() {
		app.imageMode (PConstants.CENTER);
		app.image(cavemanImg, posX, posY);

	}

	
	public void moveCaveman() {
		if (app.keyCode == PConstants.RIGHT) {
			posX = posX + speed;
		} else if (app.keyCode == PConstants.LEFT) {
			posX = posX - speed;
		} else if (app.keyCode == PConstants.UP) {
			posY = posY - speed;
		}else if (app.keyCode == PConstants.DOWN) {
			posY = posY + speed;
		}
	}
	
	
	public void stopCaveman() {
		if (app.keyCode == PConstants.RIGHT) {
			posX =0;
		} else if (app.keyCode == PConstants.LEFT) {
			posX = 0;
		} else if (app.keyCode == PConstants.UP) {
			posY = 0;
		}else if (app.keyCode == PConstants.DOWN) {
			posY = 0;
		}
	}
	@Override
	public void run() {
		moveCaveman();

		try {

			Thread.sleep(10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
