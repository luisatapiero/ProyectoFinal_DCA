package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import exceptions.EmptyNicknameException;
import exceptions.GameOverException;
import processing.core.PApplet;
import processing.core.PConstants;

public class PrehistoricRace {

	private PApplet app;
	private ArrayList<Player> players;
	private ScoreComparator scorecomparator;
	private DateComparator datecomparator;
	private TimeComparator timecomparator;

	private final float gridSize;
	private Caveman caveman;
	private Meat meat;
	private final float rightMargin;
	private final float leftMargin;
	private float posXbg;

	private ArrayList<Obstacles> obstaclesList;
	private ArrayList<PowerUp> powerUpList;
	private ArrayList<DinoFlyer> dinoFList;
	private ArrayList<DinoTerrestral> dinoTList;

	private static PrehistoricRace onlyInstance;

	public PrehistoricRace(PApplet app) {
		this.app = app;
		gridSize = 150;
		// main = new Main();

		players = new ArrayList<>();
		obstaclesList = new ArrayList<>();
		powerUpList = new ArrayList<>();
		dinoFList = new ArrayList<>();
		dinoTList = new ArrayList<>();
		
		scorecomparator = new ScoreComparator();
		datecomparator = new DateComparator();
		timecomparator = new TimeComparator();
		// jugador = new CavePlayer(91, 565, 1);
		
		caveman = new Caveman("Img/Character.png", 101, 20, app);
		caveman.centerX = 101;
		caveman.centerY = 100;
		// caveman.setCenterY(-10);
		rightMargin = 300;
		leftMargin = 0;
		posXbg = 0;

		createObstacles("Data/GridMap.csv");
		// System.out.println(powerUpList.size());

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
		System.out.println(players.get(2).getNickname());
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

	public void drawObstacles() throws GameOverException {

		for (PowerUp p : powerUpList) {
			p.draw();
		}

		caveman.draw();
		

			scrollMap();

		
		resolvePlatformCollisions(caveman, obstaclesList);

		collectPoints();

		eatenbyDino();

		for (Obstacles o : obstaclesList) {
			o.draw();
		}

		for (DinoTerrestral o : dinoTList) {
			o.draw();
		}

		for (DinoFlyer o : dinoFList) {
			o.draw();
		}

	}

	// -------------------------------------------------------------------------------------------------------------------

	// COLISIONES

	public boolean checkCollision(Caveman c, Obstacles o1) { // se supone que deben chacer el cavernicola con el
																// obstaculo
		boolean hNoverlap = c.getRight(66) <= o1.getLeft(150) || c.getLeft(66) >= o1.getRight(150);
		boolean VNoverlap = c.getBottom(71) <= o1.getTop(150) || c.getTop(71) >= o1.getBottom(150);
		if (hNoverlap || VNoverlap) {
			return false;
		} else {
			return true;
		}
	}

	// metodo para las colisones

	public ArrayList<Obstacles> checkCollisionList(Caveman c, ArrayList<Obstacles> list) {
		ArrayList<Obstacles> collision_list = new ArrayList<Obstacles>();
		for (Obstacles p : list) {
			if (checkCollision(c, p))
				collision_list.add(p);
		}

		return collision_list;
	}

	public void resolvePlatformCollisions(Caveman c, ArrayList<Obstacles> walls) {

		c.changeY += caveman.getGravity();

		c.centerY += c.changeY;

		ArrayList<Obstacles> col_list = checkCollisionList(c, walls);

		if (col_list.size() > 0) {
			Obstacles collided = col_list.get(0);
			if (c.changeY > 0) {
				c.setBottom(collided.getTop(150), 71);
			} else if (c.changeY < 0) {
				c.setTop(collided.getBottom(150), 71);
			}
			c.changeY = 0;
		}

		c.centerX += c.changeX;
		col_list = checkCollisionList(c, walls);

		if (col_list.size() > 0) {
			System.out.println(col_list.size());
			Obstacles collided = col_list.get(0);
			if (c.changeX > 0) {
				c.setRight(collided.getLeft(150), 66);

			} else if (c.changeX < 0) {
				c.setLeft(collided.getRight(150), 66);

			}

		}
		if (col_list.size() == 1) {
			col_list.remove(0);
		}

	}

//--------------SALTO------------------------------------------------------------------------------------------------

	public boolean isOnplatform(Caveman c, ArrayList<Obstacles> walls) {

		c.centerY += 5;
		ArrayList<Obstacles> col_list = checkCollisionList(c, walls);
		c.centerY -= 5;
		if (col_list.size() > 0) {
			c.setOnplatform(true);
			return true;
		} else {
			c.setOnplatform(false);
			System.out.println(isOnplatform(c, walls));
			return false;
		}
	}

//-------------------------------------------------------------------------------------------------------------------
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
				} else if (values[col].equals("5")) {
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
				} else if (values[col].equals("12")) {
					PowerUp o = new PowerUp("Img/Blocks/Chili.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					powerUpList.add(o);
				} else if (values[col].equals("13")) {
					PowerUp o = new PowerUp("Img/Blocks/mushroom.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					powerUpList.add(o);
				} else if (values[col].equals("14")) {
					DinoTerrestral o = new DinoTerrestral("Img/Blocks/dinos-09.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					dinoTList.add(o);
				} else if (values[col].equals("15")) {
					DinoFlyer o = new DinoFlyer("Img/Blocks/dinos-10.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					dinoFList.add(o);
				} else if (values[col].equals("16")) {
					Meat o = new  Meat("Img/Blocks/meat-20.png", 0, 0, app);
					o.setCenterX(gridSize / 2 + col * gridSize);
					o.setCenterY(gridSize / 2 + row * gridSize);
					
				}
			}
		}

	}

	public void moveCaveman() {
		if ((caveman.getCenterX() > leftMargin && caveman.getCenterX() < rightMargin) || (posXbg <= -12584)) {

			new Thread(caveman).start();
		}

		caveman.jumpCaveman();

	}

	public void releasedKey() {
		caveman.releasedKey();
	}

	public void scrollMap() {

		if (app.keyPressed == true ) {
			if (caveman.getCenterX() > rightMargin && app.keyCode == app.RIGHT && posXbg <= 4 && posXbg >= -12584) {
				for (int i = 0; i < obstaclesList.size(); i++) {
					obstaclesList.get(i).advanceMap();
				}
				posXbg -= 4;

				for (PowerUp p : powerUpList) {
					p.advanceMap();
				}

				for (DinoTerrestral o : dinoTList) {
					new Thread(o).start();
				}

				for (DinoFlyer o : dinoFList) {
					new Thread(o).start();
				}
			}

			if (caveman.getCenterX() > leftMargin && app.keyCode == PConstants.LEFT && posXbg <= 0 && posXbg >= -12584) {
				for (int i = 0; i < obstaclesList.size(); i++) {
					obstaclesList.get(i).goBackMap();
				}

				posXbg += 4;

				for (PowerUp p : powerUpList) {
					p.goBackMap();
				}

				for (DinoTerrestral o : dinoTList) {
					o.goBackMap();
					// scrollMap(o);
				}

				for (DinoFlyer o : dinoFList) {
					o.goBackMap();
					// scrollMap(o);
				}

			}
		}
		
		System.out.println(posXbg);
	}

	private void collectPoints() {
		for (int i = 0; i < powerUpList.size(); i++) {
			if (caveman.LeDi(caveman.getCenterX(), caveman.getCenterY(), powerUpList.get(i).getCenterX(), powerUpList.get(i).getCenterY(), 60)) {
				powerUpList.remove(i);
			}

		}

	}

	private void eatenbyDino() throws GameOverException {
		for (int i = 0; i < dinoTList.size(); i++) {
			if (caveman.LeDi(caveman.getCenterX(), caveman.getCenterY(), dinoTList.get(i).getCenterX(), dinoTList.get(i).getCenterY(), 30)){
				throw new GameOverException("Perdiste, vuelve a intentarlo");
			}
		}
			for (int j = 0; j < dinoFList.size(); j++) {
				if (caveman.LeDi(caveman.getCenterX(), caveman.getCenterY(), dinoFList.get(j).getCenterX(), dinoFList.get(j).getCenterY(), 30)) {
					throw new GameOverException("Perdiste, vuelve a intentarlo");
				}
			}


	}
	
	
	private void win() {
		if (caveman.LeDi(caveman.getCenterX(), caveman.getCenterY(), meat.getCenterX(), meat.getCenterY(), 30)) {
			//throw new GameOverException("Perdiste, vuelve a intentarlo");
			System.out.println("GANASTEEEE");
		}
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------
	// METODO DE GAME OVER
	public void comprobationGameOver() throws GameOverException {

		if (caveman.centerY > 780) {
			throw new GameOverException("Perdiste, vuelve a intentarlo");
		}

	}

	public float getPosXbg() {
		return posXbg;
	}

	public void setPosXbg(float posXbg) {
		this.posXbg = posXbg;
	}

	public void stopCaveman() {
		new Thread(caveman).start();
	}

}
