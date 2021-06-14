package model;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;


public class ResistencePower {
    private int posX;
    private int posY;
    private int x1;
    private int x2;
    private int radio;
    private PApplet app;

    public ResistencePower(int posX, int posY, int x1, int x2, int radio) {

        posX = posX;
        posY = posY;
        x1 = x1;
        x2 = x2;
        radio = 30;
    }

    //Esta parte hace lo de la resistencia

    public void Resistence() {
        //if()
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

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public PApplet getApp() {
        return app;
    }

    public void setApp(PApplet app) {
        this.app = app;
    }



}