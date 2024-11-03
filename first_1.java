package first_jdbc_pgm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class first_1 {
	static Connection con;
	static Statement stmt;
	static ResultSet resultSet;
	public static void main(String[] args) {
//		String url = "jdbc:mysql://localhost:3306/jdbcclas";
//		String username = "root";
//		String password = "root";

		try
		{
//			// 1.Loading Driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			// 2.Establishing Connection
//			con = DriverManager.getConnection(url, username, password);
			
			con = MyCon.connect();
			// 3.Creating SQL Statement
			stmt = con.createStatement();

			// 4.Executing SQl Statement
			resultSet = stmt.executeQuery("select * from students");

			// 5.Displaying the Result Set
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + ", " + 
						resultSet.getString(2) + ", " +
						resultSet.getInt(3) + ", " + 
						resultSet.getString(4) + ", " +
						resultSet.getString(5));
			}
		}
		catch (SQLException e) {
			System.out.println("class not found");
			e.printStackTrace();
		}
		finally{
			MyCon.closeConnection(resultSet , stmt ,con);
		}
	}	
}

