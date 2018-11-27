package storagePackage;

import java.sql.*;

public class Driver {
	
	// Driver to initialize and access database
	
	static Connection conn;
	public PreparedStatement pStatement;
	final String databaseName = "database";
	
	String connectInfo = "jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false";
	String user = "root";
	String pword = "ShayanZack97";
	
	String userTable = "user";
	
	public Driver() {
		try {
			conn = DriverManager.getConnection(connectInfo, user, pword);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public char validateLogin(String u, String p) {
		String sql = "SELECT * FROM " + userTable + " WHERE USERNAME='" + u + "'";
		ResultSet user;
		try {
			pStatement = conn.prepareStatement(sql);
			user = pStatement.executeQuery(sql);
			if(user.next())							// User found
			{
				if(!p.equals(user.getString("PASSWORD"))) {
					return 'I';
				}
				if(user.getString("PERSONTYPE").equals("O")) {
					return 'O';
				}
				else if(user.getString("PERSONTYPE").equals("B")) {
					return 'B';
				}
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return ' ';								// User not found
	}
	
	public void register(String u, String p) {
		String sql = "INSERT INTO " + userTable + " (username,password,personType)" +
				" VALUES ( '" + u + "', '" + p + "', '" + 'B' + "');";
		try{
			pStatement = conn.prepareStatement(sql);
			pStatement.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
