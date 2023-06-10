package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import base.Page;
import utils.Configreader;
import utils.LoggerLoad;

public class Arraypage extends Page {

	public Arraypage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href ='arrays-in-python']")
	WebElement ArraysinPython;
	@FindBy(xpath = "//a[@href ='arrays-using-list']")
	WebElement arrayUsingListPython;
	@FindBy(xpath = "//a[@href ='basic-operations-in-lists']")
	WebElement basicOperationListinPython;
	@FindBy(xpath = "//a[@href ='applications-of-array']")
	WebElement applicationOfArrayPython;

	@FindBy(xpath = "//div[@class='code-area']/div/pre")
	WebElement runresult;
	@FindBy(xpath = "//textarea[@tabindex='0']")
	WebElement tryhere;

	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement runbutton;
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryherebtn;
	@FindBy(xpath = "//div[@id='navbarCollapse']//a[contains(text(),'Data Structures')]")
	WebElement dropdownbtn;

	@FindBy(xpath = "//input[@id='id_username']")
	WebElement Usernamebtn;
	@FindBy(xpath = "//input[@id='id_password']")
	WebElement Passwotdbtn;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;

	@FindBy(xpath = "//a[@href='/array']")
	WebElement dropdownArray;
	
	

	public void opensSigninPage() {
		// driver.navigate().to(loginpageurl);
	}

	public void inputusername(String name) {
		(Usernamebtn).sendKeys(name);
	}

	public void sendpassword(String password) {
		(Passwotdbtn).sendKeys(password);
	}

	public void clickLoginButton() {
		(loginbtn).click();
	}

	public void clickArrayDropdownButton() {
		(dropdownArray).click();
	}

	public void clickDropdownButton() {
		(dropdownbtn).click();
	}

	public Arraypage clickArraysInPythonButton() {
		(ArraysinPython).click();
		return this;
	}

	public Arraypage clickArraysUsingListPython() {
		arrayUsingListPython.click();
		return this;
	}

	public Arraypage clickapplicationOfArrayPython() {
		applicationOfArrayPython.click();
		return this;
	}

	public Arraypage clickbasicOperationListinPython() {
		basicOperationListinPython.click();
		return this;
	}
	
	

	public void clicktryherebtn() {
		(tryherebtn).click();
	}

	public void clickRunnbutton() {
		(runbutton).click();
	}

	public void sendPythonCode(String code) {

		try {
			Thread.sleep(3000);
			tryhere.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), code);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Arraypage clickLink(String String) {

		switch (String) {
		case "BasicOperationsinLists":
			clickbasicOperationListinPython();
			break;
		case "ApplicationsofArraypage":
			clickapplicationOfArrayPython();
			break;
		case "ArraysUsingList":
			clickArraysUsingListPython();
			break;
		case "ArraysinPython":
			clickArraysInPythonButton();
			break;	
		}
		return this;
	}
	

	public Arraypage verifyArrayPage() {
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty("arrayPageUrl"), url);
		return this;
	}
}
