import java.awt.*;
import java.awt.event.KeyEvent;
//hahha

public class Tank 
{
	private int x;
	private int y;
	public static final int WIDTH=30;
	public static final int HEIGH=30;
	public static final int XSPEED=5;
	public static final int YSPEED=5;
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	TankClient tc;
	
	private TankDirection dir = TankDirection.STOP;
	private TankDirection ptdir=TankDirection.D;
	
	
	enum TankDirection{U,D,L,R,LU,RU,LD,RD,STOP};
	
	public Tank(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//持有对方引用
	public Tank(int x, int y,TankClient tc) 
	{
		this(x,y);
		this.tc=tc;
	}
	
	public void draw(Graphics g)
	{
		Color c = null;
		c=g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, WIDTH,HEIGH );
		g.setColor(c);
		
		switch(ptdir)
		{
		case L:
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGH/2, x, y + Tank.HEIGH/2);
			break;
		case LU:
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGH/2, x, y);
			break;
		case U:
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGH/2, x + Tank.WIDTH/2, y);
			break;
		case RU:
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGH/2, x + Tank.WIDTH, y);
			break;
		case R:
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGH/2, x + Tank.WIDTH, y + Tank.HEIGH/2);
			break;
		case RD:
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGH/2, x + Tank.WIDTH, y + Tank.HEIGH);
			break;
		case D:
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGH/2, x + Tank.WIDTH/2, y + Tank.HEIGH);
			break;
		case LD:
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGH/2, x, y + Tank.HEIGH);
			break;
		}
		
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
		if(this.dir!=TankDirection.STOP)
		{
			this.ptdir=this.dir;
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keyValue=e.getKeyCode();
		switch(keyValue)
		{
			case KeyEvent.VK_CONTROL:
				tc.m.add(this.fire());break;
			case KeyEvent.VK_RIGHT:
				right=true;break;
			case KeyEvent.VK_LEFT:
				left=true;break;
			case KeyEvent.VK_UP:
				up=true;break;
			case KeyEvent.VK_DOWN:
				down=true;break;
		}
		MoveDir();if(this.ptdir!=TankDirection.STOP)
		{
			this.ptdir=this.dir;
		}
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
	
	public Misssle fire()
	{
		int x = this.x + Tank.WIDTH/2 - Misssle.WIDTH/2;
		int y = this.y + Tank.HEIGH/2 - Misssle.HEIGH/2;
		Misssle m = new Misssle(x, y, this.ptdir);
		return m;
		
	}
}

