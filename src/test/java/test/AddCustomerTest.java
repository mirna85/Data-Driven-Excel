package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	String fullName = exlread.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String eMail = exlread.getCellData("AddContactInfo", "Email", 2);
	String phoneNumber = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	String state = exlread.getCellData("AddContactInfo", "State", 2);
	String zipCode = exlread.getCellData("AddContactInfo", "Zip", 2);
	
	@Test
	public void validUserToAddCustomer() {
		
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickSignin();
		
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.verifyDashboardPage();
		dashboard.clickCustomersButton();
		dashboard.clickAddCustomersButton();
		
		AddCustomerPage customer = PageFactory.initElements(driver, AddCustomerPage.class);
		customer.enterFullName(fullName);
		customer.enterCompanyName(companyName);
		customer.enterEmail(eMail);
		customer.enterPhone(phoneNumber);
		customer.enterAdress(address);
		customer.enterCity(city);
		customer.enterState(state);
		customer.enterZip(zipCode);
		customer.enterCountry(country);
		customer.clickSaveButtonOnAddContact();
		
		customer.verifySummaryPage();
		dashboard.clickListCustomersButton();
		
		customer.verifyEnteredNameAndDelete(); //The entered name is not being deleted, but the test passes anyway (only works with ME)
		
		//BrowserFactory.tearDown();
	}
	
}
