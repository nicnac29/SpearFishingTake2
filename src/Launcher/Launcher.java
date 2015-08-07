package Launcher;

import game.Game;
import gui.FramePainter;
import gui.GameFrame;
import gui.GamePanel;

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
	FramePainter gp = new FramePainter();
	g = new Game(gp);

	 gf = new GameFrame(g);

	gp.setGameFrame(gf);
	 g.init();
	 g.run();
}
}
