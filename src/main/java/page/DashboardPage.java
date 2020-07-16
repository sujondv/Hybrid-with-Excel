package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Elements Library
	@FindBy(how = How.XPATH, using = "//h2[text()=' Dashboard ']")
	WebElement DASHBOARD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[text()='Transactions']")
	WebElement TRANSACTIONS_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='New Deposit']")
	WebElement NEWDEPOSIT_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[text()='Customers']")
	WebElement CUSTOMER_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='Add Customer']")
	WebElement ADD_CUSTOMER_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='List Customers']")
	WebElement LIST_CUSTOMER_BUTTON_ELEMENT;
	
	

	public boolean isDashboardPageDisplayed() {
		waitForElement(driver, 10, DASHBOARD_ELEMENT);
		return DASHBOARD_ELEMENT.isDisplayed();
	}

	public void clickOnTransactionsButton() {
		waitForElement(driver, 10, TRANSACTIONS_BUTTON_ELEMENT);
		TRANSACTIONS_BUTTON_ELEMENT.click();
	}

	public void clickOnNewDepositButton() {
		waitForElement(driver, 10, NEWDEPOSIT_BUTTON_ELEMENT);
		NEWDEPOSIT_BUTTON_ELEMENT.click();
	}

	public void clickOnCustomerButton() {
		CUSTOMER_BUTTON_ELEMENT.click();
	}

	public void clickOnAddCustomerButton() {
		ADD_CUSTOMER_BUTTON_ELEMENT.click();
	}

	public void clickOnListCustomerButton() {
		LIST_CUSTOMER_BUTTON_ELEMENT.click();
	}

}
