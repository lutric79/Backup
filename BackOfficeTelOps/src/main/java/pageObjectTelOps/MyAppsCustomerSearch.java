package pageObjectTelOps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;

import frameWorkClasses.TelOpsBasePage;

public class MyAppsCustomerSearch extends TelOpsBasePage{
	
	public void enterIdNumber() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:sqlserver://CAPWNDBUAT02:1433;databaseName=DMS_Transact;user=LS_ReadOnly;password=lsr3ad0nly;encrypt=true;trustServerCertificate=true;");
				Statement s = con.createStatement();
				ResultSet rs =s.executeQuery("SELECT top 1 ID_Number FROM dbo.da_Customer t1 WITH (NOLOCK)\r\n"
						+ "INNER JOIN dbo.da_Account t2 WITH (NOLOCK)  ON t1.Object_id = t2.Object_ID AND t2.Account_Status = 'Active' AND t2.Company_Id = 3 ");
				while(rs.next())
					
				{
				String Id_No = (rs.getString("ID_Number"));
				driver.findElement(By.cssSelector("p-inputmask#idNumber > .p-component.p-element.p-inputmask.p-inputtext")).sendKeys(Id_No);
				
				}
				
	}
	
//	public void enterIdNumber(String IdNumber) {
//		EnterText(By.cssSelector("p-inputmask#idNumber > .p-component.p-element.p-inputmask.p-inputtext"), IdNumber);
//	}
	
	public void clickSearchButton() {
		clickElement(By.cssSelector("[aria-hidden='false']"));
	}
	
	public void selectCustomer() {
		clickElement(By.cssSelector(".ng-star-inserted.p-element.p-selectable-row > td:nth-of-type(3)"));
	}
	
	public void clickOnContinueButton() {
		clickElement(By.cssSelector("p-button[label='Continue']  .ng-star-inserted.p-button-label"));
	}
	
	public void clickCustomerDetailstab() {
		clickElement(By.xpath("//ul/li[2]"));
	}
	
	public void clickUpdateButton() {
		clickElement(By.cssSelector("app-personal-details [aria-hidden='false']"));
	}
	
	public void clearFirstName(){
		driver.findElement(By.id("firstName")).clear();
		
	}
	
	public void saveChanges() {
		clickElement(By.xpath("//div[@class='p-dialog-footer']/p-button[2]"));
	}

}
