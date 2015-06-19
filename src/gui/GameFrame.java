package gui;

import game.Game;

import javax.swing.JFrame;

import playerInteraction.GameKeyListener;

public class GameFrame extends JFrame implements Runnable 
{
	GamePanel gameP;
public GameFrame(Game g)
{
	super();
	this.setBounds(0,0,500,500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	
	gameP = new GamePanel(g);
	this.add(gameP);
	this.addKeyListener(new GameKeyListener(g));

}
@Override
public void run() 
{
while(true)
{
	this.repaint();
	gameP.repaint();
}
}
}
