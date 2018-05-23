package fr.mmouky.jeu.affichage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.mmouky.jeu.boutons.Exit;
import fr.mmouky.jeu.boutons.Menu;
import fr.mmouky.jeu.boutons.Options;
import fr.mmouky.jeu.boutons.Play;
import fr.mmouky.jeu.enums.EMenu;
import fr.mmouky.jeu.jeu.Jeu;

public class Affichage extends JPanel implements Observer {

	private static final long serialVersionUID = -3723153927818830031L;
	private Jeu jeu;
	private EMenu menu;

	public JPanel panelContenu;

	private Play play;
	private Exit exit;
	private Options option;
	private Menu menuB;

	public static final String POLICE = "Century Gothic";

	public Affichage(int width, int height) {
		this.jeu = new Jeu();
		jeu.getPerso().addObserver(this);
		menu = EMenu.Menu;
		play = new Play(width / 2 - 100, 300, 200, 50, this);
		option = new Options(width / 2 - 100, 400, 200, 50, this);
		exit = new Exit(width / 2 - 100, 500, 200, 50, this);
		menuB = new Menu(width - 210, 10, 200, 50, this);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		clear(g2d);
		if (menu == EMenu.Menu) {
			g2d.drawImage(new ImageIcon("bg.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			play.dessiner(g2d);
			exit.dessiner(g2d);
			option.dessiner(g2d);
		} else if (menu == EMenu.Options) {
			menuB.dessiner(g2d);
		} else if (menu == EMenu.Game) {
			jeu.dessiner(g2d);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	public void clear(Graphics2D g2d) {
		g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public EMenu getMenu() {
		return menu;
	}

	public void setMenu(EMenu menu) {
		this.menu = menu;
	}

}
