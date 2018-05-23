package fr.mmouky.jeu.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

public class Key extends Observable implements KeyListener {

	public static boolean move_left;
	public static boolean move_right;
	public static boolean jump;
	
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			move_left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			move_right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			jump = true;
		}
		this.setChanged();
		this.notifyObservers();
	}

	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			move_left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			move_right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			jump = false;
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
