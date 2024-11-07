package BankingApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static final String URL ="jdbc:mysql://localhost:3306/banking_app";
    public static final String USER= "root";
    public static final String PASSWORD = "jesaura@2527";
	
public static Connection getConnection()throws SQLException
{
    	return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
