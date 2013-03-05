package com.example.services;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHelper
{
	private String url;
	private static ConnectionHelper instance;
	private static Connection conn;

	//	private ConnectionHelper()
	//	{
	//    	String driver = null;
	//		try {
	//			Class.forName("com.mysql.jdbc.Driver");
	//			url = "jdbc:mysql://localhost/directory?user=root";
	//            ResourceBundle bundle = ResourceBundle.getBundle("directory");
	//            driver = bundle.getString("jdbc.driver");
	//            Class.forName(driver);
	//            url=bundle.getString("jdbc.url");
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

	public static Connection getConnection() throws SQLException {
		try {
			if (conn == null) {
				String url = "jdbc:postgresql://ec2-107-20-147-106.compute-1.amazonaws.com:5432/dfurd2s0mhhvke?user=topxkicidtdcyv&password=dolNXmMjTHCOBUA0ptcVvSZs5s&ssl=true";
				conn = DriverManager.getConnection(url);
			}

		} catch (SQLException e) {
			throw e;
		}
		return conn;
	}

	public static void close(Connection connection)
	{
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}