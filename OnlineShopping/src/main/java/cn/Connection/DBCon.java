package cn.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://vteam8.cbr4uubmqr4e.ap-northeast-2.rds.amazonaws.com:3306/YouthDataHibernate","admin","HHzOAYbHqbL8q5M");
			System.out.println("Database connected");
		}
		return connection;
	}
	
}
