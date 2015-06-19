package gui;

import java.awt.Graphics;

import game.Game;

import javax.swing.JPanel;

import playerInteraction.GameKeyListener;

public class GamePanel extends JPanel
{
	Game game;
	public GamePanel(Game g) 
	{
		this.game = g;
		this.setBounds(0, 0, 1200, 500);
	}	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		game.getPlayer().draw(g);
	}
}
