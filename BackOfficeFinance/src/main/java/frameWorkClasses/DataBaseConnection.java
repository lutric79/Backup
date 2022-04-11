package frameWorkClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	public static void main(String[] args) {
		String uat = "jdbc:sqlserver://CAPWNDBUAT02:1433;" +
				"databaseName=DMS_Transact;encrypt=true;trustServerCertificate=true;";
		String user = "LS_ReadOnly";
		String password = "lsr3ad0nly";
		
		try {
			Connection connection = DriverManager.getConnection(uat, user, password);
			
			//String connectionUrl = "jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=;password=;encrypt=true;trustServerCertificate=true;";
			
			System.out.println("Connected to Microsoft SQL Server");
			
		} catch (SQLException e) {
			System.out.println("Oops, there's an error:");
			e.printStackTrace();
		}

	}

}
