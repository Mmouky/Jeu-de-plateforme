package fr.mmouky.jeu.jeu.elements;

import java.awt.Rectangle;

import fr.mmouky.jeu.interfaces.IDessiner;

public abstract class HitBox implements IDessiner{

	private int x, y, width, height;
	
	public static final int hitbox_size = 2;
	
	public HitBox(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Rectangle getTop() {
		return new Rectangle(x + hitbox_size, y, width - 2 * hitbox_size, hitbox_size);
	}

	public Rectangle getBot() {
		return new Rectangle(x + hitbox_size, y + height - hitbox_size, width - 2 * hitbox_size, hitbox_size);
	}

	public Rectangle getLeft() {
		return new Rectangle(x, y + hitbox_size, hitbox_size, height - 2 * hitbox_size);
	}

	public Rectangle getRight() {
		return new Rectangle(x + width - hitbox_size, y + hitbox_size, hitbox_size, height - 2 * hitbox_size);
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}
	
}
