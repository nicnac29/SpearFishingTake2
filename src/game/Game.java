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
			int nextFish = r.nextInt(3);
			if(nextFish == 0)
			{
				fish.add(new Fish("yt.png", r));
			}
			else if(nextFish == 1)
			{
			fish.add(new Fish("bazz.png", r));
			}
			else
			{
				fish.add(new Fish("zebraperch.png", r));
			}

			count = 0;
		}
		for(int i =0; i < fish.size(); i++)
		{
			fish.get(i).tick();
			//System.out.println("tipx: " + player.getTipX() + " tipy: " + player.getTipY());
			Fish f = fish.get(i);
			if((player.getTipX() >=  f.getX()) && (player.getTipX() <=  f.getTipX() ) &&
					(player.getTipY() >=  f.getY()) && (player.getTipY() <=  f.getTipY() ))
			{
				System.out.println(fish.size());
				fish.remove(i);
			}
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
