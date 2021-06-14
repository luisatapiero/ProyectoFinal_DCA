package model;

public class PowerUp {
	private int posx;
	private int posy;
	public final static int SPEED = 1;
	public final static int RESIS = 2;
	private int tipo;
	public PowerUp(int posx, int posy, int tipo) {
		super();
		this.posx = posx;
		this.posy = posy;
		this.tipo = tipo;
	}
	
	
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	

	
}
