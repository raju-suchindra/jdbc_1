package first_jdbc_pgm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyCon {

	static Connection con;
	public static Connection connect()
	{
		try {
			// 1.Loading Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(credentilas.url, credentilas.username, credentilas.password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	static public void closeConnection(ResultSet resultSet , Statement stmt , Connection con)
	{
		try {
			if(resultSet!=null) {
				resultSet.close();
				System.out.println("result Set close");
			}
			if(stmt!=null) {
				stmt.close();
				System.out.println("stmt close");
			}
			if(con!=null) {
				con.close();
				System.out.println("con close");
			}


		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
