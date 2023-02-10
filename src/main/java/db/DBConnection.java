package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static void initConnection() {
		// 드라이버로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Completed");
		} catch (ClassNotFoundException e) {
			System.out.println("Loading Failed");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		// 드라이버 연결
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1234");
			System.out.println("Connection Completed");
		} catch (SQLException e) {
			System.out.println("Conntction Failed");
			e.printStackTrace();
		}
		return conn;		
	}
}
