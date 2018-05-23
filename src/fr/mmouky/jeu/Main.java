package fr.mmouky.jeu;

import fr.mmouky.jeu.affichage.Fenetre;

public class Main {

	public static void main(String[] args) {

		int width = 1080;
		int height = 720;

		Fenetre frame = new Fenetre("Jeu", width, height);
		frame.setVisible(true);
	}

}
