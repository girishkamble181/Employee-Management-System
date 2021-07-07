import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame
{
	Container c;
	JButton btn_add, btn_view;

	MainFrame()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
		btn_add = new JButton("Add");
		btn_view = new JButton("View");

		c.add(btn_add);
		c.add(btn_view);

		ActionListener a1 = (ae) -> { AddFrame a = new AddFrame(); dispose(); };
		btn_add.addActionListener(a1);
		ActionListener a2 = (ae) -> { ViewFrame a = new ViewFrame(); dispose(); };
		btn_view.addActionListener(a2);
		setTitle("E.M.S.");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}