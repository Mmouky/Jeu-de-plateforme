package fr.mmouky.jeu.boutons;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import fr.mmouky.jeu.affichage.Affichage;
import fr.mmouky.jeu.interfaces.IBoutonAction;
import fr.mmouky.jeu.interfaces.IDessiner;

public abstract class Bouton implements IDessiner, IBoutonAction {

	private int x, y, width, height;
	private String text;
	private boolean isFocus, isLocked;

	protected Affichage affichage;

	public static ArrayList<Bouton> boutons = new ArrayList<Bouton>();

	public Bouton(int x, int y, int width, int height, String text, Affichage affichage) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.isFocus = false;
		this.affichage = affichage;
		this.isLocked = false;
		boutons.add(this);
	}

	public Bouton(int x, int y, int width, int height, String text, boolean isLocked, Affichage affichage) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.isFocus = false;
		this.affichage = affichage;
		this.isLocked = isLocked;
		boutons.add(this);
	}

	@Override
	public void dessiner(Graphics2D g2d) {
		if (isLocked == false) {
			if (isFocus == false) {
				g2d.setColor(Color.BLACK);
				g2d.draw(getRect());
			} else {
				int thickness = 3;
				g2d.setColor(Color.BLUE);
				g2d.fill(new Rectangle(x - thickness, y - thickness, width + thickness * 2, height + thickness * 2));
				g2d.clearRect(x, y, width, height);
			}
		} else {
			g2d.setColor(Color.BLACK);
			g2d.draw(getRect());

			int widthCadenas = 19;
			int heightCadenas = 25;

			g2d.drawImage(new ImageIcon("cadenas.png").getImage(), x - widthCadenas - 5,
					y + height / 2 - heightCadenas / 2, widthCadenas, heightCadenas, null);
		}

		g2d.setFont(new Font(Affichage.POLICE, Font.BOLD, 20));
		String UPtext = text.toUpperCase();

		int widthTxt = (int) g2d.getFontMetrics().getStringBounds(UPtext, g2d).getWidth();
		int heightTxt = (int) g2d.getFontMetrics().getStringBounds(UPtext, g2d).getHeight();

		g2d.drawString(UPtext, x + width / 2 - widthTxt / 2, y + height / 2 + heightTxt / 3);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}

	public boolean isFocus() {
		return isFocus;
	}

	public void setFocus(boolean isFocus) {
		this.isFocus = isFocus;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

}
