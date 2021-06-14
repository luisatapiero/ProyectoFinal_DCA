package view;

import controlP5.ControlP5;
import controlP5.Textfield;
import controller.ControllerMain;
import exceptions.EmptyNicknameException;
import exceptions.LongNicknameException;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class NicknameView {
	private ControllerMain controllermain;
	private PImage nickname1, nickname2;
	private PApplet app;

	private ControlP5 cp5;
	private PFont montserrat;
	private String[] inputs;
	private String nickname;

	public NicknameView(PApplet app) {
		controllermain = new ControllerMain(app);
		this.app = app;

		nickname1 = app.loadImage("Img/Nickname1.png");
		nickname2 = app.loadImage("Img/Nickname2.png");
		montserrat = app.createFont("Fonts/Montserrat-Regular.ttf", 20);

		nickname1.resize(1200, 750);
		nickname2.resize(1200, 750);

		// inicializar cp5 y textfields
		cp5 = new ControlP5(app);
		inputs = new String[1];
		inputs[0] = "nickname";

		// personalziar textfields
		cp5.addTextfield(inputs[0]).setPosition(460, 458).setSize(246, 39).setAutoClear(true)
				.setColorValue(app.color(255)).setColorActive(app.color(0, 0, 0, 1))
				.setColorBackground(app.color(0, 0, 0, 1)).setColorForeground(app.color(0, 0, 0, 1))
				.setColor(app.color(255, 255, 255, 255)).setColorCursor(app.color(0, 0, 0, 255)).setFont(montserrat)
				.getCaptionLabel().hide();
	}

	// método para pintar la pantalla home
	public void drawScreen() {

		if (app.mouseX > 497 && 702 > app.mouseX && app.mouseY > 598 && 651 > app.mouseY) {
			app.image(nickname2, 0, 0);

		} else {
			app.image(nickname1, 0, 0);
		}

	}

	// método para pasar de pantalla
	public int switchScreen() {
		int screen = 1;

		if (app.mouseX > 497 && 702 > app.mouseX && app.mouseY > 598 && 651 > app.mouseY) {
			try {
				createUser();
				emptyTextfields();
				screen = 2;
			} catch (EmptyNicknameException a) {
				System.err.println(a.getMessage());
			} catch (LongNicknameException b) {
				emptyTextfields();
				System.err.println(b.getMessage());
			}

		}
		return screen;
	}

	// capturar el nickname y crear usuario
	public void createUser() throws EmptyNicknameException, LongNicknameException {
		nickname = cp5.get(Textfield.class, "nickname").getText();
		if (nickname.equals("")) {
			throw new EmptyNicknameException();
		} else if (nickname.length() > 10) {
			throw new LongNicknameException();
		} else {
			controllermain.addPlayer(nickname);

		}

	}

	public void hideCp5() {
		cp5.hide();

	}

	public void showCp5() {
		cp5.show();

	}

	public void emptyTextfields() {
		cp5.get(Textfield.class, "nickname").setText("");

	}
}
