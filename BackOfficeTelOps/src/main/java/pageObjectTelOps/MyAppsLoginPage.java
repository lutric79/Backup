package pageObjectTelOps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import frameWorkClasses.TelOpsBasePage;

public class MyAppsLoginPage extends TelOpsBasePage {
	
	Actions a = new Actions(driver);
	


	public void goHome() {
		driver.get(getDataConfigProperties("systemUnderTest"));

	}
	
	public void clickSessionEndedButton() {
		clickElement(By.cssSelector("#closeDialogBtn"));
	}
	
	public String username() {
		return "luthandom";
	}
	
	public void usernameEntry() {
		driver.findElement(By.id("username")).sendKeys(username());
	}
	
	public String password() {
		return "M@qluT!!!000";
	}
	
	public void passwordEntry() {
		driver.findElement(By.id("password")).sendKeys(password());
	}
	
	public void clickLogInButton() {
		clickElement(By.cssSelector("#loginBtn"));
	}
	
	public void GetPageTitle() {
		driver.getTitle();
		
	}
	
	public String GetCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void clickProfileButton() {
		clickElement(By.cssSelector("#profileBtn"));
	}
	
	public void clickLogOutButton() {
		clickElement(By.xpath("//li/a"));
	}
	
	public void clickOnAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void moveToAwaitingTask() {
		a.moveToElement(driver.findElement(By.cssSelector("div#pauseBtn"))).build().perform();
	}
	

}





