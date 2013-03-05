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

//	public static Connection getConnection() throws SQLException {
//		try {
//			if (conn == null) {
//				try {  
//				    Class.forName("org.postgresql.Driver"); 
//				    System.out.println(" === === DRIVER FOUND === === ");   
//				} catch (ClassNotFoundException e) {
//				    e.printStackTrace();
//				    System.out.println(" === === DRIVER NOT FOUND === === ");
//				}
//				/*$dsn = "pgsql:"
//    . "host=ec2-184-73-194-179.compute-1.amazonaws.com;"
//    . "dbname=ul28zxpr39no1rr;"
//    . "user=dj1wcxb3x9fy3x5;"
//    . "port=5432;"
//    . "sslmode=require;"
//    . "password=p28xwd9pjcrzyzp6mf74m99cze";*/
//				String url = "jdbc:postgresql://ec2-107-20-147-106.compute-1.amazonaws.com:5432/dfurd2s0mhhvke?user=topxkicidtdcyv&password=dolNXmMjTHCOBUA0ptcVvSZs5s&ssl=true";
//				conn = DriverManager.getConnection(url);
//			}
//
//		} catch (SQLException e) {
//			throw e;
//		}
//		return conn;
//	}

	public static Connection getConnection() throws URISyntaxException, SQLException {
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
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