package fr.mmouky.jeu.jeu.elements;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Clef extends HitBox{

	private Porte porte;

	public Clef(int x, int y, Porte porte) {
		super(x, y, 25, 25);
		this.porte = porte;
		porte.setClef(this);
	}

	@Override
	public void dessiner(Graphics2D g2d) {
		g2d.drawImage(new ImageIcon("Key.png").getImage(), this.getX(), this.getY(), 25, 25, null);
	}

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}

}
