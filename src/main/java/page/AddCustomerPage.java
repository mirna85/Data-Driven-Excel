package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULL_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement COUNTRY_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='submit']")
	WebElement SAVE_BUTTON_ON_ADD_CONTACT;
	@FindBy(how = How.XPATH, using = "//a[@id='summary']")
	WebElement SUMMARY_ON_SUMMARY_PAGE;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	WebElement OK_BUTTON;
	@FindBy(how = How.XPATH, using = "/html/body/section/div/div[1]/div[3]/div[2]/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]")
	WebElement MANAGE_BUTTON;

	String enteredName;

	public void enterFullName(String fullName) {

		enteredName = fullName + GenerateNumber(999);

		FULL_NAME_FIELD.sendKeys(fullName + GenerateNumber(999));
	}

	public void enterCompanyName(String company) {

		selectDropdown(COMPANY_FIELD, company);
	}

	public void enterEmail(String email) {

		EMAIL_FIELD.sendKeys(GenerateNumber(999) + email);
	}

	public void enterPhone(String phone) {

		PHONE_FIELD.sendKeys(GenerateNumber(99) + phone);
	}

	public void enterAdress(String address) {

		ADDRESS_FIELD.sendKeys(address);
	}

	public void enterCity(String city) {

		CITY_FIELD.sendKeys(city);
	}

	public void enterState(String state) {

		STATE_FIELD.sendKeys(state);
	}

	public void enterZip(String zip) {

		ZIP_FIELD.sendKeys(zip);
	}

	public void enterCountry(String country) {

		COUNTRY_FIELD.sendKeys(country);
	}

	public void clickSaveButtonOnAddContact() {

		SAVE_BUTTON_ON_ADD_CONTACT.click();
	}

	public void verifySummaryPage() {
		waitForElement(driver, 5, SUMMARY_ON_SUMMARY_PAGE);
		Assert.assertEquals(SUMMARY_ON_SUMMARY_PAGE.getText(), "Summary", "Wrong Page");
	}

	// tbody/tr[1]/td[3]
	// tbody/tr[2]/td[3]
	// tbody/tr[3]/td[3]
	// tbody/tr[i]/td[3]
	// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2] //absolute
	// tbody/tr[i]/td[3]/following-sibling::td[4]/a[2] //relative

	public void verifyEnteredNameAndDelete() {
		
		//waitForElement(driver, 10, MANAGE_BUTTON);
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();

//			  System.out.println(name); Assert.assertEquals(name, enteredName,"Enter name doesn't exist!!"); 
//			  break;

			if (name.contains(enteredName)) {
				System.out.println("Entered name exist.");
				driver.findElement(By.xpath(before_xpath + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
			}
		}
	}

}
