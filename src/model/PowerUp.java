package model;

import processing.core.PApplet;
import processing.core.PImage;

public class PowerUp extends Elements {
	/*
	 * private int posx; private int posy; public final static int SPEED = 1; public
	 * final static int RESIS = 2; private int tipo;
	 */
	private PImage powerupImg;

	public PowerUp(String filename, float posX, float posY, PApplet app) {
		super(filename, posX, posY, app);
		powerupImg = app.loadImage(filename);
	}

	public void draw() {
		app.imageMode(PApplet.CENTER);

		app.image(powerupImg, centerX, centerY + 50);
		powerupImg.resize(70, 60);

	}

	public void advanceMap() {
		centerX -= 4;
		/// centerY += changeY;
	}

	public void goBackMap() {
		centerX += 4;
	}

	/*
	 * public int getPosx() { return posx; } public void setPosx(int posx) {
	 * this.posx = posx; } public int getPosy() { return posy; } public void
	 * setPosy(int posy) { this.posy = posy; } public int getTipo() { return tipo; }
	 * public void setTipo(int tipo) { this.tipo = tipo; }
	 */

}
