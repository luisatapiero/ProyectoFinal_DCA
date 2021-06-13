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
	private Caveman caveman;
	private final float rightMargin;
	private final float leftMargin;
	private float posXbg;

	private ArrayList<Obstacles> obstaclesList;

	private static PrehistoricRace onlyInstance;

	public PrehistoricRace(PApplet app) {
		this.app = app;
		gridSize = 150;

		players = new ArrayList<>();
		obstaclesList = new ArrayList<>();
		scorecomparator = new ScoreComparator();
		datecomparator = new DateComparator();
		timecomparator = new TimeComparator();
		caveman = new Caveman("Img/Character.png", 32, 565, app);

		rightMargin = 600;
		leftMargin = 90;
		posXbg = 0;

		createObstacles("Data/GridMap.csv");
		System.out.println(obstaclesList.size());

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

		caveman.draw();

		for (Obstacles o : obstaclesList) {
			o.draw();
			// scrollMap(o);
		}

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

	public void moveCaveman() {
		new Thread(caveman).start();
	}

	public void scrollMap() {

		

			if (app.keyPressed == true) {
				if (caveman.getPosX() > rightMargin && app.keyCode == app.RIGHT) {
					System.out.println("Funcionooo");
					for (int i = 0; i < obstaclesList.size(); i++) {
					obstaclesList.get(i).advanceMap();
					}
					posXbg -= 4;
				}

				// float leftBoundary = viewX + leftMargin;

				if (caveman.getPosX() < leftMargin && app.keyCode == app.LEFT) {
					for (int i = 0; i < obstaclesList.size(); i++) {
					obstaclesList.get(i).goBackMap();
					}
					posXbg += 4;
				
			}
		}
	}

	public float getPosXbg() {
		return posXbg;
	}

	public void setPosXbg(float posXbg) {
		this.posXbg = posXbg;
	}
	
	

}
