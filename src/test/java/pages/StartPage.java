package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import base.Base;
import base.Page;
import io.qameta.allure.Allure;
import utils.Configreader;
import utils.LoggerLoad;



public class StartPage extends Page {
	
	final String dsalgoPageUrl = Configreader.getProperty("url"); ;
	
	@FindBy(xpath = "//button[text()='Get Started']") WebElement GetStarted;
	//By getStartedButton = By.xpath("//button[text()='Get Started']");
	
	public StartPage(WebDriver inputdriver) {
		super(inputdriver);
		PageFactory.initElements(driver, this);
	}
	

	public StartPage openDsAlgoPage() {
		LoggerLoad.logInfo("Entering Method : openDsAlgoPage");
		LoggerLoad.logDebug("The Home page URL is "+ dsalgoPageUrl);
		driver.get(dsalgoPageUrl);
		LoggerLoad.logInfo("Exiting Method : openDsAlgoPage");
		Allure.step("Opened Dsalgo page");
		return this;
		
	}
	public Homepage clickGetStarted() {
		LoggerLoad.logInfo("Entering Method : clickGetStarted" );
		GetStarted.click();
		LoggerLoad.logInfo("Exiting Method : clickGetStarted" );
		Allure.step("Clicked getstarted button");
		return new Homepage(driver);
	}
	
	

}
