package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashBoardPage extends BasePage {
	
WebDriver driver;
	
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy (how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]") WebElement DASHBOARD_HEADER_FIELD;
	@FindBy (how = How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement CUSTOMERS_FIELD;
	@FindBy (how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]") WebElement ADD_CUSTOMER_FIELD;
	@FindBy (how = How.XPATH, using = "//a[text()='List Customers']") WebElement LIST_CUSTOMER_FIELD;
	
	
	public void verifyDashboardPage() {
		waitForElement(driver, 3, DASHBOARD_HEADER_FIELD);
		Assert.assertEquals(DASHBOARD_HEADER_FIELD.getText(), "Dashboard", "Wrong Page!");
	}
	
	public void clickCustomersButton() {
		CUSTOMERS_FIELD.click();
	}
	
	public void clickAddCustomersButton() {
		ADD_CUSTOMER_FIELD.click();
	}
	
	public void clickListCustomersButton() {
		LIST_CUSTOMER_FIELD.click();
	}

}
