package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import base.Page;
import io.qameta.allure.Allure;
import utils.Configreader;
import utils.LoggerLoad;

public class Stackpage extends Page {
	public Stackpage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(xpath="//button[normalize-space()='Get Started']")WebElement GetStarted; 
	@FindBy(xpath = "//*//a[contains(text(), 'Data Structures')]")WebElement dropdown;
	
	@FindBy(xpath = "//*[@id='navbarCollapse']//a[contains(@href, '/stack')]")WebElement dropdownstack;
	@FindBy(xpath = "//a[normalize-space()='Sign in']") public WebElement signin;
	@FindBy(xpath = "//input[@id='id_username']") public WebElement username;
	@FindBy(xpath = "//input[@id='id_password']")public WebElement password;
	@FindBy(xpath ="//input[@value='Login']")public WebElement login;

	@FindBy(xpath = "//a[@href='stack']")WebElement getstartstack;
	@FindBy(xpath = "//a[@href=\"operations-in-stack\"]")WebElement Operationsinstack ;
	
	@FindBy(xpath = "//a[@href=\"implementation\"]")WebElement Implementation;
	@FindBy(xpath = "//a[@href='stack-applications']")WebElement Applications;
	@FindBy(xpath = "//a[@href=\"stack/practice\"]")WebElement Practicequestions ;
	//@FindBy(xpath = "//a[href='stack-applications']")WebElement Applications;
	
	@FindBy(xpath = "//a[@href='/tryEditor']")WebElement Tryherebtn;
	@FindBy(xpath = "//textarea[@tabindex='0']")WebElement tryhere;
	@FindBy(xpath = "//*[@id='answer_form']/button")WebElement RunButton ;
	@FindBy (id = "output")WebElement Output;
	
	public void dropdownstack() {
		dropdown.click();
		dropdownstack.click();
	}

	public void GetStarted_link() {
		Allure.step("Click GetStarted_link");
		GetStarted.click();
	}
	public void signin()  {
		Allure.step("Click Signin link");
		signin.click();
	}
	public void Username(String name){
		Allure.step("Give user Username");
		username.sendKeys(name);
	}
	public void Password(String name) {
		Allure.step("Give Password");
		 password.sendKeys(name);	 
	}
	public void Login() {
		Allure.step("Clicked Login link");
		login.click();
	}

	public void Operationsinstacklink() {
		Allure.step(" Click Operations in stack link");
		Operationsinstack.click();
	}
	
	public void Implementationlink() {
		Allure.step("Click Implementation link");
		Implementation.click();
	}
	public void  Applicationslink() {
		Allure.step("Click Applications link");
		 Applications.click();
	}
	public void  Practicequestionslink() {
		Allure.step("Click Practicequestions link");
		 Practicequestions.click();
	}
	public void clicktryherebtn() {
		Allure.step("click try herebtn");
		(Tryherebtn).click();
	   }
	
	
	public void RunButton() {
		Allure.step("Click Run Button");
		RunButton.click();
	}	
	public void sendPythonCode(String code) {
		Allure.step("send PythonCode");

		//(tryhere).clear();
		//ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' CodeMirror-line ']"));
		
try {
			Thread.sleep(3000);
			(tryhere).sendKeys(code);
} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
public Stackpage verifStackPage() {
	Allure.step(" verifStackPage");

	String url = driver.getCurrentUrl();
	LoggerLoad.logDebug("The current URL of the page is " + url);
	AssertJUnit.assertEquals(Configreader.getProperty("stackpageurl"),url);
	return this;
}
public Stackpage clickLink(String String) {
	

switch (String.trim()) {

case "Operationsinstack":
	Operationsinstacklink();
	
	break;
case "Implementation":
	Implementationlink();
	break;
case "Applications":
	Applicationslink();
	break;

}
	return this;

}
}


