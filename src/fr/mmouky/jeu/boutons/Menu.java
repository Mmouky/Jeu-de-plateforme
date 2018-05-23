package fr.mmouky.jeu.boutons;

import java.awt.Graphics2D;

import fr.mmouky.jeu.affichage.Affichage;
import fr.mmouky.jeu.enums.EMenu;

public class Menu extends Bouton {

	public Menu(int x, int y, int width, int height, Affichage affichage) {
		super(x, y, width, height, "menu", affichage);
	}

	public Menu(int x, int y, int width, int height, boolean isLocked, Affichage affichage) {
		super(x, y, width, height, "menu", isLocked, affichage);
	}

	@Override
	public void action() {
		if (affichage.getMenu() == EMenu.Options) {
			affichage.setMenu(EMenu.Menu);
		}
	}

	@Override
	public void action(Graphics2D g2d) {

	}

}
