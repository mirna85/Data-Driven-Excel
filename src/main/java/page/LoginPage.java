package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='password']") WebElement PASSWORD_FIELD;
	@FindBy (how = How.XPATH, using = "//button[@name='login']") WebElement SIGNIN_FIELD;
	
	public void enterUsername(String userName) {
		
		USERNAME_FIELD.sendKeys(userName);	
	}
	
	public void enterPassword(String password) {
		
		PASSWORD_FIELD.sendKeys(password);
	}
	
	public void clickSignin() {
		
		SIGNIN_FIELD.click();
	}

}
