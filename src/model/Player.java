package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class Player implements Comparable<Player> {

	private String nickname;
	private LocalDateTime date;
	private String dateString;
	private int score;
	private int gameTime;
	private PApplet app;

	private PFont montserrat;

	public Player(String nickname, PApplet app) {
		this.nickname = nickname;
		this.app = app;
		date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		dateString = date.format(formatter);
		score = 0;
		gameTime = 0;
		montserrat = app.createFont("Fonts/Montserrat-Regular.ttf", 18);
	}

	public void draw(int posy) {

		app.textFont(montserrat);
		app.textAlign(PConstants.CENTER);
		app.text(nickname, 214, posy);
		app.text(dateString, 695, posy);
		app.text(gameTime + " s", 925, posy);
		app.text(score, 452, posy);

	}

	@Override
	public int compareTo(Player o) {
		return nickname.compareTo(o.nickname);
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGameTime() {
		return gameTime;
	}

	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public PFont getMontserrat() {
		return montserrat;
	}

	public void setMontserrat(PFont montserrat) {
		this.montserrat = montserrat;
	}

}
