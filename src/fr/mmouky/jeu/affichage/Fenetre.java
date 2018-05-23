package fr.mmouky.jeu.affichage;

import javax.swing.JFrame;

import fr.mmouky.jeu.controleur.Key;
import fr.mmouky.jeu.controleur.Mouse;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1127944676415899864L;

	public Fenetre(String title, int width, int height) {
		
		Affichage aff = new Affichage(width, height);
		Key key = new Key();
		Mouse mouse = new Mouse(aff);
		
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setContentPane(aff);
		this.addKeyListener(key);
		aff.addMouseListener(mouse);
		aff.addMouseMotionListener(mouse);
		
		key.addObserver(aff);
		mouse.addObserver(aff);
	}

}
