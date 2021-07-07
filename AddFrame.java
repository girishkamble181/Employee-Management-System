import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFrame extends JFrame
{
	Container c;
	JLabel lbl_eid, lbl_ename;
	JTextField txt_eid, txt_ename;
	JButton btn_save, btn_back;

	AddFrame()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
		lbl_eid = new JLabel("enter emp id");
		txt_eid = new JTextField(20);
		lbl_ename = new JLabel("enter emp name");
		txt_ename = new JTextField(20);
		btn_save = new JButton("Save");
		btn_back = new JButton("Back");
		
		c.add(lbl_eid);		c.add(txt_eid);
		c.add(lbl_ename);	c.add(txt_ename);
		c.add(btn_save);
		c.add(btn_back);

		ActionListener a1 = (ae) -> { MainFrame a = new MainFrame(); dispose(); };
		btn_back.addActionListener(a1);

		ActionListener a2 = (ae) -> 
		{ 
			String eid = txt_eid.getText();
			String ename = txt_ename.getText();
			DbHandler.addEmployee(Integer.parseInt(eid), ename);
		};

		btn_save.addActionListener(a2);
		setTitle("Add Emp");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}