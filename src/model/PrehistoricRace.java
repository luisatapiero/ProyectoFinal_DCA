package model;

import java.util.ArrayList;
import java.util.Iterator;

import processing.core.PApplet;

public class PrehistoricRace {

	private PApplet app;
	private ArrayList<Player> players;

	private static PrehistoricRace onlyInstance;

	public PrehistoricRace(PApplet app) {
		this.app = app;
		players = new ArrayList<>();

	}

	public static PrehistoricRace getInstance(PApplet app) {
		if (onlyInstance == null) {
			onlyInstance = new PrehistoricRace(app);
		}
		return onlyInstance;
	}

	public void addPlayer(String nickname) {
		Player p = new Player(nickname, app);
		players.add(p);
		System.out.println(players.get(0).getNickname());
	}

	public void drawplayers() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).draw(274+(i*25));

		}

	}
	


}
