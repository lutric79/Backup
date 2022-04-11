package frameWorkClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection extends TelOpsBasePage{

	public static void main(String[] args) throws Throwable {
		
		
		Connection con = DriverManager.getConnection("jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		
	
		
		Statement s = con.createStatement();
		ResultSet rs =s.executeQuery("select top 1 ID_Number from da_Customer with (nolock) ");
		
		while(rs.next())
		
		{
		System.out.println(rs.getString("ID_Number"));
		
		}

	}

}
