package view;

import controller.ControllerMain;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class MapView implements Runnable {

	private PApplet app;
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
		map = app.loadImage("Img/map2.JPG");
		map.resize(13801, 750);
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
	

	public void drawScreen() {
		app.textFont(montserrat);

		app.imageMode(PApplet.CORNER);
		app.image(map, controllerMain.getPosXbg(), 0);
		app.imageMode(PApplet.CENTER);
		controllerMain.drawObstacles();
		// controllerMain.scrollMap();

	}

	public void moveCaveman() {
		controllerMain.moveCaveman();
		// posX -= 5;

	}

	public void stopCaveman() {
		controllerMain.releasedKey();

	}

	public int switchScreen() {
		int screen = 3;

		if (controllerMain.comprobationGameOver()) {

			screen = 6;

		}
		return screen;

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
