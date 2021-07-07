import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SplashFrame extends JFrame
{
	Container c;
	JLabel lbl_msg;
	
	SplashFrame()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());

		Font f = new Font("Arial",Font.BOLD, 80);
		lbl_msg = new JLabel("<html><center>Welcome<br>to<br>EMS</center></html>");
		lbl_msg.setForeground(Color.WHITE);
		lbl_msg.setFont(f);
		c.add(lbl_msg);

		new Thread()
		{
			public void run()
			{
				try
				{
					Thread.sleep(3000);
					dispose();
					MainFrame m = new MainFrame();
				}	
				catch(Exception e) {}
			}
		}.start();
		
		c.setBackground(Color.BLUE);
		setUndecorated(true);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}