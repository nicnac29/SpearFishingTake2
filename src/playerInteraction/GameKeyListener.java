package playerInteraction;

import game.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

	Game game;
	public GameKeyListener(Game game) 
	{
		this.game = game;
	}

	//@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	//@Override
	public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			game.getPlayer().setUp(true);
			break;
		case KeyEvent.VK_DOWN:
			game.getPlayer().setDown(true);
			break;
		case KeyEvent.VK_LEFT:
			game.getPlayer().setLeft(true);
			break;
		case KeyEvent.VK_RIGHT:
			game.getPlayer().setRight(true);
			break;
		case KeyEvent.VK_SPACE:
			game.getPlayer().setSpace(true);
			break;
		}
	}

	//@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			game.getPlayer().setUp(false);
			break;
		case KeyEvent.VK_DOWN:
			game.getPlayer().setDown(false);
			break;
		case KeyEvent.VK_LEFT:
			game.getPlayer().setLeft(false);
			break;
		case KeyEvent.VK_RIGHT:
			game.getPlayer().setRight(false);
			break;
		case KeyEvent.VK_SPACE:
			game.getPlayer().setSpace(false);
			break;
		}
	}

}
