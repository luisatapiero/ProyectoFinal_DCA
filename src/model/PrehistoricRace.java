package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import processing.core.PApplet;

public class PrehistoricRace {

	private PApplet app;
	private ArrayList<Player> players;
	private ScoreComparator scorecomparator;
	private DateComparator datecomparator;
	private TimeComparator timecomparator;

	private static PrehistoricRace onlyInstance;

	public PrehistoricRace(PApplet app) {
		this.app = app;
		players = new ArrayList<>();

		scorecomparator = new ScoreComparator();
		datecomparator = new DateComparator();
		timecomparator = new TimeComparator();

		/* jugadores para probar ordenamientos */
		Player n = new Player("pepe", app);
		n.setScore(10);
		n.setGameTime(45);
		players.add(n);
		Player n1 = new Player("pepe", app);
		n1.setScore(30);
		n1.setGameTime(50);
		players.add(n1);

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
			players.get(i).draw(274 + (i * 25));

		}

	}

	public void sortPlayers(int filter) {
		switch (filter) {
		case 1:
			Collections.sort(players);
			break;
		case 2:
			Collections.sort(players, scorecomparator);
			break;
		case 3:
			Collections.sort(players, datecomparator);
			break;
		case 4:
			Collections.sort(players, timecomparator);
			break;

		default:
			break;
		}
	}

}
