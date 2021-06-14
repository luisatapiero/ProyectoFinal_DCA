package view;

import controller.ControllerMain;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class MapView {
	
	private PApplet app;
	private PImage map;
	private ControllerMain controllerMain;
//----------------------------------------------------------------------------------------------------------------------------------
	
	private int mil=0;
	private int s=0;
	private int m=0;
	private int forMinute=0;
	
	private PFont montserrat;
	
//--------------------------------------------------------------------------------------------------------------------------------

	public MapView(PApplet app) {
		this.app = app;
		map = app.loadImage("Img/Map.png");
		map.resize(13801, 750);
		controllerMain = new ControllerMain(app);
	
		montserrat = app.createFont("Fonts/Montserrat-Regular.ttf", 20);

	}
	
	public void drawScreen() {
		    app.textFont(montserrat);
		    
			app.imageMode(PApplet.CORNER);
			app.image(map, controllerMain.getPosXbg(), 0);
			app.imageMode(PApplet.CENTER);
			controllerMain.drawObstacles();
			controllerMain.scrollMap();
			

	}
	
	public void moveCaveman() {
		controllerMain.moveCaveman();
		//posX -= 5;	
		
	}
	
	public void comprobationGameOver(int screen) {
		controllerMain.comprobationGameOver(screen);
	}

	public void stopCaveman() {
		controllerMain.releasedKey();
		
	}
	
//--------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	//TEMPORAL
	public void time() {
		
			app.textFont(montserrat);
			app.textAlign(10, 10);
				if(mil<=59) {
					app.text(m+":"+s+":"+ mil, 1110, 42);	
					mil = mil + 1;
					}else {
						s = s+1;
						mil= 0;
						m = 0;
						app.text(m+":"+s+":"+ mil, 1110, 42);	
					}
				
				if(s>=59) {
					m = 0;
					s=0;
					app.text(m+":"+s+":"+ mil, 1110, 42);	
				}
				
				
			}
	

	//--------------------------------------------------------------------------------------------------------------------------	 

	
}
