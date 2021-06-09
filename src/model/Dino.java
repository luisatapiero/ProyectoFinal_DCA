package model;

import processing.core.PApplet;

public class Dino  extends Caveman {

	private int vx;
	private int vy;
	private PApplet app;
	
	public Dino(String recurso, int x, int y, int xt,int vx,int vy) {
		super(recurso, x, y, xt);
		this.vx=vx;
		this.vy=vy;
		
	}
}
