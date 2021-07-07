import java.sql.*;
import javax.swing.*;

class DbHandler
{
	public static void addEmployee(int eid, String ename)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","abc123");
			String sql = "insert into employee values(?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, eid);
			pst.setString(2, ename);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), "record added");
			con.close();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(), "issue" +e);
		}
	}

	public static String getEmployee()
	{
		String data = "";
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","abc123");
			String sql = "select * from employee";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
				data = data + "eid = " + rs.getInt(1) + " ename = " + rs.getString(2) + " \n";
			con.close();	
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
		}
		return data;
	}
}