package pages;

import org.openqa.selenium.WebDriver;
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

	public void verifyPracticePage(String configKey) {
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty(configKey), url);
		
		
	}
	
	
	
	
	
}
