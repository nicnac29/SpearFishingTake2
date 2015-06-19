package game;

public class Game implements Runnable 
{
	Player player;
	public void init()
	{
		player = new Player();
	}
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}
	@Override
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
	private void tick()
	{
		player.tick();
	}

}
