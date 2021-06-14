package model;

public class CavePlayer {
	private int posX;
	private int posY;
	private int vidas;
	public CavePlayer(int posX, int posY, int vidas) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.vidas = vidas;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	
	

	

}
