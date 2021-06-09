package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Caveman {


	private int x;
	private int y;
	private int xt;
	private boolean crashed;
	protected Image imagen;
	
	public Caveman (String recurso, int x, int y, int xt) {
		this.x=x;
		this.y=y;
		this.xt=xt;
		imagen = new ImageIcon(this.getClass().getResource(recurso)).getImage();
	}
	
	
}
