package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Elements {
	
	  protected PApplet app;
	  
	  protected float posX, posY;
	  protected float centerX, centerY;
	  protected  float changeX, changeY;
	  //private float w, h;

	public Elements(String filename, float posX, float posY, PApplet app) {
		 	
		 	
		 	this.app = app;
		    centerX = posX;
		    centerY = posY;
		    changeX = 0;
		    changeY = 0;
		    
	}
	
	  public void updateMap(){
	     centerX += changeX;
	     centerY += changeY;
	  }
	  
	public float moveLeft() {
		return centerX - app.width/2;
	}
	
	public float moveRight() {
		return centerX + app.width/2;
		
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

