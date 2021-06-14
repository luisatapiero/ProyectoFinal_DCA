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

    public Caveman(String filename, float posX, float posY, PApplet app) {
        super(filename, posX, posY, app);
        speed = (float) 3.5;
        cavemanImg = app.loadImage(filename);
        //this.posX = posX;
        //this.posY = posY;
        this.app = app;
        speedPower = false;
        velocidad = 1;

        //centerX = 5; 
        //centerY = 565;
    }

    public void draw() {
    	app.circle(322, 557, 40);
        app.imageMode (PConstants.CENTER);
        app.image(cavemanImg, posX, posY);
        if(LeDi(322,40)) {
        	System.out.println("le diiiii");
        	//Aqui se coloca la imagen en la misma posicion del circulo
        	speedPower = true;
        	velocidad++;
        	
        	
        }

    }

    public void moveCaveman(int a) {
        if (app.keyCode == PConstants.RIGHT) {
            if (speedPower == true) {
                posX = posX + speed * a;
            }else {
                posX = posX + speed;
            }
        } else if (app.keyCode == PConstants.LEFT) {
            if(speedPower == true) {
                posX = posX - speed * a;
            }else {
                posX = posX - speed;
            }

        }
    }
    
    public boolean LeDi(int a, int b) {
    	int temp = a - b;
    	int prueba = (int) (temp - posX);
    	if (prueba < 4 && posX < a ) {
    		return true;
    		
    	}else {
    		return false;
    	}
    }




    @Override
    public void run() {
        moveCaveman(velocidad);

        try {

            Thread.sleep(10);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isSpeedPower() {
        return speedPower;
    }

    public void setSpeedPower(boolean speedPower) {
        this.speedPower = speedPower;
    }




}
