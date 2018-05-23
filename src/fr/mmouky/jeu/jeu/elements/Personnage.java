package fr.mmouky.jeu.jeu.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Observable;

import fr.mmouky.jeu.controleur.Key;
import fr.mmouky.jeu.interfaces.IDessiner;
import fr.mmouky.jeu.jeu.Jeu;
import fr.mmouky.jeu.jeu.levels.Levels;

public class Personnage extends Observable implements IDessiner {

	private int x, width, height, life;

	private float speed, y;
	private Jeu jeu;
	public static final float JUMP_POWER = 1.5f;
	public static final float DEF_GRAVITY = 0.01f;
	private boolean isJumping = false;
	private static float gravity = 0;

	public Personnage(int x, float y, int width, int height, int life, float speed, Jeu jeu) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setLife(life);
		this.speed = speed;
		this.jeu = jeu;
	}

	public void dessiner(Graphics2D g2d) {
		g2d.setColor(Color.black);
		g2d.fill(getHitBox());
	}

	public void move() {
		if (Key.move_left == true) {
			this.x -= speed;

			this.setChanged();
			this.notifyObservers();
		}

		if (Key.move_right == true) {
			this.x += speed;

			this.setChanged();
			this.notifyObservers();
		}

		if (Key.jump == true && isJumping == false) {
			gravity = -JUMP_POWER;
			isJumping = true;
		}

	}

	public void checkHitBox() {
		Levels level = jeu.getLevel();
		for (HitBox hb : level.getObjects()) {
			if (hb.getRect().intersects(this.getHitBox())) {
				if (hb instanceof Mur) {
					Mur mur = (Mur) hb;
					if (mur.getBot().intersects(this.getHitBox())) {
						this.setY(mur.getY() + mur.getHeight());
						gravity = 0;
					}

					if (mur.getLeft().intersects(this.getHitBox())) {
						this.setX(mur.getX() - this.getWidth());
					}

					if (mur.getRight().intersects(this.getHitBox())) {
						this.setX(mur.getX() + mur.getWidth());
					}

				} else if (hb instanceof Porte) {
					Porte porte = (Porte) hb;
					if (porte.isOpen()) {
						jeu.nextLevel();
					}
				} else if (hb instanceof Clef) {
					Clef clef = (Clef) hb;
					level.getObjects().remove(hb);
					clef.getPorte().changeState();
					break;
				}
			}
		}
	}

	public void fall() {
		checkGround();

		this.setChanged();
		this.notifyObservers();
	}

	private void checkGround() {
		Rectangle nextPos = new Rectangle(this.x, (int) (this.y + gravity), this.width, this.height);
		Levels level = jeu.getLevel();
		for (HitBox hb : level.getObjects()) {
			if (hb instanceof Mur) {
				Mur mur = (Mur) hb;
				if (mur.getTop().intersects(nextPos)) {
					this.setY(mur.getY() - this.getHeight());
					this.isJumping = false;
					gravity = 0;
				}
			}
		}
		this.y += gravity;
		gravity += DEF_GRAVITY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
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

	public Rectangle getHitBox() {
		return new Rectangle(x, (int) y, width, height);
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

}
