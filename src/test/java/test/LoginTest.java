package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	ExcelReader reader = new ExcelReader(".\\data\\Login.xlsx");
	String username = reader.getCellData("login", "username", 2);
	String password = reader.getCellData("login", "password", 2);
	
	@Test
	public void userShouldBeAbleToLogin() throws Exception {
		
		driver = BrowserFactory.launchBrowser();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.Login(username, password);
		Thread.sleep(3000);
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.isDashboardPageDisplayed();
		loginPage.tearDown();
		
	}

}
