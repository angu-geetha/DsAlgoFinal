package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import base.Base;
import base.Page;
import utils.Configreader;
import utils.LoggerLoad;

public class Tryeditorpage extends Page{

	public  Tryeditorpage(WebDriver driver) {
		super(driver);
		
	PageFactory.initElements(driver, this);
	
     }
	
	@CacheLookup
	
	@FindBys({
		
		@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea"),
		@FindBy(xpath = "//textarea[@tabindex='0']"),
		@FindBy(xpath = "//div[@class='input']//div[1]/div/textarea")
		
	}
	)
	WebElement textEditor;
	//@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea") WebElement textEditor;
	//@FindBy(xpath = "//textarea[@tabindex='0']") WebElement textEditor;
	//@FindBy(xpath = "//div[@class='input']//div[1]/div/textarea") WebElement textEditor;
	@FindBy(xpath = "//form[@id='answer_form']//button") WebElement Run;
	@FindBy(xpath = "//div[@class='code-area']/div/pre") WebElement runresult;
	
	
	
	
	

public Tryeditorpage sendPythonCode(String pythonCode) {
	
	JavascriptExecutor jse;
	try {
		Thread.sleep(000);
		/*jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", textEditor);*/
		new Actions(driver).sendKeys(textEditor,pythonCode).perform();
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

public Tryeditorpage Run_button() {
	
  Run.click();
	
  return this;
}

public Tryeditorpage verifyresult(String message) {

	
	
	try {
		String errormsg= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		AssertJUnit.assertEquals(message,errormsg);
		
			
		
	}catch (Exception e) {
		// TODO: handle exception
		if(runresult.isDisplayed()) {
			String result = (runresult).getText();
			if((!result.isEmpty())) {
				AssertJUnit.assertEquals(message,result);
			}
	}
	}

	
	driver.navigate().back();
	driver.navigate().back();
	
	return this;

}

public Tryeditorpage verifyTryEditorPage() {
	LoggerLoad.logInfo("Entering Method : verifyTryEditorPage" );
	String url = driver.getCurrentUrl();
	LoggerLoad.logDebug("The current URL of the page is " + url);
	AssertJUnit.assertEquals(Configreader.getProperty("tryherelinkedlistpage"),url);
	return this;
}






}
