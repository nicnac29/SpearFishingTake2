package game;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Player extends JComponent {
	AudioClip sound = JApplet.newAudioClip(getClass().getResource("54__anton__bow-sound.wav"));
	ImageIcon playerImage;
	int x = 0, y = 0, width = 100, height = 50;
	public boolean up = false, down = false, left = false, right = false, space = false, W = false, A = false, S = false, D = false;
	int speed = 10;
	Game game;

	public void draw(Graphics g) {
		if (playerImage != null) {
			g.drawImage(playerImage.getImage(), x, y, width, height, null);
		}

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getTipX() {
		return x + width;
	}

	public int getTipY() {
		return y + height;
	}

	public void setUp(boolean b) {
		up = b;

	}

	public void setDown(boolean b) {
		down = b;
	}

	public void setLeft(boolean b) {
		left = b;
	}

	public void setRight(boolean b) {
		right = b;
	}

	public void setSpace(boolean b) {
		space = b;
	}

	public void setW(boolean b) {
		W = b;
	}

	public void setA(boolean b) {
		A = b;
	}

	public void setS(boolean b) {
		S = b;
	}

	public void setD(boolean b) {
		D = b;
	}

	public void tick() {
		if (space) {
			game.addSpear();
			sound.play();
		}

		if (up) {
			y = y - speed;
			down = false;
		}

		if (down) {
			y = y + speed;
			up = false;
		}
		if (left) {
			x = x - speed;
			right = false;
		}
		if (right) {
			x = x + speed;
			left = false;
		}
		if (W) {
			y = y - speed;
			S = false;
		}

		if (S) {
			y = y + speed;
			W = false;
		}
		if (A) {
			x = x - speed;
			D = false;
		}
		if (D) {
			x = x + speed;
			A = false;
		}
		if (y >= 400) {
			up = true;
			down = false;

		}
		if (y <= 0) {
			up = false;
			down = true;

		}
		if (x >= 900) {
			left = true;
			right = false;

		}
		if (x <= 0) {
			left = false;
			right = true;

		}
	}

	public Player(Game game) {
		playerImage = loadImageFromComputer("spearo.png");
		this.game = game;
	}

	public ImageIcon loadImageFromComputer(String fileName) {
		System.out.println("loading");
		URL imageURL = getClass().getResource(fileName);
		ImageIcon icon = new ImageIcon(imageURL);
		return icon;

	}
}
