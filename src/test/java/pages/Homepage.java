package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import base.Base;
import base.Page;
import utils.Configreader;
import utils.LoggerLoad;

public class Homepage extends Page {

	public Homepage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	final String homePageUrl = Configreader.getProperty("homePageUrl");
	By getStartedButton = By.xpath("//button[text()='Get Started']");

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement getstart_datastructures;

	@FindBy(xpath = "//a[@href='array']")
	WebElement getstart_array;
	@FindBy(xpath = "//a[@href='linked-list']")
	WebElement getstart_linkedlist;
	@FindBy(xpath = "	//a[@href='stack']")
	WebElement getstart_stack;
	@FindBy(xpath = "//a[@href='queue']")
	WebElement getstart_queue;
	@FindBy(xpath = "//a[@href='tree']")
	WebElement getstart_tree;
	@FindBy(xpath = "//a[@href='graph']")
	WebElement getstart_graph;
	By clickstartedbtn = By.xpath("//a[text()='Get Started']");

	// @FindBy(xpath="//a[text()='Get Started']")WebElement clickstartedbtn;

	@FindBy(xpath = "//*[@class='alert alert-primary']")
	WebElement Alert_msg;
	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	WebElement signin;

	@FindBy(xpath = "//*[@id='navbarCollapse']//a[contains(text(),'Data Structures')]")
	WebElement DropDown;
	@FindBy(xpath = "//a[href='#']")
	WebElement dropdown;
	@FindBy(xpath = "//a[normalize-space()='Arrays']")
	WebElement dropdown_Array;
	@FindBy(xpath = "//a[normalize-space()='Linked List']")
	WebElement dropdown_Linkedlist;
	@FindBy(xpath = "//a[normalize-space()='Stack']")
	WebElement dropdown_Stack;
	@FindBy(xpath = "//a[normalize-space()='Queue']")
	WebElement dropdown_Queue;
	@FindBy(xpath = "//a[normalize-space()='Tree']")
	WebElement dropdown_Tree;
	@FindBy(xpath = "//a[normalize-space()='Graph']")
	WebElement dropdown_Graph;
	// div[@class= 'dropdown-menu show']/a
	By dropdowns = By.xpath("//div[@class= 'dropdown-menu show']/a");
	// a[text()='Get Started']
	// a[text()=' Register ']
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement signout;

	@FindBy(xpath = "//a[text()=' Register ']")
	WebElement registerbtn;

	public Homepage openHomePage() {
		driver.get(homePageUrl);
		return this;
	}

	public Homepage getstartedclick(String string) {
		switch (string) {
		case "Datastructures":
			getstart_datastructures.click();
			break;

		case "Arrays":
			getstart_array.click();
			break;

		case "Linkedlist":
			getstart_linkedlist.click();
			break;

		case "Stack":
			getstart_stack.click();
			break;

		case "Queue":
			getstart_queue.click();
			break;

		case "Tree":
			getstart_tree.click();
			break;

		case "Graph":
			getstart_graph.click();
			break;

		}
		return this;

	}

	public String Alert_msg() {
		// TODO Auto-generated method stub
		return Alert_msg.getText();
	}

	public Datastructurepage clickDataStucture() {
		getstart_datastructures.click();
		return new Datastructurepage(driver);

	}

	public Linkedlistpage clickLinkedListDropDown() {
		getstart_linkedlist.click();
		return new Linkedlistpage(driver);

	}

	public Homepage dropdownclick(String String) {

		DropDown.click();

		switch (String) {

		case "Arrays":
			dropdown_Array.click();
			break;
		case "Linkedlist":
			dropdown_Linkedlist.click();
			break;
		case "Stack":
			dropdown_Stack.click();
			break;
		case "Queue":
			dropdown_Queue.click();
			break;
		case "Tree":
			dropdown_Tree.click();
			break;
		case "Graph":
			dropdown_Graph.click();
			break;
		}
		return this;
	}

	public Treepage clickTreepageDropDown() {
		getstart_tree.click();
		return new Treepage(driver);

	}

	public Loginpage signinlink() {

		signin.click();
		return new Loginpage(driver);
	}

	public Registerpage clickregisterbtn() {

		registerbtn.click();
		return new Registerpage(driver);
	}

	public Homepage verifyHomePage() {
		LoggerLoad.logInfo("Entering Method :verifyHomePage");
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty("homePageUrl"), url);
		return this;
	}

	public Homepage refresh() {
		LoggerLoad.logInfo("Entering Method : refresh");
		driver.navigate().refresh();
		return this;
	}

	public void verifyErrorMessage() {

		String alertMessage = Alert_msg.getText();
		String message = Configreader.getProperty("homepageAlertMessage");
		AssertJUnit.assertTrue(message.contains(alertMessage));

	}

	public Homepage logout() {
		signout.click();
		return this;
	}
}
