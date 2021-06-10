package view;

import processing.core.PApplet;
import processing.core.PImage;

public class MapView {
	
	private PApplet app;
	private PImage map;

	public MapView(PApplet app) {
		this.app = app;
		map = app.loadImage("Img/Map.png");
		map.resize(13801, 750);
	}
	
	public void drawScreen() {

			app.image(map, 0, 0);

	}

}
