package view;

import controller.ControllerMain;
import exceptions.GameOverException;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class MapView implements Runnable {

	private PApplet app;
	private PImage resume;
	private PImage map;
	private ControllerMain controllerMain;
	private PImage noexiste;
//----------------------------------------------------------------------------------------------------------------------------------

	private int mil = 0;
	private int s = 0;
	private int m = 0;
	private int forMinute = 0;

	private PFont montserrat;

//--------------------------------------------------------------------------------------------------------------------------------

	public MapView(PApplet app) {
		this.app = app;
		///map = app.loadImage("Img/map2.JPG");
		map = app.loadImage("Img/Map.png");
		map.resize(13801, 750);
		resume = app.loadImage("Img/Score1-04.png");
		resume.resize(1200, 750);
		controllerMain = new ControllerMain(app);

		montserrat = app.createFont("Fonts/Montserrat-Regular.ttf", 20);
		
		runtimeException1 ();
		runtimeException2();
		runtimeException3 ();		
	}
	
	private void runtimeException1 (){

			
			try {
				String nonExisted = null;
				Integer.parseInt(nonExisted);
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("1. Exception Number Format Exception");
			}
	}
	
	public void runtimeException2() {
		try {
			
			int suma = 12/0;
			
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("2. Arithmetic exception");
		}
		
	}
	
	private void runtimeException3 (){
		
		
		try {
			app.image(noexiste, 2, 2);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("3. Exception Null Pointer Exception");
		}
}
	

	public int drawScreen(int screen) {
		app.textFont(montserrat);
		
		if (screen == 5) {
			app.imageMode(PApplet.CORNER);
			app.image(map, controllerMain.getPosXbg(), 0);
			app.imageMode(PApplet.CENTER);
			
			try {
				controllerMain.drawObstacles();
				controllerMain.comprobationGameOver();
			} catch (GameOverException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				
				screen = 6;
			
				
				
			}
		}
		
		
		if (screen == 6) {
			app.imageMode(PApplet.CORNER);
			app.image(resume, 0, 0);
		
		}
		return screen;
		

		
		// controllerMain.scrollMap();

	}

	public void moveCaveman(int screen) {
		if (screen != 6) {
			controllerMain.moveCaveman();
		}
		
		// posX -= 5;

	}

	public void stopCaveman(int screen) {
		
		if (screen != 6) {
			controllerMain.releasedKey();
		}

	}


//--------------------------------------------------------------------------------------------------------------------------

	// TEMPORAL
	public void time() {

		app.textFont(montserrat);
		app.textAlign(10, 10);
		if (mil <= 59) {
			app.text(m + ":" + s + ":" + mil, 1110, 42);
			mil = mil + 1;
		} else {
			s = s + 1;
			mil = 0;
			m = 0;
			app.text(m + ":" + s + ":" + mil, 1110, 42);
		}

		if (s >= 59) {
			m = 0;
			s = 0;
			app.text(m + ":" + s + ":" + mil, 1110, 42);
		}

	}

	@Override
	public void run() {
		time();

		try {

			Thread.sleep(10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// --------------------------------------------------------------------------------------------------------------------------

}
