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

public class AddCustomerTest {

	WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	NewDepositPage newdepositpage;
	AddCustomerPage addCustomerPage;

	ExcelReader reader = new ExcelReader(".\\data\\Login.xlsx");
	String username = reader.getCellData("login", "username", 2);
	String password = reader.getCellData("login", "password", 2);
	String fullname = reader.getCellData("addCustomer", "fullname", 2);
	String email = reader.getCellData("addCustomer", "email", 2);
	String phone = reader.getCellData("addCustomer", "phone", 2);
	String address = reader.getCellData("addCustomer", "address", 2);
	String city = reader.getCellData("addCustomer", "city", 2);
	String state = reader.getCellData("addCustomer", "state", 2);
	String zip = reader.getCellData("addCustomer", "zip", 2);
	String password1 = reader.getCellData("addCustomer", "password1", 2);
	String confirmpassword = reader.getCellData("addCustomer", "confirmpassword", 2);

	@Test
	public void userShouldBeAbleToAddNewCustomer() throws Exception {

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
		addCustomerPage.inputFullName(fullname);
		addCustomerPage.chooseCompanyFromDropDown();
		addCustomerPage.inputEmail(email);
		addCustomerPage.inputPhone(phone);
		addCustomerPage.inputAddress(address);
		addCustomerPage.inputCity(city);
		addCustomerPage.inputState(state);
		addCustomerPage.inputZIP(zip);
		addCustomerPage.chooseCountryFromDropDown();
		addCustomerPage.chooseGroupFromDropDown();
		addCustomerPage.inputPassword1(password1);
		addCustomerPage.inputConfirmPassword(confirmpassword);
		addCustomerPage.clickOnSaveButton();
		Thread.sleep(3000);
		dashboardPage.clickOnListCustomerButton();
		Thread.sleep(3000);
		addCustomerPage.varifyEnteredCustomerName();
		loginPage.tearDown();
		
		}
}
