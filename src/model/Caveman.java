package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Caveman extends Elements implements Runnable {

	private float speed;
	private PImage cavemanImg;
	private PApplet app;
	private boolean speedPower;
	private float gravity;
	private float jumpSpeed;
	private boolean isOnplatform;

	private int velocidad;
	private boolean jumPower;;

	public Caveman(String filename, float posX, float posY, PApplet app) {
		super(filename, posX, posY, app);
		speed = (float) 4;
		cavemanImg = app.loadImage(filename);
		this.app = app;
		centerX = 90;
		centerY = 30;
		changeX = 0;
		changeY = 0;
		gravity = (float) 5;
		jumpSpeed = 10;
		isOnplatform = false;

		/*
		 * speedPower = false; jumPower = false; velocidad = 1; control = 1;
		 * 
		 * jump = 155 * control;
		 */
		// centerX = 5;
		// centerY = 565;
	}

	public void draw() {

		app.imageMode(PConstants.CENTER);
		app.image(cavemanImg, centerX, centerY);

	}

	private void directionCaveman() {
		gravity = (float) 0.6;
		if (app.keyCode == PConstants.RIGHT) {

			changeX = speed;

		} else if (app.keyCode == PConstants.LEFT) {

			changeX = -speed;
		}

	}

	public void jumpCaveman() {
		if (app.key == ' ') {
			changeY = -jumpSpeed;
		}
	}

	public void releasedKey() {
		if (app.keyCode == PConstants.RIGHT) {
			changeX = 0;
		}

		if (app.keyCode == PConstants.LEFT) {
			changeX = 0;
		}
	}

	public boolean LeDi(float a, float f, float c, float d, float e) {
		/*float temp = a - b;
		float temp2 = c - b;
		int prueba = (int) (temp - centerX);
		int prueba2 = (int) (temp2 - centerY);*/
		if (app.dist(a, f, c, d) < e) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public void run() {

		directionCaveman();

		try {

			Thread.sleep(10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public boolean isSpeedPower() {
		return speedPower;
	}

	public void setSpeedPower(boolean speedPower) {
		this.speedPower = speedPower;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isOnplatform() {
		return isOnplatform;
	}

	public void setOnplatform(boolean isOnplatform) {
		this.isOnplatform = isOnplatform;
	}

}
