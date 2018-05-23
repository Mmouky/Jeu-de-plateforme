package fr.mmouky.jeu.jeu.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Mur extends HitBox {

	private Image image;

	public Mur(int x, int y, int width, int height, Image image) {
		super(x, y, width, height);
		this.image = image;
	}

	@Override
	public void dessiner(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		g2d.fill(super.getRect());
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
