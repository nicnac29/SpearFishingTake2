package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Runnable {
	int score = 0;
	Player player;
	ArrayList<Spear> spears = new ArrayList<Spear>();
	ArrayList<Fish> fish = new ArrayList<Fish>();
	Random r = new Random();

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
		spears.add(new Spear(player));
	}

	// @Override
	public void run() {
		long lastTime = System.currentTimeMillis();
		long diff = 40;
		while (true) {
			if (lastTime + diff < System.currentTimeMillis()) {
				tick();
				lastTime = System.currentTimeMillis();
			}
		}
	}

	int count = 0;

	private void tick() {
		System.out.println(count);
		player.tick();
		for (int i = 0; i < spears.size(); i++) {
			Spear spear = spears.get(i);
			spear.tick();
			// System.out.println("tipx: " + player.getTipX() + " tipy: " +
			// player.getTipY());
			for (int j = 0; j < fish.size(); j++) {
				Fish f = fish.get(j);
				if ((spear.getTipX() >= f.getX())
						&& (spear.getTipX() <= f.getTipX())
						&& (spear.getTipY() >= f.getY())
						&& (spear.getTipY() <= f.getTipY())) {
					// System.out.println(fish.size());
					fish.remove(j);
					spears.remove(i);
					score += 1;
				}

			}
			count++;
			if (count > 500) {
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

	}

	public void draw(Graphics g) {

		player.draw(g);
		for (int i = 0; i < spears.size(); i++) {

			spears.get(i).draw(g);
		}
	}

	public void drawFish(Graphics g) {
		
		for (int i = 0; i < fish.size(); i++) {
			fish.get(i).draw(g);
		}
	}

}
