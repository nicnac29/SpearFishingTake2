package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Player extends JComponent
{
	ImageIcon playerImage;
	int x = 0 , y = 0, width = 100, height= 50;
	public boolean up = false, down = false, left = false, right = false;
	int speed= 10;
	Game game;
public void draw(Graphics g)
{
	if(playerImage != null)
	{
	g.drawImage(playerImage.getImage(), x, y, width, height,null);
	}
	
}

public int getX()
{
	return x;
}
public int getY()
{
	return y;
}
public int getTipX()
{
	return x + width;
}
public int getTipY()
{
	return y + height;
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
	game.addSpear();
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
public Player(Game game)
{
	playerImage = loadImageFromComputer("spearo.jpg");
	this.game = game;
}
public ImageIcon loadImageFromComputer(String fileName) 
{
	System.out.println("loading");
	URL imageURL = getClass().getResource(fileName);
	ImageIcon icon = new ImageIcon(imageURL);
	return icon;
	
}
}
