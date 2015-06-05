import java.awt.*;
import java.awt.event.*;


public class TankClient extends Frame
{
	private Image offScreamImag = null;//用于解决双缓冲问题
	
	public static final int GAME_WIDE=800;
	public static final int GAME_LENGH=500;

	Tank t = new Tank(30,30);
//	Tank t2 = new Tank(60,60);
//	Tank t1 = new Tank(90,90);
	
	public void launchFrame()
	{
		this.setLocation(100,200);
		this.setSize(GAME_WIDE, GAME_LENGH);
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
			
		}
		);
		this.addKeyListener(new KeyMonitor());
		this.setVisible(true);
		
		new Thread(new PaintThread()).start();
	}
	
	public void paint(Graphics g)
	{
		
		t.draw(g);
//		t1.draw(g);
//		t2.draw(g);
//		Color c = null;
//		c=g.getColor();
//		g.setColor(Color.red);
//		g.fillOval(x, y, 30,30 );
//		g.setColor(c);
		
	}
	
	public static void main(String[] args)
	{
		TankClient tc = new TankClient();
		tc.launchFrame();
	}
	
	private class PaintThread implements Runnable
	{
		public void run()
		{
				while(true)
				{
					repaint();
					try 
					{
						Thread.sleep(50);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
		}

	}
	public void update(Graphics g) 
	{
		if(offScreamImag==null)
		{
			offScreamImag=this.createImage(GAME_WIDE, GAME_LENGH);
		}
		Graphics goffScreamImag=offScreamImag.getGraphics();
		goffScreamImag.setColor(Color.GREEN);
		goffScreamImag.fillRect(0, 0, GAME_WIDE, GAME_LENGH);
		paint(goffScreamImag);
		g.drawImage(offScreamImag, 0, 0, null);
	}
	
	private class KeyMonitor extends  KeyAdapter
	{
		public void keyPressed(KeyEvent e) 
		{
			t.move(e);
//			int keyValue=e.getKeyCode();
//		
//			switch(keyValue)
//			{
//				case KeyEvent.VK_RIGHT:
//					x+=5;break;
//				case KeyEvent.VK_LEFT:
//					x-=5;break;
//				case KeyEvent.VK_UP:
//					y-=5;break;
//				case KeyEvent.VK_DOWN:
//					y+=5;break;
//			}
		}
		
	}
}
