package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
//import org.testng.annotations.Test;

import base.Base;
import base.Page;
import io.qameta.allure.Allure;
import utils.Configreader;
import utils.LoggerLoad;

public class Loginpage extends Page {

	public Loginpage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='id_username']")
	public WebElement userName;
	@FindBy(xpath = "//input[@id='id_password']")
	public WebElement passWord;
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement login;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	public WebElement errorElement;
	@FindBy(xpath = "//a[@href='/register']")
	WebElement register;
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement signout;

	public Registerpage register() throws IOException {

		register.click();
		Allure.step("Clicked register  link");

		return new Registerpage(driver);
	}

	public Loginpage enterUsername(String uname) throws IOException {

		userName.sendKeys(uname);

		Allure.step("entered username");
		return this;
	}

	public Loginpage enterPassword(String pwd) throws InterruptedException, IOException {
		try {
			passWord.sendKeys(pwd);
		} catch (Exception e) {
		}
		Allure.step("entered password");
		return this;
	}

	public Homepage clickLoginButton() throws InterruptedException, IOException, Exception {

		login.click();
		if (driver.getCurrentUrl().equalsIgnoreCase(Configreader.getProperty("loginpageurl"))) {
			if (errorElement.isDisplayed()) {
				if (!getErrorElementg().isEmpty()) {
					throw new Exception(getErrorElementg());
				}
			}
		}
		Allure.step("Clicked login button");

		return new Homepage(driver);
	}

	public String getErrorElementg() {
		Allure.step("Got errorelement textmessage");
		return (errorElement).getText();

	}

	public Loginpage verifyLoginpage() {
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty("loginpageurl"), url);
		Allure.step("Verified LoginPage");
		return this;
	}
	
	public boolean isLoggedIn() {
		Allure.step("Is user LoggedIn");
		boolean isLoggedin;
		try {
			isLoggedin=signout.isDisplayed();
		} catch (Exception e) {
			isLoggedin = false;
		}
		return isLoggedin;
	}

	public Loginpage opensSigninPage() {
		driver.navigate().to(Configreader.getProperty("loginpageurl"));
		return this;

	}

	public Homepage login() throws InterruptedException, IOException, Exception {
		return this.opensSigninPage().enterUsername(Configreader.getProperty("userName"))
				.enterPassword(Configreader.getProperty("passWord")).clickLoginButton();
		// return new Homepage(driver);
	}

	/*
	 * public void logout() { signout.click(); }
	 */
}
