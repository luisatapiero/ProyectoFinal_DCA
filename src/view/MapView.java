package view;

import controller.ControllerMain;
import processing.core.PApplet;
import processing.core.PImage;

public class MapView {
	
	private PApplet app;
	private PImage map;
	private ControllerMain controllerMain;



	public MapView(PApplet app) {
		this.app = app;
		map = app.loadImage("Img/Map.png");
		map.resize(13801, 750);
		controllerMain = new ControllerMain(app);
	}
	
	public void drawScreen() {
			app.imageMode(PApplet.CORNER);
			app.image(map, 0, 0);
			app.imageMode(PApplet.CENTER);
			controllerMain.drawObstacles();

	}
	
	public void moveCaveman() {
		controllerMain.moveCaveman();
		//posX -= 5;
		
		
	}
	

	

	 

}
