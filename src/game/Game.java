package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Runnable 
{
	Player player;
	ArrayList<Fish> fish = new ArrayList<Fish>();
	Random r = new Random();
	public void init()
	{
		player = new Player();
		
		fish.add(new Fish("bazz.png", r));
		fish.add(new Fish("zebraperch.png", r));
		fish.add(new Fish("yt.png", r));
	}
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}
	//@Override
	public void run() 
	{
		long lastTime = System.currentTimeMillis();
		long diff = 40;
		while(true)
		{
			if(lastTime + diff < System.currentTimeMillis())
			{
				tick();
				lastTime = System.currentTimeMillis();
			}
		}
	}
	int count = 0;
	private void tick()
	{
		player.tick();
		count++;
		if(count > 25)
		{		
			if(fish.size() < 1)
			{
				fish.add(new Fish("yt.png", r));
			}
			else if(fish.size() < 4)
			{
			fish.add(new Fish("bazz.png", r));
			}
			else if(fish.size() < 10)
			{
				fish.add(new Fish("zebraperch.png", r));
			}

			count = 0;
		}
		for(int i =0; i < fish.size(); i++)
		{
			fish.get(i).tick();
		}
	}
	public void draw(Graphics g) {
		
		for(int i = 0; i < fish.size(); i++) 
		{
			fish.get(i).draw(g);
		}
		player.draw(g);
	}

}
