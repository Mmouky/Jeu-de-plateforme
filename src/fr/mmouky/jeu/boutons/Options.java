package fr.mmouky.jeu.boutons;

import java.awt.Graphics2D;

import fr.mmouky.jeu.affichage.Affichage;
import fr.mmouky.jeu.enums.EMenu;

public class Options extends Bouton {

	public Options(int x, int y, int width, int height, Affichage affichage) {
		super(x, y, width, height, "options", affichage);
	}

	public Options(int x, int y, int width, int height, boolean isLocked, Affichage affichage) {
		super(x, y, width, height, "options", isLocked, affichage);
	}

	@Override
	public void action() {
		if (affichage.getMenu() == EMenu.Menu) {
			affichage.setMenu(EMenu.Options);
		}
	}

	@Override
	public void action(Graphics2D g2d) {
		// TODO Auto-generated method stub

	}

}
