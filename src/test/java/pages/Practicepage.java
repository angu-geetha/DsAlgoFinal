package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import base.Page;
import utils.Configreader;
import utils.LoggerLoad;

public class Practicepage  extends Page{

	
	
	public Practicepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = ("//a[@href='/question/1']"))
	WebElement SearchtheArray;
	
	@FindBy (xpath=("//a[@href='/question/2']"))
	WebElement maxConsecutive;
	
	@FindBy (xpath=("//a[@href='/question/3']"))
	WebElement evenNumberDigits;
	
	@FindBy (xpath=("//a[@href='/question/4']"))
	WebElement squaresOfSortedArray;
	
	
	@CacheLookup

	@FindBys({

			@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea"),
			@FindBy(xpath = "//textarea[@tabindex='0']"), @FindBy(xpath = "//div[@class='input']//div[1]/div/textarea")

	})
	WebElement practiceEditor;

	
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement output;

	public Practicepage clickSearchtheArray() {
		SearchtheArray.click();
		return this;
	}
	
	public Practicepage clickmaxConsecutive() {
		LoggerLoad.logInfo("click" + maxConsecutive.getText() + "on the array page");
		maxConsecutive.click();
		return this;
	}
	
	public Practicepage clickevenNumberDigits() {
		LoggerLoad.logInfo("click" + evenNumberDigits.getText() + "on the array page");
		evenNumberDigits.click();
		return this;
	}
	
	public Practicepage clicksquaresSorted() {
		LoggerLoad.logInfo("click" + squaresOfSortedArray.getText() + "on the array page");
		squaresOfSortedArray.click();
		return this;
	}

	public Practicepage clickLinkPractise(String String) {

		switch (String) {
		case "Searchthearraylink":
			clickSearchtheArray();
			break;
		case "MaxConsecutiveOnes":
			clickmaxConsecutive();
			break;
		case "FindEvenNumbers":
			clickevenNumberDigits();
			break;
		case "SquaresofaSortedArray":
			clicksquaresSorted();
			break;
		}
		return this;
	}

	public Practicepage submitCode() {
		LoggerLoad.logInfo("click Submit button");
		submit.click();
		return this;
	}

	public String getOutput() throws InterruptedException {
		Thread.sleep(1000);
		return output.getText();
	}
	
	public Practicepage verifyresult(String message) {

		try {
			String errormsg= driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			AssertJUnit.assertEquals(message,errormsg);
		}catch (Exception e) {
			// TODO: handle exception
			if(output.isDisplayed()) {
				String result = (output).getText();
				if((!result.isEmpty())) {
					AssertJUnit.assertEquals(message,result);
				}
		}
		}
		driver.navigate().back();
		driver.navigate().back();		
		return this;
	}
	
	public void practiseEditorBox(String typeCode) {
		practiceEditor.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), typeCode);
	}

	public void verifyPracticePage(String configKey) {
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty(configKey), url);
	}

	public Practicepage verifyPracticePage() {
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty("practicePageUrl"), url);
		return this;
	}
	
	public Practicepage sendPythonCode(String pythonCode) {
		
		JavascriptExecutor jse;
		try {
			Thread.sleep(000);
			/*jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", textEditor);*/
			new Actions(driver).sendKeys(practiceEditor,pythonCode).perform();
			//(textEditor).sendKeys(pythonCode);
			/*WebDriverWait wait= (new WebDriverWait(driver, Duration.ofMillis(2000)));
			wait.until(ExpectedConditions . elementToBeClickable (textEditor));*/
		} catch (InterruptedException e) {
			//(textEditor).sendKeys(pythonCode);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	
	
	
	
}
