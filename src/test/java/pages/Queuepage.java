package pages;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.AssertJUnit;

	import base.Page;
import io.qameta.allure.Allure;
import utils.Configreader;
	import utils.LoggerLoad;

	public class Queuepage extends Page {

		public Queuepage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
	
	@FindBy (xpath="//button[@class='btn']")public	WebElement  GetStarted;
	@FindBy(xpath = "//a[normalize-space()='Sign in']") public WebElement signin;
	@FindBy(xpath = "//input[@id='id_username']") public WebElement username;
	@FindBy(xpath = "//input[@id='id_password']")public WebElement password;
	@FindBy(xpath ="//input[@value='Login']")public WebElement login;
	@FindBy(xpath = "//*//a[contains(text(), 'Data Structures')]")WebElement dropdown;
	@FindBy(xpath = "//a[normalize-space()='Queue']")WebElement dropdown_queue;
	@FindBy(xpath="//a[normalize-space()='Implementation of Queue in Python']") WebElement ImplementationofQueueinPython  ;
	@FindBy(xpath="//a[@href='implementation-collections']")WebElement Implementationusingcollectionsdeque;
	@FindBy(xpath="//a[@href='Implementation-array']")WebElement Implementationusingarray;
	@FindBy(xpath="//a[@href='QueueOp']")WebElement QueueOperations;
	@FindBy(xpath="//a[@href='queue/practice']")WebElement PracticeQuestionsLink;
	@FindBy(xpath="//a[@href='tryEditor']")WebElement Tryherebtn;
    @FindBy(xpath="//textarea[@tabindex='0']")WebElement  tryhere  ;
	@FindBy(xpath = "//*[@id='answer_form']/button")WebElement runButton;

	public void GetStarted () {
		Allure.step(" Clicked Get Started Link");	
		GetStarted.click();
			}
	
	
	public void signin()  {
		Allure.step("Clicked Signin Link");
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
	public void dropdown_queue() {
			dropdown.click();
			dropdown_queue.click();
			}	
	public Queuepage ImplementationofQueueinPythonlink() {
		Allure.step("Click ImplementationofQueueinPython Link");
		ImplementationofQueueinPython.click();
		return this;
		}
	
		
	public Queuepage Implementationusingcollectionsdequelink() { 
		Allure.step("Implementationusingcollectionsdeque Link");
			Implementationusingcollectionsdeque.click();
			return this;
			}
			
			
	public Queuepage Implementationusingarraylink() {
		Allure.step("Implementationusingarray Link");
			Implementationusingarray.click();
			return this;
			}
			
	public Queuepage QueueOperationslink() {
		Allure.step("QueueOperations Link");
			QueueOperations.click();
			return this;
			}
	/*/public void PracticeQuestionsLinklink() {
			PracticeQuestionsLink.click();
			}*/
	public void clicktryherebtn() {
		Allure.step("Click Tryherebutton");
			(Tryherebtn).click();
		   }
		
	public void clickRunnbutton() {
		Allure.step("click Run button");
			(runButton).click();

		}	
	public void sendPythonCode(String code) {
		Allure.step	("sendPythonCode");
			//(tryhere).clear();
			//ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' CodeMirror-line ']"));
			
	try {
				Thread.sleep(0000);
				(tryhere).sendKeys(code);
	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public Queuepage verifyQueuePage() {
		Allure.step("verifyQueuePage");
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty("queuepageurl"),url);
		return this;
	}
	
	public Queuepage clickLink(String String) {
		
	
	switch (String.trim()) {

	case "ImplementationofQueueinPython":
		ImplementationofQueueinPythonlink();
		
		break;
	case "Implementationusingcollectionsdeque":
		Implementationusingcollectionsdequelink();
		break;
	case "Implementationusingarray":
		Implementationusingarraylink();
		break;
	case "QueueOperations":
	    QueueOperationslink();
		break;
	}
		return this;
	
	
	
	}
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
