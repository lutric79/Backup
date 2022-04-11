package debtReviewTests;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameWorkClasses.FinanceBasePage;
import pageObjectFinance.ConsumerFriendPortal;

public class DebtReviewStatusUpdate extends FinanceBasePage {

	ConsumerFriendPortal CFL = new ConsumerFriendPortal();

	@Test
	public void UpdateButton_Not_Available_For_LH_Accounts_In_Company2() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company2_LegalHandover_IdNumber();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		System.out.println(driver
				.findElement(By.cssSelector(
						"section:nth-of-type(2)  .b-light.b-t.table.table-striped > tbody > tr > td:nth-of-type(4)"))
				.getText());

		String locator = "//span/a/em[@safeclass~'\\bi\\b.*\\bi-user2\\b']";
		boolean testResult = CFL.isChangeStatusButtonNotDisplayed(locator);
		Assert.assertFalse(testResult, "Element is displayed");

	}

	@Test
	public void LH_To_DebtReview_For_Company3_LH_Accounts() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company3_LH_IdNumber();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToAppliedForDebtReview();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(driver
				.findElement(By.xpath(
						"//td[text()='Debt Review']"))
				.getText());

	}

	@Test
	public void LH_To_DebtReview_For_Company3_Active_Accounts_Active_Branch()
			throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company3_Active_IdNumber_Branch_Active();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToAppliedForDebtReview();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(driver
				.findElement(By.cssSelector(
						"section:nth-of-type(2)  .b-light.b-t.table.table-striped > tbody > tr > td:nth-of-type(4)"))
				.getText());
	}

	@Test
	public void LH_To_DebtReview_For_Company3_Active_Accounts_Branch_DR() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company3_Active_IdNumber_Branch_DR();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToAppliedForDebtReview();
		CFL.clickSaveButton();
		Thread.sleep(50000);
		
		// To locate table
		//WebElement mytable = getElement(By.xpath("(//tbody)[2]"));

		// To locate rows of table
		//List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate number of rows
		//int rows_count = rows_table.size();
		//System.out.println("The number of rows is " + rows_count);
		
		//for (int row = 0; row < rows_count; row++) {
			//To locate no of columns(cells) in that specific row
			//List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			
			//int columns_count = Columns_row.size();
			//System.out.println("Number of cells in Row "+ "is " + columns_count);
			//for(int column = 0; column < columns_count; column++) {
				//To retrieve text from that specific cell
				//String celtext = Columns_row.get(column).getText();
				//System.out.println(celtext);
				
//				if( Columns_row.get(column).getText().equals("Debt Revie")){
//					Assert.assertTrue(true);
				
//				if(celtext.equals("Debt Review")) {
//					Assert.assertEquals(celtext,"252");
//				}
//				}
				Assert.assertEquals(CFL.DebtReviewStatus(), "Debt Review");	
				
			}
		
		
		
	
	
	@Test
	public void DebtReview_For_Company3_Complete_Accounts_Branch_Active() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company3_Complete_IdNumber_Branch_Active();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToExternal3rdParty();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(CFL.CustomerStatus());
		Assert.assertEquals(CFL.CustomerStatus(), "Debt Review - 3rd Party");

	}

	@Test
	public void DebtReview_For_Company3_Complete_Accounts_Branch_DR() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company3_Complete_IdNumber_Branch_DR();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToExternal3rdParty();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(CFL.CustomerStatus());
		Assert.assertEquals(CFL.CustomerStatus(), "Debt Review - 3rd Party");

	}

	@Test
	public void DebtReview_For_Company2_Complete_Accounts_Branch_Active() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company2_Complete_IdNumber_Branch_Active();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToExternal3rdParty();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(CFL.CustomerStatus());
		Assert.assertEquals(CFL.CustomerStatus(), "Debt Review - 3rd Party");
	}

	@Test
	public void DebtReview_For_Company2_Complete_Accounts_Branch_DR() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company2_Complete_IdNumber_Branch_DR();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToExternal3rdParty();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(CFL.CustomerStatus());
		Assert.assertEquals(CFL.CustomerStatus(), "Debt Review - 3rd Party");
	}

	@Test
	public void DebtReview_For_Company3_Settled_Accounts_Branch_Active() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company3_Settled_IdNumber_Branch_Active();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToExternal3rdParty();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(CFL.CustomerStatus());
		Assert.assertEquals(CFL.CustomerStatus(), "Debt Review - 3rd Party");

	}

	@Test
	public void DebtReview_For_Company3_Settled_Accounts_Branch_DR() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company3_Settled_IdNumber_Branch_DR();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToExternal3rdParty();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(CFL.CustomerStatus());
		Assert.assertEquals(CFL.CustomerStatus(), "Debt Review - 3rd Party");

	}

	@Test
	public void DebtReview_For_Company2_Settled_Accounts_Branch_Active() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company2_Settled_IdNumber_Branch_Active();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToExternal3rdParty();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(CFL.CustomerStatus());
		Assert.assertEquals(CFL.CustomerStatus(), "Debt Review - 3rd Party");
	}

	@Test
	public void DebtReview_For_Company2_Settled_Accounts_Branch_DR() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company2_Settled_IdNumber_Branch_DR();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToExternal3rdParty();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(CFL.CustomerStatus());
		Assert.assertEquals(CFL.CustomerStatus(), "Debt Review - 3rd Party");
	}

	@Test
	public void DebtReview_For_Company3_Stop_Action_Accounts() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company3_Stop_Action();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToExternal3rdParty();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(CFL.CustomerStatus());
		Assert.assertEquals(CFL.CustomerStatus(), "Debt Review - 3rd Party");

	}

	@Test
	public void DebtReview_For_Company2_Stop_Action_Accounts() throws InterruptedException, SQLException {

		CFL.goHome();
		CFL.usernameEntry();
		CFL.passwordEntry();
		CFL.clickLogInButton();
		CFL.enter_Company2_Stop_Action();
		CFL.clickSearchButton();
		CFL.clickZoomButton();
		CFL.clickChangeStatusButton();
		CFL.updateToExternal3rdParty();
		CFL.clickSaveButton();
		Thread.sleep(30000);
		System.out.println(CFL.CustomerStatus());
		Assert.assertEquals(CFL.CustomerStatus(), "Debt Review - 3rd Party");

	}

}