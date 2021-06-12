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

	private final float gridSize;
	private Obstacles obstacles;
	private Caveman caveman;
	private ArrayList<Obstacles> obstaclesList;

	private static PrehistoricRace onlyInstance;

	public PrehistoricRace(PApplet app) {
		this.app = app;
		this.gridSize = 150;

		players = new ArrayList<>();
		obstaclesList = new ArrayList<>();

		scorecomparator = new ScoreComparator();
		datecomparator = new DateComparator();
		timecomparator = new TimeComparator();
		caveman = new Caveman(0, 565, 5, app);

		createObstacles("Data/GridMap.csv");

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

	public void drawObstacles() {

		// obstacles.draw();
		// obstacles.updateMap();
		caveman.draw();

		for (Obstacles o : obstaclesList)
			o.draw();
	}

	private void createObstacles(String filename) {
		String[] lines = app.loadStrings(filename);
		for (int row = 0; row < lines.length; row++) {
			String[] values = app.split(lines[row], ";");
			for (int col = 0; col < values.length; col++) {
				if (values[col].equals("1")) {
					Obstacles o = new Obstacles("Img/Blocks/Forest1.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				} else if (values[col].equals("2")) {
					Obstacles o = new Obstacles("Img/Blocks/Forest2.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				} else if (values[col].equals("3")) {
					Obstacles o = new Obstacles("Img/Blocks/Forest3.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				} else if (values[col].equals("4")) {
					Obstacles o = new Obstacles("Img/Blocks/Desert1.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				}

				else if (values[col].equals("5")) {
					Obstacles o = new Obstacles("Img/Blocks/Desert2.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				} else if (values[col].equals("6")) {
					Obstacles o = new Obstacles("Img/Blocks/Desert3.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				} else if (values[col].equals("7")) {
					Obstacles o = new Obstacles("Img/Blocks/Polo1.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				}

				else if (values[col].equals("8")) {
					Obstacles o = new Obstacles("Img/Blocks/Polo2.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				} else if (values[col].equals("9")) {
					Obstacles o = new Obstacles("Img/Blocks/Polo3.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				} else if (values[col].equals("10")) {
					Obstacles o = new Obstacles("Img/Blocks/Cliff1.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				}

				else if (values[col].equals("11")) {
					Obstacles o = new Obstacles("Img/Blocks/Cliff2.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					obstaclesList.add(o);
				}
			}
		}

	}

	public void moveMap() {
		if (app.keyCode == app.RIGHT) {
			caveman.setPosX(caveman.getPosX() + caveman.getSpeed());
		} else if (app.keyCode == app.LEFT) {
			caveman.setPosX(caveman.getPosX() - caveman.getSpeed());
		}
	}


}
