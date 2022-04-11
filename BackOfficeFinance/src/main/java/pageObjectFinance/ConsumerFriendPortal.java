package pageObjectFinance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Vector;

import org.apache.xpath.functions.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameWorkClasses.FinanceBasePage;
import frameWorkClasses.DBConnection;

public class ConsumerFriendPortal extends FinanceBasePage {

	DBConnection DB = new DBConnection();

	String locator = "//span/a/em[@safeclass~'\\bi\\b.*\\bi-user2\\b']";

	public boolean isChangeStatusButtonNotDisplayed(String locator) {
		boolean result = false;
		try {
			result = driver.findElement(By.xpath(locator)).isDisplayed();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public void goHome() {
		driver.get(getDataConfigProperties("ConsumerFriendUAT"));

	}

	public void enterUserName(String UserName) {
		EnterText(By.cssSelector("input#Username"), username());

	}

	public void enterPassword(String Password) {
		EnterText(By.cssSelector("input#Password"), Password);
	}

	public void clickLogInButton() {
		clickElement(By.cssSelector("button#loginButton"));
	}

	public void enter_Company2_LegalHandover_IdNumber() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT top 1 ID_Number FROM dbo.da_Customer t1 WITH (NOLOCK)\r\n"
				+ "INNER JOIN dbo.da_Account t2 WITH (NOLOCK)  ON t1.Object_id = t2.Object_ID AND t2.Account_Status = 'Legal Handover' AND t2.Company_Id = 2 ");
		while (rs.next())

		{
			String Company2_LH_Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Company2_LH_Id_No);

			System.out.println("Company 2 LH ID is " + Company2_LH_Id_No);

		}

	}

	public void enter_Company3_Active_IdNumber_Branch_Active() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT top 1 ID_Number FROM dbo.da_Customer t1 WITH (NOLOCK)\r\n"
				+ "INNER JOIN dbo.da_Account t2 WITH (NOLOCK)  ON t1.Object_id = t2.Object_ID AND t2.Account_Status = 'Active' AND t2.Company_Id = 3 WHERE t2.Branch_ID = 9");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 Active ID is " + Id_No);

		}

	}

	public void enter_Company3_Active_IdNumber_Branch_DR() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT top 1 ID_Number FROM dbo.da_Customer t1 WITH (NOLOCK)\r\n"
				+ "INNER JOIN dbo.da_Account t2 WITH (NOLOCK)  ON t1.Object_id = t2.Object_ID AND t2.Account_Status = 'Active' AND t2.Company_Id = 3 WHERE t2.Branch_ID = 12");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 Active ID is " + Id_No);

		}

	}

	public void enter_Company3_LH_IdNumber() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT top 1 ID_Number FROM dbo.da_Customer t1 WITH (NOLOCK)\r\n"
				+ "INNER JOIN dbo.da_Account t2 WITH (NOLOCK)  ON t1.Object_id = t2.Object_ID AND t2.Account_Status = 'Legal Handover' AND t2.Company_Id = 3 ");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public void enterActiveIdNumberPREPROD() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBPRE02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT top 1 ID_Number FROM dbo.da_Customer t1 WITH (NOLOCK)\r\n"
				+ "INNER JOIN dbo.da_Account t2 WITH (NOLOCK)  ON t1.Object_id = t2.Object_ID AND t2.Account_Status = 'Active' AND t2.Company_Id = 3 ");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 Active ID is " + Id_No);

		}

	}

	public void clickSearchButton() {
		clickElement(By.cssSelector(".glyphicon.glyphicon-search"));
	}

	public void clickZoomButton() {
		clickElement(By.cssSelector("a[title='View'] > .i.i-zoom-in2"));
	}

	public void clickChangeStatusButton() {
		clickElement(By.cssSelector("span > a > .i.i-user2"));
	}

	public String username() {
		return "luthandom";
	}

	public void usernameEntry() {
		driver.findElement(By.cssSelector("input#Username")).sendKeys(username());
	}

	public String password() {
		return "M@qluT!!!000";
	}

	public void passwordEntry() {
		driver.findElement(By.cssSelector("input#Password")).sendKeys(password());
	}

	public void clickSaveButton() {
		clickElement(By.cssSelector(".btn.btn-success"));
	}

	public void updateToAppliedForDebtReview() {
		WebElement staticDropdown = driver.findElement(By.id("SelectedReviewStatus"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("234");
	}

	public void updateToExternal3rdParty() {
		WebElement staticDropdown = driver.findElement(By.id("SelectedReviewStatus"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(1);
	}

	public void enter_Company3_Complete_IdNumber_Branch_Active() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT TOP 1 t3.Id_Number\r\n" + "FROM dbo.da_Account t1 WITH (NOLOCK)\r\n"
				+ "LEFT OUTER JOIN dbo.da_Account t2 WITH (NOLOCK) ON t2.Object_ID = t1.Object_ID AND t2.Company_ID = 3\r\n"
				+ "JOIN dbo.da_Customer t3 WITH (NOLOCK) ON t1.Object_ID = t3.Object_Id\r\n"
				+ "JOIN Cap_Entity.dbo.da_Customer_Status t5 WITH (NOLOCK) ON t3.Customer_Id = t5.Customer_Id\r\n"
				+ "LEFT OUTER JOIN (\r\n" + "SELECT Object_Id, MAX(Account_No) [Account_No]\r\n"
				+ "FROM dbo.da_Account WITH (NOLOCK)\r\n" + "WHERE Company_ID = 3\r\n" + "GROUP BY Object_ID\r\n"
				+ ") t4 ON t4.Object_ID = t1.Object_ID AND t4.Account_No = t1.Account_No\r\n"
				+ "WHERE t1.Company_ID = 3\r\n" + "AND t1.Account_Status IN ('Complete') AND t1.Branch_ID = 9\r\n"
				+ "AND t2.Account_No IS NOT NULL\r\n" + "AND t4.Object_ID IS NOT NULL\r\n"
				+ "AND t5.Customer_Id NOT IN\r\n"
				+ "(SELECT customer_Id FROM Cap_Entity.dbo.da_Customer_Status WHERE Status_Type_ID = 313)\r\n"
				+ "ORDER BY 1 DESC");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public void enter_Company3_Complete_IdNumber_Branch_DR() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT TOP 1 t3.Id_Number\r\n" + "FROM dbo.da_Account t1 WITH (NOLOCK)\r\n"
				+ "LEFT OUTER JOIN dbo.da_Account t2 WITH (NOLOCK) ON t2.Object_ID = t1.Object_ID AND t2.Company_ID = 3\r\n"
				+ "JOIN dbo.da_Customer t3 WITH (NOLOCK) ON t1.Object_ID = t3.Object_Id\r\n"
				+ "JOIN Cap_Entity.dbo.da_Customer_Status t5 WITH (NOLOCK) ON t3.Customer_Id = t5.Customer_Id\r\n"
				+ "LEFT OUTER JOIN (\r\n" + "SELECT Object_Id, MAX(Account_No) [Account_No]\r\n"
				+ "FROM dbo.da_Account WITH (NOLOCK)\r\n" + "WHERE Company_ID = 3\r\n" + "GROUP BY Object_ID\r\n"
				+ ") t4 ON t4.Object_ID = t1.Object_ID AND t4.Account_No = t1.Account_No\r\n"
				+ "WHERE t1.Company_ID = 3\r\n" + "AND t1.Account_Status IN ('Complete') AND t1.Branch_ID = 12\r\n"
				+ "AND t2.Account_No IS NOT NULL\r\n" + "AND t4.Object_ID IS NOT NULL\r\n"
				+ "AND t5.Customer_Id NOT IN\r\n"
				+ "(SELECT customer_Id FROM Cap_Entity.dbo.da_Customer_Status WHERE Status_Type_ID = 313)\r\n"
				+ "ORDER BY 1 DESC");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public void enter_Company2_Complete_IdNumber_Branch_Active() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT TOP 1 t3.ID_Number\r\n" + "FROM dbo.da_Account t1 WITH (NOLOCK)\r\n"
				+ "LEFT OUTER JOIN dbo.da_Account t2 WITH (NOLOCK) ON t2.Object_ID = t1.Object_ID AND t2.Company_ID = 3\r\n"
				+ "JOIN dbo.da_Customer t3 WITH (NOLOCK) ON t1.Object_ID = t3.Object_Id\r\n"
				+ "JOIN Cap_Entity.dbo.da_Customer_Status t5 WITH (NOLOCK) ON t3.Customer_Id = t5.Customer_Id\r\n"
				+ "LEFT OUTER JOIN (\r\n" + "SELECT Object_Id, MAX(Account_No) [Account_No]\r\n"
				+ "FROM dbo.da_Account WITH (NOLOCK)\r\n" + "WHERE Company_ID = 2\r\n" + "GROUP BY Object_ID\r\n"
				+ ") t4 ON t4.Object_ID = t1.Object_ID AND t4.Account_No = t1.Account_No\r\n"
				+ "WHERE t1.Company_ID = 2\r\n" + "AND t1.Account_Status IN ('Complete') AND t1.Branch_ID = 5\r\n"
				+ "AND t2.Account_No IS NULL\r\n" + "AND t4.Object_ID IS NOT null\r\n" + "AND t5.Customer_Id NOT IN\r\n"
				+ "(SELECT customer_Id FROM Cap_Entity.dbo.da_Customer_Status WHERE Status_Type_ID = 313)");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public void enter_Company2_Complete_IdNumber_Branch_DR() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT TOP 1 t3.ID_Number\r\n" + "FROM dbo.da_Account t1 WITH (NOLOCK)\r\n"
				+ "LEFT OUTER JOIN dbo.da_Account t2 WITH (NOLOCK) ON t2.Object_ID = t1.Object_ID AND t2.Company_ID = 3\r\n"
				+ "JOIN dbo.da_Customer t3 WITH (NOLOCK) ON t1.Object_ID = t3.Object_Id\r\n"
				+ "JOIN Cap_Entity.dbo.da_Customer_Status t5 WITH (NOLOCK) ON t3.Customer_Id = t5.Customer_Id\r\n"
				+ "LEFT OUTER JOIN (\r\n" + "SELECT Object_Id, MAX(Account_No) [Account_No]\r\n"
				+ "FROM dbo.da_Account WITH (NOLOCK)\r\n" + "WHERE Company_ID = 2\r\n" + "GROUP BY Object_ID\r\n"
				+ ") t4 ON t4.Object_ID = t1.Object_ID AND t4.Account_No = t1.Account_No\r\n"
				+ "WHERE t1.Company_ID = 2\r\n" + "AND t1.Account_Status IN ('Complete') AND t1.Branch_ID = 8\r\n"
				+ "AND t2.Account_No IS NULL\r\n" + "AND t4.Object_ID IS NOT null\r\n" + "AND t5.Customer_Id NOT IN\r\n"
				+ "(SELECT customer_Id FROM Cap_Entity.dbo.da_Customer_Status WHERE Status_Type_ID = 313)");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public void enter_Company3_Settled_IdNumber_Branch_Active() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT TOP 1 t3.Id_Number\r\n" + "FROM dbo.da_Account t1 WITH (NOLOCK)\r\n"
				+ "LEFT OUTER JOIN dbo.da_Account t2 WITH (NOLOCK) ON t2.Object_ID = t1.Object_ID AND t2.Company_ID = 3\r\n"
				+ "JOIN dbo.da_Customer t3 WITH (NOLOCK) ON t1.Object_ID = t3.Object_Id\r\n"
				+ "JOIN Cap_Entity.dbo.da_Customer_Status t5 WITH (NOLOCK) ON t3.Customer_Id = t5.Customer_Id\r\n"
				+ "LEFT OUTER JOIN (\r\n" + "SELECT Object_Id, MAX(Account_No) [Account_No]\r\n"
				+ "FROM dbo.da_Account WITH (NOLOCK)\r\n" + "WHERE Company_ID = 3\r\n" + "GROUP BY Object_ID\r\n"
				+ ") t4 ON t4.Object_ID = t1.Object_ID AND t4.Account_No = t1.Account_No\r\n"
				+ "WHERE t1.Company_ID = 3\r\n" + "AND t1.Account_Status IN ('Settled') AND t1.Branch_ID = 9\r\n"
				+ "AND t2.Account_No IS NOT NULL\r\n" + "AND t4.Object_ID IS NOT NULL\r\n"
				+ "AND t5.Customer_Id NOT IN\r\n"
				+ "(SELECT customer_Id FROM Cap_Entity.dbo.da_Customer_Status WHERE Status_Type_ID = 313)");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public void enter_Company3_Settled_IdNumber_Branch_DR() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT TOP 1 t3.Id_Number\r\n" + "FROM dbo.da_Account t1 WITH (NOLOCK)\r\n"
				+ "LEFT OUTER JOIN dbo.da_Account t2 WITH (NOLOCK) ON t2.Object_ID = t1.Object_ID AND t2.Company_ID = 3\r\n"
				+ "JOIN dbo.da_Customer t3 WITH (NOLOCK) ON t1.Object_ID = t3.Object_Id\r\n"
				+ "JOIN Cap_Entity.dbo.da_Customer_Status t5 WITH (NOLOCK) ON t3.Customer_Id = t5.Customer_Id\r\n"
				+ "LEFT OUTER JOIN (\r\n" + "SELECT Object_Id, MAX(Account_No) [Account_No]\r\n"
				+ "FROM dbo.da_Account WITH (NOLOCK)\r\n" + "WHERE Company_ID = 3\r\n" + "GROUP BY Object_ID\r\n"
				+ ") t4 ON t4.Object_ID = t1.Object_ID AND t4.Account_No = t1.Account_No\r\n"
				+ "WHERE t1.Company_ID = 3\r\n" + "AND t1.Account_Status IN ('Settled') AND t1.Branch_ID = 12\r\n"
				+ "AND t2.Account_No IS NOT NULL\r\n" + "AND t4.Object_ID IS NOT NULL\r\n"
				+ "AND t5.Customer_Id NOT IN\r\n"
				+ "(SELECT customer_Id FROM Cap_Entity.dbo.da_Customer_Status WHERE Status_Type_ID = 313)");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public void enter_Company3_Stop_Action() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT TOP 1 t1.ID_number  FROM da_Customer t1 WITH (NOLOCK)\r\n"
				+ "				INNER JOIN dbo.da_Account t2  WITH (NOLOCK)\r\n"
				+ "				ON t1.object_id = t2.Object_ID\r\n"
				+ "				INNER JOIN Cap_Entity.dbo.da_Customer_Status t3 WITH (NOLOCK) ON t3.Customer_Id = t1.Customer_Id \r\n"
				+ "				WHERE t2.Account_Status = 'Stop Action' AND t2.company_Id = 3  AND t3.Customer_Id NOT IN\r\n"
				+ "(SELECT customer_Id FROM Cap_Entity.dbo.da_Customer_Status WHERE Status_Type_ID = 313)");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public void enter_Company2_Stop_Action() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT TOP 1 t1.ID_number  FROM da_Customer t1 WITH (NOLOCK)\r\n"
				+ "				INNER JOIN dbo.da_Account t2  WITH (NOLOCK)\r\n"
				+ "				ON t1.object_id = t2.Object_ID\r\n"
				+ "				INNER JOIN Cap_Entity.dbo.da_Customer_Status t3 WITH (NOLOCK) ON t3.Customer_Id = t1.Customer_Id \r\n"
				+ "				WHERE t2.Account_Status = 'Stop Action' AND t2.company_Id = 2  AND t3.Customer_Id NOT IN\r\n"
				+ "(SELECT customer_Id FROM Cap_Entity.dbo.da_Customer_Status WHERE Status_Type_ID = 313)");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public void enter_Company2_Settled_IdNumber_Branch_Active() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT TOP 1 t3.ID_Number\r\n" + "FROM dbo.da_Account t1 WITH (NOLOCK)\r\n"
				+ "LEFT OUTER JOIN dbo.da_Account t2 WITH (NOLOCK) ON t2.Object_ID = t1.Object_ID AND t2.Company_ID = 3\r\n"
				+ "JOIN dbo.da_Customer t3 WITH (NOLOCK) ON t1.Object_ID = t3.Object_Id\r\n"
				+ "JOIN Cap_Entity.dbo.da_Customer_Status t5 WITH (NOLOCK) ON t3.Customer_Id = t5.Customer_Id\r\n"
				+ "LEFT OUTER JOIN (\r\n" + "SELECT Object_Id, MAX(Account_No) [Account_No]\r\n"
				+ "FROM dbo.da_Account WITH (NOLOCK)\r\n" + "WHERE Company_ID = 2\r\n" + "GROUP BY Object_ID\r\n"
				+ ") t4 ON t4.Object_ID = t1.Object_ID AND t4.Account_No = t1.Account_No\r\n"
				+ "WHERE t1.Company_ID = 2\r\n" + "AND t1.Account_Status IN ('Settled') AND t1.Branch_ID = 5\r\n"
				+ "AND t2.Account_No IS NULL\r\n" + "AND t4.Object_ID IS NOT null\r\n" + "AND t5.Customer_Id NOT IN\r\n"
				+ "(SELECT customer_Id FROM Cap_Entity.dbo.da_Customer_Status WHERE Status_Type_ID = 313)");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public void enter_Company2_Settled_IdNumber_Branch_DR() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT TOP 1 t3.ID_Number\r\n" + "FROM dbo.da_Account t1 WITH (NOLOCK)\r\n"
				+ "LEFT OUTER JOIN dbo.da_Account t2 WITH (NOLOCK) ON t2.Object_ID = t1.Object_ID AND t2.Company_ID = 3\r\n"
				+ "JOIN dbo.da_Customer t3 WITH (NOLOCK) ON t1.Object_ID = t3.Object_Id\r\n"
				+ "JOIN Cap_Entity.dbo.da_Customer_Status t5 WITH (NOLOCK) ON t3.Customer_Id = t5.Customer_Id\r\n"
				+ "LEFT OUTER JOIN (\r\n" + "SELECT Object_Id, MAX(Account_No) [Account_No]\r\n"
				+ "FROM dbo.da_Account WITH (NOLOCK)\r\n" + "WHERE Company_ID = 2\r\n" + "GROUP BY Object_ID\r\n"
				+ ") t4 ON t4.Object_ID = t1.Object_ID AND t4.Account_No = t1.Account_No\r\n"
				+ "WHERE t1.Company_ID = 2\r\n" + "AND t1.Account_Status IN ('Settled') AND t1.Branch_ID = 8\r\n"
				+ "AND t2.Account_No IS NULL\r\n" + "AND t4.Object_ID IS NOT null\r\n" + "AND t5.Customer_Id NOT IN\r\n"
				+ "(SELECT customer_Id FROM Cap_Entity.dbo.da_Customer_Status WHERE Status_Type_ID = 313)");
		while (rs.next())

		{
			String Id_No = (rs.getString("ID_Number"));
			driver.findElement(By.cssSelector("input#FilterCriteria")).sendKeys(Id_No);
			System.out.println("Company 3 LH ID is " + Id_No);

		}

	}

	public String CustomerStatus() {
		return getElementText(By.tagName("label"));
	}

	
	//@SuppressWarnings("deprecation")
	public String DebtReviewStatus() {
		return getElementText(By.xpath("//td[text()='Debt Review']"));
		

				
			}
			
		
	
	
}
	
	
			
	
		
				

	


