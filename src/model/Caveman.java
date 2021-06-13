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
		speed = (float) 5.5;
		cavemanImg = app.loadImage(filename);
		this.posX = posX;
		this.posY = posY;
		this.app = app;
	}

	public void draw() {
		app.imageMode (PApplet.CENTER);
		app.image(cavemanImg, posX, posY);

	}

	public void moveCaveman() {
		if (app.keyCode == PConstants.RIGHT) {
			posX = posX + speed;
		} else if (app.keyCode == PConstants.LEFT) {
			posX = posX - speed;
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
