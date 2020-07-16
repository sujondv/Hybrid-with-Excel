package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class NewDepositPage extends BasePage {

	WebDriver driver;

	public NewDepositPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.ID, using = "account")
	WebElement CHOOSEANACCOUNT_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	WebElement DESCRIPTION_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='amount']")
	WebElement AMOUNT_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SUBMIT_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//h5[text()='Add Deposit']")
	WebElement ADD_DEPOSIT_ELEMENT;
	
	
	public boolean isNewDepositPageDisplayed() {
		return ADD_DEPOSIT_ELEMENT.isDisplayed();
	}
	
	public void chooseAnAccountFromDropDown() {
		Select select = new Select(CHOOSEANACCOUNT_DROPDOWN_ELEMENT);
		select.selectByVisibleText("Green62");
	}
	
	String actualDescription;
	public void inputDescription(String description) {
		actualDescription = description + randomNumGenerator();
		DESCRIPTION_FIELD_ELEMENT.sendKeys(actualDescription);
	}
	
	public void inputAmount(String amount) {
	
		AMOUNT_FIELD_ELEMENT.sendKeys(amount);
	}

	public void clickOnSubmitButton() {
		SUBMIT_BUTTON_ELEMENT.click();
	}
	
	//tbody/tr[1]/td[1]/a
	//tbody/tr[2]/td[1]/a
	
	String beforeXpath = "//tbody/tr[";
	String afterXpath = "]/td[1]/a";
	
	
	public void varifyEnteredNewDepositDescription() {
		
		for(int i = 1; i<=10; i++) {
			String expectedDescription = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
		
			if(expectedDescription.contains(actualDescription)) {
				System.out.println("Entered description exists");
				}
		}
	}
	
}
