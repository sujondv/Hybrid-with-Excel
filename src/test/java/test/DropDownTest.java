package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import page.NewDepositPage;
import util.BrowserFactory;
import util.ExcelReader;

public class DropDownTest {

	WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	NewDepositPage newdepositpage;
	AddCustomerPage addCustomerPage;

	ExcelReader reader = new ExcelReader(".\\data\\Login.xlsx");
	String username = reader.getCellData("login", "username", 2);
	String password = reader.getCellData("login", "password", 2);

	@Test
	public void userShouldBeAbleToValidateDropDownList() throws Exception {

		driver = BrowserFactory.launchBrowser();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.Login(username, password);
		Thread.sleep(3000);
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		Assert.assertTrue(dashboardPage.isDashboardPageDisplayed(), "Dashboard page did not display");
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnAddCustomerButton();
		Thread.sleep(3000);
		addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		Assert.assertTrue(addCustomerPage.isAddCustomerPageDisplayed(), "Add customer page did not display");
		addCustomerPage.validateDropDownList();
		loginPage.tearDown();

	}

}
