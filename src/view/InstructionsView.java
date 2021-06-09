package view;

import controller.ControllerMain;
import processing.core.PApplet;
import processing.core.PImage;

public class InstructionsView {
	private ControllerMain controllermain;
	private PImage instruction1, instruction2;
	private PApplet app;

	public InstructionsView(PApplet app) {
		this.app = app;
		
		instruction1 = app.loadImage("Img/Instructions1.png");
		instruction2 = app.loadImage("Img/Instructions2.png");
		
		controllermain = new ControllerMain(app);
	}

	// método para pintar la pantalla home
		public void drawScreen() {

			if (app.mouseX > 479 && 677 > app.mouseX && app.mouseY > 557 && 612 > app.mouseY) {
				app.image(instruction2, 0, 0);

			} else {
				app.image(instruction1, 0, 0);
			}
		}

		// método para pasar de pantalla
		public int switchScreen() {
			int screen = 3;

			if (app.mouseX > 479 && 677 > app.mouseX && app.mouseY > 557 && 612 > app.mouseY) {
			
				screen = 2;
			}
			return screen;
		}
}
