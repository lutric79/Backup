package cSRenewalTests;

import java.sql.SQLException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import frameWorkClasses.TelOpsBasePage;
import pageObjectTelOps.MyAppsCustomerSearch;
import pageObjectTelOps.MyAppsLoginPage;

public class UpdatePersonalDetails extends TelOpsBasePage {
	MyAppsLoginPage MyLogIn = new MyAppsLoginPage();
	MyAppsCustomerSearch MySearch = new MyAppsCustomerSearch();
	

	@Test
	public void Name_Is_Empty()
			throws InterruptedException, SQLException {

		MyLogIn.clickSessionEndedButton();
		MyLogIn.usernameEntry();
		MyLogIn.passwordEntry();
		MyLogIn.clickLogInButton();
		MySearch.enterIdNumber();
		MySearch.clickSearchButton();
		MySearch.selectCustomer();
		MySearch.clickOnContinueButton();
		MySearch.clickCustomerDetailstab();
		MySearch.clickUpdateButton();
		MySearch.clearFirstName();
		MySearch.saveChanges();



	}

}
