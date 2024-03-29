package view;

import controller.ControllerMain;

import processing.core.PApplet;

public class Main extends PApplet {

	private int screen;
	private NicknameView nicknameview;
	private HomeView homeview;
	private InstructionsView instructionsview;
	private RankingView rankingview;
	private MapView mapview;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
		// TODO Auto-generated method stub

	}

	public void settings() {
		size(1200, 750);
	}

	public void setup() {
		screen = 1;
		nicknameview = new NicknameView(this);
		homeview = new HomeView(this);
		instructionsview = new InstructionsView(this);
		rankingview = new RankingView(this);
		mapview = new MapView(this);

	}

	public void draw() {
		background(0);

		switch (screen) {
		case 1:
			nicknameview.drawScreen();
			nicknameview.showCp5();

			break;
		case 2:
			homeview.drawScreen();
			nicknameview.hideCp5();

			break;
		case 3:
			instructionsview.drawScreen();
			nicknameview.hideCp5();

			break;
		case 4:
			rankingview.drawScreen();
			nicknameview.hideCp5();

			break;
		case 5:
			mapview.drawScreen(screen);
			nicknameview.hideCp5();
			new Thread (mapview).start();
			//screen = mapview.switchScreen();
			screen = mapview.drawScreen(screen);
			break;
			
			
		case 6:
			mapview.drawScreen(screen);
			screen = mapview.drawScreen(screen);
			nicknameview.hideCp5();
			//mapview.time();
			//screen = mapview.switchScreen();
			break;
			
		case 7:
			mapview.drawScreen(screen);
			screen = mapview.drawScreen(screen);
			nicknameview.hideCp5();
			//mapview.time();
			//screen = mapview.switchScreen();
			break;

		default:
			break;
		}

		text("x:" + mouseX + "y:" + mouseY, mouseX, mouseY);

	}

	public void mousePressed() {

		switch (screen) {
		case 1:

			screen = nicknameview.switchScreen();

			break;
		case 2:
			screen = homeview.switchScreen();
			break;
		case 3:
			screen = instructionsview.switchScreen();
			break;
		case 4:
			screen = rankingview.switchScreen();
			break;
		case 5:
			
			break;
			
		case 6:
			screen = mapview.switchScreen(screen);
			break;
		default:
			break;
		}
	}
	
	public void keyPressed() {
		switch (screen) {
		case 5:
			mapview.moveCaveman(screen);
			break;

		default:
			break;
		}
	}
	
	public void keyReleased() {
		switch (screen) {
		case 5:
			mapview.stopCaveman(screen);
			break;

		default:
			break;
		}
	}

	

}
