package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Caveman extends Elements implements Runnable {

	private float speed;
	private PImage cavemanImg;
	private PApplet app;
	private boolean speedPower;
	private int velocidad;
	private int jump;
	private boolean jumPower;
	private int control;

	public Caveman(String filename, float posX, float posY, PApplet app) {
		super(filename, posX, posY, app);
		speed = (float) 4;
		cavemanImg = app.loadImage(filename);
		this.app = app;
		speedPower = false;
		jumPower = false;
		velocidad = 1;
		control = 1;

		jump = 155 * control;
		// centerX = 5;
		// centerY = 565;
	}

	public void draw() {
		// Circle circulo = new Circle();
		//app.g.circle(322, 557, 40);
		app.imageMode(PConstants.CENTER);
		app.image(cavemanImg, posX, posY);
		/*if (LeDi(322, 40)) {
			System.out.println("le diiiii");
			// Aqui se coloca la imagen en la misma posicion del circulo
			// 12 es Speed
			// 13 es Jump boost
			speedPower = true;
			jumPower = true;
			velocidad++;
			control++;
		}*/

	}

	public void moveCaveman(int a) throws InterruptedException {
		if (app.keyCode == PConstants.RIGHT) {
			if (speedPower == true) {
				posX = posX + speed * a;
			} else {
				posX = posX + speed;
			}
		} else if (app.keyCode == PConstants.LEFT) {
			if (speedPower == true) {
				posX = posX - speed * a;
			} else {
				posX = posX - speed;
			}

		} else if (app.keyCode == PConstants.UP) {
			int inicial = (int) posY;
			if (posY > inicial - jump) {
				posY = posY - jump / 2;
				Thread.sleep(250);
				posY = posY - jump / 2;
				Thread.sleep(250);
				posY = posY + jump / 2;
				Thread.sleep(250);
				posY = posY + jump / 2;
				Thread.sleep(250);
			}
		}
	}

	public boolean LeDi(float a, int b) {
		float temp = a - b;
		int prueba = (int) (temp - posX);
		if (prueba < 4 && posX < a) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public void run() {
		try {
			moveCaveman(velocidad);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			Thread.sleep(10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	public boolean isJumPower() {
		return jumPower;
	}

	public void setJumPower(boolean jumPower) {
		this.jumPower = jumPower;
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

	
	

}
