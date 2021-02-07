package studentManagement.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
    private static String url = "jdbc:mysql://localhost:3306/studentManagement";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "";
    private static Connection con;
    private static DBConnection DBConnection = null;
	
    public static Connection getConnection()
    {
        if (con != null) return con;
        return getConnection(url, username, password);
    }
    public static Connection getConnection(String url, String username, String password) {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.out.println("Failed to create the database connection. Message: " + e.getMessage()); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}
