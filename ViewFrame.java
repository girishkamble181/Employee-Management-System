import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame
{
	Container c;
	TextArea ta_data;
	JButton btn_back;

	ViewFrame()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
			
		ta_data = new TextArea(10,50);
		btn_back = new JButton("Back");
		
		c.add(ta_data);
		c.add(btn_back);
	
		String data = DbHandler.getEmployee();
		if(data.length() == 0)
			ta_data.setText("no record");
		else
			ta_data.setText(data);

		ActionListener a1 = (ae) -> { MainFrame a = new MainFrame(); dispose(); };
		btn_back.addActionListener(a1);
	
		setTitle("Add Emp");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}