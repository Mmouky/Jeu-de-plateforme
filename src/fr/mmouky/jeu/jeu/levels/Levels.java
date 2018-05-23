package fr.mmouky.jeu.jeu.levels;

import java.awt.Graphics2D;
import java.util.ArrayList;

import fr.mmouky.jeu.interfaces.IDessiner;
import fr.mmouky.jeu.jeu.elements.Clef;
import fr.mmouky.jeu.jeu.elements.HitBox;
import fr.mmouky.jeu.jeu.elements.Mur;
import fr.mmouky.jeu.jeu.elements.Porte;

public abstract class Levels implements IDessiner{

	protected ArrayList<HitBox> objects = new ArrayList<HitBox>();

	public ArrayList<HitBox> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<HitBox> objects) {
		this.objects = objects;
	}
	
	public void dessiner(Graphics2D g2d) {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) instanceof Mur) {
				Mur mur = (Mur) objects.get(i);
				mur.dessiner(g2d);
			}else if(objects.get(i) instanceof Porte){
				Porte porte = (Porte) objects.get(i);
				porte.dessiner(g2d);
			}else if(objects.get(i) instanceof Clef){
				Clef clef = (Clef) objects.get(i);
				clef.dessiner(g2d);
			}
		}
	}
}
