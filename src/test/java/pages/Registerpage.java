package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;

import base.Base;
import base.Page;
import utils.Configreader;
import utils.ExcelReader;
import utils.LoggerLoad;

public class Registerpage extends Page {

	final String registerPageUrl = Configreader.getProperty("registerPageUrl");

	@FindBy(xpath = "//input[@value='Register']")
	WebElement registerbtn;
	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password1")
	WebElement password1;
	@FindBy(name = "password2")
	WebElement password2confirmation;
	@FindBy(xpath = "//a[text()='Sign out']")
	WebElement signoutbtn;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement errorElement;

	public Registerpage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public Registerpage opensregisterPage() {

		LoggerLoad.logDebug("The Register page URL is " + registerPageUrl);
		driver.navigate().to(registerPageUrl);

		return this;

	}

	public Registerpage clickRegisterbtn() {

		(registerbtn).click();

		return this;
	}

	public Registerpage inputusername(String name) {

		(username).sendKeys(name);

		return this;
	}

	public Registerpage sendpassword(String password) {

		(password1).sendKeys(password);

		return this;

	}

	public Registerpage sendpasswordConfirmation(String passwordconfirmation) {

		(password2confirmation).sendKeys(passwordconfirmation);

		return this;

	}

	public Registerpage clearusername() {

		(username).clear();

		return this;

	}

	public String findusername() {

		String userNameValue = (username).getAttribute("value");

		return userNameValue;

	}

	public String findPassword() {

		String passwordNameValue = (password1).getAttribute("value");

		return passwordNameValue;

	}

	public String findPasswordconfirmation() {

		String passwordconfNameValue = (password2confirmation).getAttribute("value");

		return passwordconfNameValue;

	}

	public Registerpage getusernameeerormsg() {

		(username).clear();

		return this;

	}

	public Registerpage clearpassword() {

		(password1).clear();

		return this;

	}

	public Registerpage clearpasswordconfirmation() {

		(password2confirmation).clear();

		return this;

	}

	public Registerpage signout() {

		(signoutbtn).click();

		return this;

	}

	public String getErrorElementg() {

		return (errorElement).getText();

	}

	public String usernameErrorMsg() {

		return (username).getAttribute("validationMessage");

	}

	public String passwordErrorMsg() {

		return (password1).getAttribute("validationMessage");

	}

	public String passwordconfirmationErrorMsg() {

		return (password2confirmation).getAttribute("validationMessage");

	}

	public Registerpage validateErrorMessage(String testcaseNo, String message) {

		String formMessage = null;
		

		switch (testcaseNo) {
		case "username":
			formMessage = this.usernameErrorMsg();
			break;
		case "psswd":
			formMessage = this.passwordErrorMsg();
			break;
		case "confpsswd":
			formMessage = this.passwordconfirmationErrorMsg();
			break;
		case "formValidation":
			formMessage = this.getErrorElementg();
			break;

		default:
			break;
		}
		
		AssertJUnit.assertEquals( message,formMessage);

		return this;

	}
	
	public Registerpage verifyRegisterPage() {
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty("registerPageUrl"),url);
		return this;
		
	}

	
}
