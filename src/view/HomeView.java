package view;

import controller.ControllerMain;
import processing.core.PApplet;
import processing.core.PImage;

public class HomeView {
	private ControllerMain controllermain;
	private PImage home1, home2, home3, home4;
	private PApplet app;

	public HomeView(PApplet app) {
		this.app = app;

		home1 = app.loadImage("Img/Home1.png");
		home2 = app.loadImage("Img/Home2.png");
		home3 = app.loadImage("Img/Home3.png");
		home4 = app.loadImage("Img/Home4.png");
		
		home1.resize(1200,750);
		home2.resize(1200,750);
		home3.resize(1200,750);
		home4.resize(1200,750);

		controllermain = new ControllerMain(app);
	}

	// método para pintar la pantalla home
	public void drawScreen() {

		if (app.mouseX > 458 && 711 > app.mouseX && app.mouseY > 167 && 428 > app.mouseY) {
			app.image(home2, 0, 0);
			
		} else if (app.mouseX > 859 && 1007 > app.mouseX && app.mouseY > 235 && 388 > app.mouseY) {
			app.image(home3, 0, 0);
			
		} else if (app.mouseX > 160 && 310 > app.mouseX && app.mouseY > 236 && 386 > app.mouseY) {
			
			app.image(home4, 0, 0);
		} else {
			app.image(home1, 0, 0);

		}

	}

	// método para pasar de pantalla
	public int switchScreen() {
		int screen = 2;

		if (app.mouseX > 458 && 711 > app.mouseX && app.mouseY > 167 && 428 > app.mouseY) {
			screen = 5;

		}
		if (app.mouseX > 859 && 1007 > app.mouseX && app.mouseY > 235 && 388 > app.mouseY) {
			screen = 3;
		}
		if (app.mouseX > 160 && 310 > app.mouseX && app.mouseY > 236 && 386 > app.mouseY) {
			screen = 4;
		}
		return screen;
	}

}
