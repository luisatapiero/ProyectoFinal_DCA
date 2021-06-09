package controller;

import model.PrehistoricRace;
import processing.core.PApplet;

public class ControllerMain {

	private PrehistoricRace pr;

	public ControllerMain(PApplet app) {
		pr = PrehistoricRace.getInstance(app);
	}

	public void addPlayer(String nickname) {
		pr.addPlayer(nickname);
	}

	public void drawplayers() {
		pr.drawplayers();
	}

}
