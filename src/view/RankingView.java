package view;

import controller.ControllerMain;
import processing.core.PApplet;
import processing.core.PImage;

public class RankingView {
	private ControllerMain controllermain;
	private PImage ranking1, ranking2, ranking3, ranking4;
	private PApplet app;

	private int filter;

	public RankingView(PApplet app) {
		this.app = app;

		ranking1 = app.loadImage("Img/Ranking1.png");
		ranking2 = app.loadImage("Img/Ranking2.png");
		ranking3 = app.loadImage("Img/Ranking3.png");
		ranking4 = app.loadImage("Img/Ranking4.png");
		
		ranking1.resize(1200,750);
		ranking2.resize(1200,750);
		ranking3.resize(1200,750);
		ranking4.resize(1200,750);

		controllermain = new ControllerMain(app);
		filter = 1;
	}

	// método para pintar la pantalla home
	public void drawScreen() {

		switch (filter) {
		case 1:
			app.image(ranking1, 0, 0);
			break;
		case 2:
			app.image(ranking2, 0, 0);
			break;
		case 3:
			app.image(ranking3, 0, 0);
			break;
		case 4:
			app.image(ranking4, 0, 0);
			break;

		default:
			break;
		}
		controllermain.drawplayers();

	}

	// método para pasar de pantalla
	public int switchScreen() {
		int screen = 4;

		if (app.mouseX > 99 && 348 > app.mouseX && app.mouseY > 183 && 257 > app.mouseY) {
			filter = 1;

		}
		if (app.mouseX > 349 && 594 > app.mouseX && app.mouseY > 183 && 257 > app.mouseY) {
			filter = 2;
		}
		if (app.mouseX > 595 && 840 > app.mouseX && app.mouseY > 183 && 257 > app.mouseY) {
			filter = 3;
		}
		if (app.mouseX > 841 && 1090 > app.mouseX && app.mouseY > 183 && 257 > app.mouseY) {
			filter = 4;
		}
		if (app.mouseX > 493 && 702 > app.mouseX && app.mouseY > 599 && 651 > app.mouseY) {
			screen = 2;
		}
		controllermain.sortPlayers(filter);
		return screen;
	}

}
