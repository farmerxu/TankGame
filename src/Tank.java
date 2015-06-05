import java.awt.*;
import java.awt.event.KeyEvent;


public class Tank 
{
	private int x;
	private int y;
	public static final int XSPEED=5;
	public static final int YSPEED=5;
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	
	private TankDirection dir = TankDirection.STOP;
	
	
	enum TankDirection{U,D,L,R,LU,RU,LD,RD,STOP};
	
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g)
	{
		Color c = null;
		c=g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, 30,30 );
		g.setColor(c);
		move();//注意move（）的地方
	}
	
	public void move ()
	{
		//int keyValue=e.getKeyCode();
		//MoveDir(e);
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
		case STOP:
			break;
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keyValue=e.getKeyCode();
		switch(keyValue)
		{
			case KeyEvent.VK_RIGHT:
				right=true;break;
			case KeyEvent.VK_LEFT:
				left=true;break;
			case KeyEvent.VK_UP:
				up=true;break;
			case KeyEvent.VK_DOWN:
				down=true;break;
		}
		MoveDir();
	}
	
	public void keyReased(KeyEvent e)
	{
		int keyValue=e.getKeyCode();
		switch(keyValue)
		{
			case KeyEvent.VK_RIGHT:
				right=false;break;
			case KeyEvent.VK_LEFT:
				left=false;break;
			case KeyEvent.VK_UP:
				up=false;break;
			case KeyEvent.VK_DOWN:
				down=false;break;
		}
		MoveDir();
	}
	
	public void MoveDir()
	{
		if((left)&(!right)&(!up)&(!down))
		{
			dir=TankDirection.L;
		}
		
		if((!left)&right&(!up)&(!down))
		{
			dir=TankDirection.R;
		}
		
		if((!left)&(!right)&up&(!down))
		{
			dir=TankDirection.U;
		}
		
		if((!left)&(!right)&(!up)&(down))
		{
			dir=TankDirection.D;
		}
		
		if((left)&(!right)&(!up)&(down))
		{
			dir=TankDirection.LD;
		}
		
		if((left)&(!right)&(up)&(!down))
		{
			dir=TankDirection.LU;
		}
		
		if((!left)&(right)&(!up)&(down))
		{
			dir=TankDirection.RD;
		}
		
		if((!left)&(right)&(up)&(!down))
		{
			dir=TankDirection.RU;
		}
		if((!left)&(!right)&(!up)&(!down))
		{
			dir=TankDirection.STOP;
		}
	}

}

