package fr.mmouky.jeu.boutons;

import java.awt.Graphics2D;

import fr.mmouky.jeu.affichage.Affichage;
import fr.mmouky.jeu.enums.EMenu;

public class Play extends Bouton {

	public Play(int x, int y, int width, int height, Affichage affichage) {
		super(x, y, width, height, "play", affichage);
	}

	public Play(int x, int y, int width, int height, boolean isLocked, Affichage affichage) {
		super(x, y, width, height, "play", isLocked, affichage);
	}

	
	public void action() {
		if (affichage.getMenu() == EMenu.Menu) {
			affichage.setMenu(EMenu.Game);
		}
	}

	
	public void action(Graphics2D g2d) {

	}

}
