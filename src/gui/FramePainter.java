package gui;

public class FramePainter {
GameFrame frame;
public void setGameFrame(GameFrame frame)
{
	this.frame = frame;
}
public void repaint()
{
	frame.repaint();
}
}
