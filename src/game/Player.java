package game;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player 
{
	ImageIcon playerImage;
	int x = 0 , y = 0, width = 100, height= 50;
	private boolean up = false, down = false, left = false, right = false;
	int speed= 10;
public void draw(Graphics g)
{
	if(playerImage != null)
	g.drawImage(playerImage.getImage(), x, y, width, height,null);
}
public void setUp(boolean b)
{
	up = b;
}
public void setDown(boolean b)
{
	down = b;
}
public void setLeft(boolean b)
{
	left = b;
}
public void setRight(boolean b)
{
	right = b;
}
public void tick() 
{
if(up)
{
	y = y - speed;
}
if(down)
{
	y = y + speed;
}
if(left)
{
	x = x - speed;
}
if(right)
{
	x = x + speed;
}
}
public Player()
{
	playerImage = loadImageFromComputer("spearo.jpg");
}
public ImageIcon loadImageFromComputer(String fileName) 
{
	System.out.println("loading");
	URL imageURL = getClass().getResource(fileName);
	ImageIcon icon = new ImageIcon(imageURL);
	return icon;
	
}
}
