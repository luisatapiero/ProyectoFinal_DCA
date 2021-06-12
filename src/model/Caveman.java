package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Caveman implements Runnable{


	private int posX;
	private int posY;
	private int speed;
	private boolean crashed;
	private PImage cavemanImg;
	private PApplet app;
	
	public Caveman (int posX, int posY, int speed, PApplet app) {
		this.posX=posX;
		this.posY=posY;
		this.speed = speed;
		this.app = app;
		
		cavemanImg = app.loadImage ("Img/Character.png");

		//imagen = new ImageIcon(this.getClass().getResource(recurso)).getImage();
	}
	
	public void draw() {
		     app.image(cavemanImg, posX, posY);
		     
	}
	
	public void moveCaveman() {
		if (app.keyCode == app.RIGHT) {
			posX = posX + speed;
		} else if (app.keyCode == app.LEFT) {
			posX = posX - speed;
		}
	}
	
	@Override
	public void run() {
		moveCaveman();
		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
	
	
}
