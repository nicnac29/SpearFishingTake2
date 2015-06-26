package game;

import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;

public class Fish {
	ImageIcon fishImage;
	int x = 0 , y = 0, width = 100, height= 50;
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
public Fish()
{
	fishImage = loadImageFromComputer("bass.png");
	
}
}
