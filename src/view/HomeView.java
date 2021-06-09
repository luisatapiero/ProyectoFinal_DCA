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

		controllermain = new ControllerMain(app);
	}

	// método para pintar la pantalla home
	public void drawScreen() {

		if (app.mouseX > 443 && 685 > app.mouseX && app.mouseY > 156 && 399 > app.mouseY) {
			app.image(home2, 0, 0);

		} else if (app.mouseX > 829 && 968 > app.mouseX && app.mouseY > 215 && 356 > app.mouseY) {
			app.image(home3, 0, 0);
		} else if (app.mouseX > 158 && 298 > app.mouseX && app.mouseY > 215 && 356 > app.mouseY) {
			app.image(home4, 0, 0);
		} else {
			app.image(home1, 0, 0);

		}

	}

	// método para pasar de pantalla
	public int switchScreen() {
		int screen = 2;

		if (app.mouseX > 443 && 685 > app.mouseX && app.mouseY > 156 && 399 > app.mouseY) {
			screen = 5;

		}
		if (app.mouseX > 829 && 968 > app.mouseX && app.mouseY > 215 && 356 > app.mouseY) {
			screen = 3;
		}
		if (app.mouseX > 158 && 298 > app.mouseX && app.mouseY > 215 && 356 > app.mouseY) {
			screen = 4;
		}
		return screen;
	}

}
