package game;

import gui.FramePainter;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class Game implements Runnable, ActionListener {
	int score = 0;
	ImageIcon background;
	String lajolla = "lajolla.jpg";
	AudioClip sound1 = JApplet.newAudioClip(getClass().getResource("137074__lance-blomgren__musical-bubbles.wav"));
	AudioClip sound2 = JApplet.newAudioClip(getClass().getResource("245807__markb258__dead-bird.wav"));
	Player player;
	ArrayList<Spear> spears = new ArrayList<Spear>();
	ArrayList<Fish> fish = new ArrayList<Fish>();
	Random r = new Random();
	private FramePainter fp;
	Timer t = new Timer(1000, this);
	int timeCount = 0;

	public ImageIcon loadImageFromComputer(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		ImageIcon icon = new ImageIcon(imageURL);
		return icon;

	}

	public Game(FramePainter gp) {
		this.fp = gp;
		background = loadImageFromComputer(lajolla);
	}

	public void init() {
		player = new Player(this);
		fish.add(new Fish("bazz.png", r));
		fish.add(new Fish("zebraperch.png", r));
		fish.add(new Fish("yt.png", r));
	}

	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}

	public void addSpear() {
		System.out.println("spears: " + spears.size());
		//TODO: don't add a new spear unless the last one has left the screen
		spears.add(new Spear(player));
	}

	// @Override
	public void run() {
		String deeznuts = JOptionPane
				.showInputDialog("READ THE DIRECTIONS CAREFULLY!!! use the arrow keys to move, shoot spears useing the space bar, you have 60 seconds, the more spears you shoot the more fish apear. good luck");
		if (!deeznuts.equals("oyoyyyoyyoyyyyyyyoyoyoyoyoyoyoyyyyyoyoy")) {
			t.start();
			sound1.play();
			long lastTime = System.currentTimeMillis();
			long diff = 40;
			while (timeCount < 60) {
				if (lastTime + diff < System.currentTimeMillis()) {
					tick();
					lastTime = System.currentTimeMillis();

				}

			}
			JOptionPane.showMessageDialog(null, "your score is " + score + "    The High score is 170");
			String replay = JOptionPane.showInputDialog("would you like to play again... yes or no");
			if (replay.equals("yes")) {
				timeCount = 0;
				score = 0;
				count = 0;
				fish.clear();
				fish.add(new Fish("bazz.png", r));
				fish.add(new Fish("zebraperch.png", r));
				fish.add(new Fish("yt.png", r));
				run();
			} else {
				fp.closeFrame();
			}
		}
	}

	int count = 0;

	private void tick() { 
		player.tick();
		for (int i = 0; i < spears.size(); i++) {
			Spear spear = spears.get(i);
			spear.tick();
			removeSpearIfOffScreen(spear);
			// System.out.println("tipx: " + player.getTipX() + " tipy: " +
			// player.getTipY());
			for (int j = 0; j < fish.size(); j++) {
				Fish f = fish.get(j);
				if ((spear.getTipX() >= f.getX()) && (spear.getTipX() <= f.getTipX()) && (spear.getTipY() >= f.getY())
						&& (spear.getTipY() <= f.getTipY())) {
					// System.out.println(fish.size());
					fish.remove(j);
					sound2.play();
					try {
						spears.remove(i);
					} catch (Exception e) {
						// System.out.println("error!!!");
					}
					score += 1;
					count++;
					if (count > 600) {
						int nextFish = r.nextInt(3);
						if (nextFish == 0) {
							fish.add(new Fish("yt.png", r));
						} else if (nextFish == 1) {
							fish.add(new Fish("bazz.png", r));
						} else {
							fish.add(new Fish("zebraperch.png", r));
						}

						count = 0;
					}
				}

			}
			count++;
			if (count > 800) {
				int nextFish = r.nextInt(3);
				if (nextFish == 0) {
					fish.add(new Fish("yt.png", r));
				} else if (nextFish == 1) {
					fish.add(new Fish("bazz.png", r));
				} else {
					fish.add(new Fish("zebraperch.png", r));
				}

				count = 0;
			}

		}
		for (int j = 0; j < fish.size(); j++) {
			fish.get(j).tick();
		}
		fp.repaint();
	}

	private void removeSpearIfOffScreen(Spear spear) {
		if (spear.getTipX() > background.getIconWidth()) { // TODO: this needs to be fixed
			spears.remove(spear);
			System.out.println("removed spear.");
		}
		/*
		 * TODO: Add logic for checking if the spear goes off the edge of the screen if so, remove the spear.
		 */

	}

	public void draw(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 1000, 500, null);
		player.draw(g);
		g.setColor(Color.WHITE);
		g.drawString("score: " + score, 10, 10);
		g.drawString("time left: " + (60 - timeCount), 10, 22);
		g.drawString("highscore: 170", 10, 34);
		for (int i = 0; i < spears.size(); i++) {
			spears.get(i).draw(g);
		}

	}

	public void drawFish(Graphics g) {

		for (int i = 0; i < fish.size(); i++) {
			fish.get(i).draw(g);
		}
	}

	public void actionPerformed(ActionEvent e) {
		timeCount++;
	}

}
