package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Caveman extends Elements implements Runnable {

    private float speed;
    private PImage cavemanImg;
    private PApplet app;
    private boolean speedPower;

    public Caveman(String filename, float posX, float posY, PApplet app) {
        super(filename, posX, posY, app);
        speed = (float) 3.5;
        cavemanImg = app.loadImage(filename);
        //this.posX = posX;
        //this.posY = posY;
        this.app = app;
        speedPower = false;

        //centerX = 5; 
        //centerY = 565;
    }

    public void draw() {
        app.imageMode (PConstants.CENTER);
        app.image(cavemanImg, posX, posY);

    }

    public void moveCaveman() {
        if (app.keyCode == PConstants.RIGHT) {
            if (speedPower == true) {
                posX = posX + speed * 2;
            }else {
                posX = posX + speed;
            }
        } else if (app.keyCode == PConstants.LEFT) {
            if(speedPower == true) {
                posX = posX - speed * 2;
            }else {
                posX = posX - speed;
            }

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

    public boolean isSpeedPower() {
        return speedPower;
    }

    public void setSpeedPower(boolean speedPower) {
        this.speedPower = speedPower;
    }




}
