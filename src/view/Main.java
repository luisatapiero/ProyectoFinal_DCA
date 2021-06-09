package view;

import processing.core.PApplet;

public class Main extends PApplet {

	private int screen;
	private NicknameView nicknameview;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
		// TODO Auto-generated method stub

	}

	public void settings() {
		size(1151, 701);
	}

	public void setup() {
		screen = 1;
		nicknameview = new NicknameView(this);

	}

	public void draw() {
		background(0);

		switch (screen) {
		case 1:
			nicknameview.drawScreen();
			nicknameview.showCp5();

			break;
		case 2:
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
			
			break;

		default:
			break;
		}
	}

}
