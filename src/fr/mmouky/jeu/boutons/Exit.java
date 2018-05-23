package fr.mmouky.jeu.boutons;

import java.awt.Graphics2D;

import fr.mmouky.jeu.affichage.Affichage;
import fr.mmouky.jeu.enums.EMenu;

public class Exit extends Bouton {

	public Exit(int x, int y, int width, int height, Affichage affichage) {
		super(x, y, width, height, "exit", affichage);
	}

	public Exit(int x, int y, int width, int height, boolean isLocked, Affichage affichage) {
		super(x, y, width, height, "exit", isLocked, affichage);
	}

	@Override
	public void action() {
		if(affichage.getMenu() == EMenu.Menu){
			System.exit(0);
		}
	}

	@Override
	public void action(Graphics2D g2d) {

	}

}
