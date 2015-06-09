import java.awt.Color;
import java.awt.Graphics;


public class Misssle
{
	public static final int XSPEED=10;
	public static final int YSPEED=10;
	public static final int WIDTH=10;
	public static final int HEIGH=10;
	
	 int x;
	 int y;
	 Tank.TankDirection dir ;// the direction of missle(pay attention)
	
	 public Misssle(int x, int y, Tank.TankDirection dir) 
	 {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	 
	public void draw(Graphics g)
	{
		Color c = null;
		c=g.getColor();
		g.setColor(Color.black);
		g.fillOval(x, y, HEIGH,WIDTH);
		g.setColor(c);
		move();
	}

	private void move() 
	{
		switch(dir)
		{
		case L:
			x -= XSPEED;
			break;
		case LU:
			x -= XSPEED;
			y -= YSPEED;
			break;
		case U:
			y -= YSPEED;
			break;
		case RU:
			x += XSPEED;
			y -= YSPEED;
			break;
		case R:
			x += XSPEED;
			break;
		case RD:
			x += XSPEED;
			y += YSPEED;
			break;
		case D:
			y += YSPEED;
			break;
		case LD:
			x -= XSPEED;
			y += YSPEED;
			break;
		}
	}
}
