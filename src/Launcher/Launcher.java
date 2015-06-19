package Launcher;

import game.Game;
import gui.GameFrame;

public class Launcher 
{
	GameFrame gf;
	Game g;
public static void main(String[] args)
{
	Launcher l = new Launcher();
	l.init();
}
private void init() 
{
	 g = new Game();
	 g.init();
	 gf = new GameFrame(g);
	 Thread t1 = new Thread(g);
	 t1.start();
	 Thread t2 = new Thread(gf);
	 t2.start();
}
}
