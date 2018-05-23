package fr.mmouky.jeu.jeu.levels;

import fr.mmouky.jeu.jeu.elements.Clef;
import fr.mmouky.jeu.jeu.elements.Mur;
import fr.mmouky.jeu.jeu.elements.Porte;

public class Level1 extends Levels {

	public Level1() {
		objects.add(new Mur(0, 600, 1080, 50, null));
		objects.add(new Mur(200, 450, 70, 50, null));
		objects.add(new Mur(400, 550, 70, 50, null));
		objects.add(new Mur(500, 350, 70, 50, null));
		Porte porte = new Porte(900, 450, false);
		objects.add(porte);
		objects.add(new Clef(450, 450, porte));
	}

}
