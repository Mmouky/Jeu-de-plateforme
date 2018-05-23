package fr.mmouky.jeu.jeu.elements;

import java.awt.Color;
import java.awt.Graphics2D;

public class Porte extends HitBox {

	private Clef clef;
	private boolean isOpen;

	public Porte(int x, int y, boolean isOpen) {
		super(x, y, 50, 150);
		this.isOpen = isOpen;
	}

	@Override
	public void dessiner(Graphics2D g2d) {
		if (isOpen == true) {
			g2d.setColor(Color.GREEN);
		} else {
			g2d.setColor(Color.RED);
		}
		g2d.fill(super.getRect());
	}

	public Clef getClef() {
		return clef;
	}

	public void setClef(Clef clef) {
		this.clef = clef;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public void changeState() {
		if (isOpen == true) {
			isOpen = false;
		} else {
			isOpen = true;
		}
	}

}
