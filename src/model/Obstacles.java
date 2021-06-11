package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Obstacles {
	
	  private PApplet app;
	  private PImage obstacleImg;
	  private float centerX, centerY;
	  private float changeX, changeY;
	  //private float w, h;

	public Obstacles(String filename, float x, float y, PApplet app) {
		 	obstacleImg = app.loadImage(filename);
		 	
		 	this.app = app;
		    centerX = x;
		    centerY = y;
		    changeX = 0;
		    changeY = 0;
		    
	}
	

	  public void draw(){
	     app.image(obstacleImg, centerX, centerY);
	     obstacleImg.resize(150, 150);
	  }
	  public void updateMap(){
	     centerX += changeX;
	     centerY += changeY;
	  }


	public float getCenterX() {
		return centerX;
	}


	public void setCenterX(float centerX) {
		this.centerX = centerX;
	}


	public float getCenterY() {
		return centerY;
	}


	public void setCenterY(float centerY) {
		this.centerY = centerY;
	}


	public float getChangeX() {
		return changeX;
	}


	public void setChangeX(float changeX) {
		this.changeX = changeX;
	}


	public float getChangeY() {
		return changeY;
	}


	public void setChangeY(float changeY) {
		this.changeY = changeY;
	}
	}

