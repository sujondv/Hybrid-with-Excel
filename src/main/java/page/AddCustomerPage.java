package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULLNAME_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='currency']")
	WebElement CURRENCY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='group']")
	WebElement GROUP_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement PASSWORD1_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='cpassword']")
	WebElement CONFIRM_PASSWORD_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SAVE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//h5[text()='Add Contact']")
	WebElement ADD_CONTACT_ELEMENT;

	public boolean isAddCustomerPageDisplayed() {
		return ADD_CONTACT_ELEMENT.isDisplayed();
	}

	String actualFullName;

	public void inputFullName(String fullname) {
		actualFullName = fullname + randomNumGenerator();
		FULLNAME_FIELD_ELEMENT.sendKeys(actualFullName);
	}

	public void chooseCompanyFromDropDown() {
		Select select = new Select(COMPANY_DROPDOWN_ELEMENT);
		select.selectByVisibleText("Techfios");
	}

	public void inputEmail(String email) {

		EMAIL_FIELD_ELEMENT.sendKeys(randomNumGenerator() + email);
	}

	public void inputPhone(String phone) {

		PHONE_FIELD_ELEMENT.sendKeys(phone + randomNumGenerator());
	}

	public void inputAddress(String address) {

		ADDRESS_FIELD_ELEMENT.sendKeys(address);
	}

	public void inputCity(String city) {

		CITY_FIELD_ELEMENT.sendKeys(city);
	}

	public void inputState(String state) {

		STATE_FIELD_ELEMENT.sendKeys(state);
	}

	public void inputZIP(String zip) {

		ZIP_FIELD_ELEMENT.sendKeys(zip);
	}

	public void chooseCountryFromDropDown() {
		Select select = new Select(COUNTRY_DROPDOWN_ELEMENT);
		select.selectByVisibleText("United States");
	}

	public void chooseCurrencyFromDropDown() {
		Select select = new Select(COMPANY_DROPDOWN_ELEMENT);
		select.selectByVisibleText("USD");
	}

	public void chooseGroupFromDropDown() {
		Select select = new Select(GROUP_DROPDOWN_ELEMENT);
		select.selectByVisibleText("Mid Spring 2020");
	}

	public void validateDropDownList() {

		String[] values = { "None", "Spring 2020", "Mid Spring 2020" };
		Select select = new Select(GROUP_DROPDOWN_ELEMENT);
		List<WebElement> dropdownvalues = select.getOptions();
		System.out.println("DropDownList Size: " + dropdownvalues.size());
		for (int i = 0; i < dropdownvalues.size(); i++) {
			Assert.assertEquals(values[i], dropdownvalues.get(i).getText(), "DropDownList validation failed !!!");
		}
		System.out.println("DropDownList Validation Successful");

		// Print Dropdown List
//		for(WebElement i : dropdownvalues) {
//			System.out.println(i.getText());
//		}

	}

	public void inputPassword1(String password1) {

		PASSWORD1_FIELD_ELEMENT.sendKeys(password1);
	}

	public void inputConfirmPassword(String confirmpassword) {

		CONFIRM_PASSWORD_FIELD_ELEMENT.sendKeys(confirmpassword);
	}

	public void clickOnSaveButton() {

		SAVE_BUTTON_ELEMENT.click();
		;
	}

	// tbody/tr[1]/td[3]/a
	// tbody/tr[2]/td[3]/a

	String beforeXpath = "//tbody/tr[";
	String afterXpath = "]/td[3]";

	public void varifyEnteredCustomerName() {

		for (int i = 1; i <= 10; i++) {
			String expectedFullName = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			// Assert.assertEquals(expectedFullName, actualFullName, "Entered FullName does
			// not exists");
			if (expectedFullName.contains(actualFullName)) {
				System.out.println("Entered FullName exists");
			}
		}
	}

}
