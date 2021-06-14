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
		
		instruction1.resize(1200,750);
		instruction2.resize(1200,750);
		
		controllermain = new ControllerMain(app);
		
	
			runtimeException2();
		
		
	}

	// método para pintar la pantalla home
		public void drawScreen() {

			if (app.mouseX > 479 && 701 > app.mouseX && app.mouseY > 600 && 654 > app.mouseY) {
				app.image(instruction2, 0, 0);

			} else {
				app.image(instruction1, 0, 0);
			}
		}

		// método para pasar de pantalla
		public int switchScreen() {
			int screen = 3;

			if (app.mouseX > 479 && 701 > app.mouseX && app.mouseY > 600 && 654 > app.mouseY) {
			
				screen = 2;
			}
			return screen;
		}
		
		public void runtimeException2() {
			try {
				
				int suma = 12/0;
				
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("2. Arithmetic exception");
			}
			
		}
}
