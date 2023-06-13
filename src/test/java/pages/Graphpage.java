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

public class Graphpage extends Page {

	public Graphpage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href ='graph']")
	WebElement graph;
	@FindBy(xpath = "//a[@href ='graph-representations']")
	WebElement graphRepresentations;


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

	@FindBy(xpath = "//a[@href='/graph']")
	WebElement dropdownGraph;
	
	

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

	public void clickGraphDropdownButton() {
		(dropdownGraph).click();
	}

	public void clickDropdownButton() {
		(dropdownbtn).click();
	}

	public Graphpage clickgraph() {
		(graph).click();
		return this;
	}

	public Graphpage clickgraphRepresentations() {
		graphRepresentations.click();
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

	public Graphpage clickLink(String String) {

		switch (String) {
		case "GraphRepresentations":
			clickgraphRepresentations();
			break;
		case "Graph":
			clickgraph();
			break;
		}
		return this;
	}
	

	public Graphpage verifyGraphPage() {
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty("graphPageUrl"), url);
		return this;
	}
}
