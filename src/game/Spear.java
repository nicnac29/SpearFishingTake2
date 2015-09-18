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

public class Spear {


	
		ImageIcon spear;
		
		int x = 0 , y = 0, width = 100, height= 50;
		private boolean up = false, down = false, left = false, right = false;
		int speed = 15 ;
	public void draw(Graphics g)
	{
		if(spear != null)
		{
		g.drawImage(spear.getImage(), x, y, width, height,null);
		}
		
	}
	public Spear(Player player)
	{
		this.left = player.left;
		this.right = player.right;
		this.down = player.down;
		this.up = player.up;
		this.x = player.x;
		this.y = player.y;
		spear = loadImageFromComputer("spear.png");
		if((!left && !right && !down && !up) )
		{
			right = true;
			
		}
		if(left&& right)
		{
			left =false;
			right = true;
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
	if(left)
	{
		x = x - speed;
	}
	if(right)
	{
		x = x + speed;
	}
	}
	
	public ImageIcon loadImageFromComputer(String fileName) 
	{
		//System.out.println("loading");
		URL imageURL = getClass().getResource(fileName);
		ImageIcon icon = new ImageIcon(imageURL);
		return icon;
		
	}
	}


