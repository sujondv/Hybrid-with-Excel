package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.BasePage;
import page.DashboardPage;
import page.LoginPage;
import page.NewDepositPage;
import util.BrowserFactory;
import util.ExcelReader;

public class NewDepositTest {

	WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	NewDepositPage newdepositpage;

	ExcelReader reader = new ExcelReader(".\\data\\Login.xlsx");
	String username = reader.getCellData("login", "username", 2);
	String password = reader.getCellData("login", "password", 2);
	String description = reader.getCellData("login", "description", 2);
	String amount = reader.getCellData("login", "amount", 2);

	@Test
	public void userShouldBeAbleToAddNewDeposit() throws Exception {

		driver = BrowserFactory.launchBrowser();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.Login(username, password);
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		Thread.sleep(3000);
		Assert.assertTrue(dashboardPage.isDashboardPageDisplayed(), "Dashboard page did not display");
		dashboardPage.clickOnTransactionsButton();
		dashboardPage.clickOnNewDepositButton();
		Thread.sleep(3000);
		newdepositpage = PageFactory.initElements(driver, NewDepositPage.class);
		Assert.assertTrue(newdepositpage.isNewDepositPageDisplayed(), "New Deposit page did not display");
		newdepositpage.chooseAnAccountFromDropDown();
		newdepositpage.inputDescription(description);
		newdepositpage.inputAmount(amount);
		Thread.sleep(3000);
		newdepositpage.clickOnSubmitButton();
		Thread.sleep(5000);
		newdepositpage.varifyEnteredNewDepositDescription();
		loginPage.tearDown();

	}

}
