package fr.mmouky.jeu.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;

import fr.mmouky.jeu.affichage.Affichage;
import fr.mmouky.jeu.boutons.Bouton;

public class Mouse extends Observable implements MouseListener, MouseMotionListener {

	private Affichage affichage;

	public Mouse(Affichage affichage) {
		this.setAffichage(affichage);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for (Bouton bouton : Bouton.boutons) {
			if (bouton.getRect().contains(e.getPoint()) && !bouton.isLocked()) {
				bouton.action();
				this.setChanged();
				this.notifyObservers();
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for (Bouton bouton : Bouton.boutons) {
			if (!bouton.isLocked()) {
				if (bouton.getRect().contains(e.getPoint()) && !bouton.isFocus()) {
					bouton.setFocus(true);
					this.setChanged();
					this.notifyObservers();
				} else if (!bouton.getRect().contains(e.getPoint()) && bouton.isFocus()) {
					bouton.setFocus(false);
					this.setChanged();
					this.notifyObservers();
				}
			}
		}
	}

	public Affichage getAffichage() {
		return affichage;
	}

	public void setAffichage(Affichage affichage) {
		this.affichage = affichage;
	}

}
