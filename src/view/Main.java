package view;

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
			mapview.drawScreen();
			nicknameview.hideCp5();

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
		default:
			break;
		}
	}

}
