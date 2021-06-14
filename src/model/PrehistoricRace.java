package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import processing.core.PApplet;
import view.Main;

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
	private CavePlayer jugador;
	private static Main main;

	private ArrayList<Obstacles> obstaclesList;
	private ArrayList<PowerUp> powerUpList;

	private static PrehistoricRace onlyInstance;

	public PrehistoricRace(PApplet app) {
		this.app = app;
		gridSize = 150;
		// main = new Main();

		players = new ArrayList<>();
		obstaclesList = new ArrayList<>();
		powerUpList = new ArrayList<>();
		scorecomparator = new ScoreComparator();
		datecomparator = new DateComparator();
		timecomparator = new TimeComparator();
		jugador = new CavePlayer(90, 565, 1);
		caveman = new Caveman("Img/Character.png", jugador.getPosX(), jugador.getPosY(), app);
		// main.setJugador(jugador);
		rightMargin = 600;
		leftMargin = 90;
		posXbg = 0;

		createObstacles("Data/GridMap.csv");
		System.out.println(powerUpList.size());

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

		for (PowerUp p : powerUpList) {
			p.draw();
			// scrollMap(o);
		}

		caveman.draw();
		checkPowers();
		for (Obstacles o : obstaclesList) {
			o.draw();
			// scrollMap(o);
		}

	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	//COLISIONES
	
	public boolean checkCollision( Caveman o2, Obstacles o1) {  //se supone que deben chacer el cavernicola con el obstaculo
		boolean hNoverlap = o1.getRight()<= o2.getLeft()||o1.getRight()>= o2.getLeft();
		boolean VNoverlap = o1.getBottom()<= o2.getTop()||o1.getBottom()>= o2.getTop();
		if(hNoverlap|| VNoverlap) {
			return false;
		}else {
			return true;
		}
		
	} 
	
	//metodo para las colisones
	
public ArrayList <Obstacles> checkCollisionList(Caveman s,ArrayList<Obstacles>list){
		ArrayList<Obstacles>collision_list=new ArrayList<Obstacles>();
		for(Obstacles p: list) {
			if(checkCollision(s,p))
				collision_list.add(p);
		}
		
		return collision_list;
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
				}
			}
		}

	}

	public void moveCaveman() {
		if (caveman.getPosX() < rightMargin + 3 && caveman.getPosX() > leftMargin - 1) {
			new Thread(caveman).start();

		}

	}

	public void scrollMap() {

		if (app.keyPressed == true) {
			if (caveman.getPosX() > rightMargin && app.keyCode == app.RIGHT) {
				for (int i = 0; i < obstaclesList.size(); i++) {
					obstaclesList.get(i).advanceMap();
				}
				posXbg -= 4;
				//posXbg -= 4 * caveman.getVelocidad();

				for (PowerUp p : powerUpList) {
					p.advanceMap();
				}
			}


			if (caveman.getPosX() < leftMargin && app.keyCode == app.LEFT) {
				for (int i = 0; i < obstaclesList.size(); i++) {
					obstaclesList.get(i).goBackMap();
				}
				
				posXbg += 4;
				//posXbg += 4 * caveman.getVelocidad();

				for (PowerUp p : powerUpList) {
					p.goBackMap();
				}

			}
		}
	}

	private void checkPowers() {
		for (int i = 0; i < powerUpList.size(); i++) {
			if (caveman.LeDi(powerUpList.get(i).getCenterX(), 60)) {
				caveman.setSpeedPower(true);
				caveman.setVelocidad(caveman.getVelocidad() + 1);
				powerUpList.remove(i);
				System.out.println("le diiiii");
			}

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
