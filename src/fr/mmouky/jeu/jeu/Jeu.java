package fr.mmouky.jeu.jeu;

import java.awt.Graphics2D;

import fr.mmouky.jeu.interfaces.IDessiner;
import fr.mmouky.jeu.jeu.elements.Personnage;
import fr.mmouky.jeu.jeu.levels.Level1;
import fr.mmouky.jeu.jeu.levels.Level2;
import fr.mmouky.jeu.jeu.levels.Levels;

public class Jeu implements IDessiner {

	private Personnage perso;
	private Levels level;

	public Jeu() {
		this.perso = new Personnage(0, 0, 50, 50, 3, 1, this);
		this.level = new Level1();
	}

	public void dessiner(Graphics2D g2d) {
		level.dessiner(g2d);
		perso.dessiner(g2d);
		perso.move();
		perso.checkHitBox();
		perso.fall();
	}

	public Personnage getPerso() {
		return perso;
	}

	public void setPerso(Personnage perso) {
		this.perso = perso;
	}

	public Levels getLevel() {
		return level;
	}

	public void setLevel(Levels level) {
		this.level = level;
	}

	public void nextLevel() {
		if (this.getLevel() instanceof Level1) {
			this.setLevel(new Level2());
		} else if (this.getLevel() instanceof Level2) {
			this.setLevel(new Level1());
		}
	}

}
