package com.Salary.utility;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconnection {
	
	public static Connection getconnection() throws ClassNotFoundException, SQLException {
		
//		PreparedStatement ps=null;

		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url ="jdbc:mysql://localhost:3306/test";
		String user ="root";
		String pass="rubic123";
		
		Connection con=DriverManager.getConnection(url, user, pass);


//		ps=con.prepareStatement(sql);
//		
//		ResultSet set=ps.executeQuery();
		
		return con;
	}
	
	//check connection
	
//	public static void main(String args[]) throws ClassNotFoundException, SQLException {
//		
//		ResultSet ps = getPrearedStatement("select * from new_table");
//		
//		
//		
//		
//		while(ps.next()) {
//			
//			System.out.println(ps.getString("testID"));
//			
//			
//		}
//		
//	}
//	
//	

}
