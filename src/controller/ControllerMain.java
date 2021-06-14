package controller;

import model.Caveman;
import model.Obstacles;
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

	public void sortPlayers(int filter) {
		pr.sortPlayers(filter);
	}

	public void drawObstacles() {
		pr.drawObstacles();
	}
	
	public void scrollMap() {
		pr.scrollMap();
	}

	public void moveCaveman() {
		pr.moveCaveman();
	}
	
	public float getPosXbg() {
		return pr.getPosXbg();
	}

	public void setPosXbg(float posXbg) {
		this.pr.setPosXbg(posXbg);
	}

	public void stopCaveman() {
		pr.stopCaveman();
		
	}

	
}
