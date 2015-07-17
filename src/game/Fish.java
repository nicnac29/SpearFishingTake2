package game;

import java.awt.Graphics;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Fish extends JComponent{
	ImageIcon fishImage;
	int x = 900 , y = 0, width = 100, height= 50;
	private boolean up = false, down = true, left = false, right = false;
	int speed= 10;
public void draw(Graphics g)
{
	if(fishImage != null)
	g.drawImage(fishImage.getImage(), x, y, width, height,null);
}
public ImageIcon loadImageFromComputer(String fileName) 
{
	System.out.println("loading");
	URL imageURL = getClass().getResource(fileName);
	ImageIcon icon = new ImageIcon(imageURL);
	return icon;
	
}
public Fish(String fishname, Random r)
{
	fishImage = loadImageFromComputer(fishname);
	this.y = r.nextInt(400);
	this.x = r.nextInt(900);
	if(r.nextBoolean())
	{
		up = true;
		down = false;
	}
	else
	{
		down = true;
		up = false;
	}
	if(r.nextBoolean())
	{
		left = true;
		right = false;
	}
	else
	{
		right = true;
		left = false;
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
if(y >= 400)
{
	up = true;
	down = false;
}
if(y <= 0)
{
	up = false;
	down = true;
}
if(x >= 900)
{
	left = true;
	right = false;
}
if(x<= 0)
{
	left = false;
	right = true;
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
}
