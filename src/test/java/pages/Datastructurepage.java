package pages;

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

public class Datastructurepage extends Page {

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement GetStarted;
	@FindBy(xpath = "//a[@href='time-complexity']")
	WebElement TimeComplexity;

	@FindBy(xpath = "//form[@id='answer_form']//button")
	WebElement Run;

	public Datastructurepage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void GetStarted_link() {

		Allure.step("Clicked Get Started Link");
		GetStarted.click();
	}

	public Datastructurepage TimeComplexity_link() {
		Allure.step("Clicked TimeComplexity Link");
		TimeComplexity.click();
		return this;
	}

	public void Run_button() {
		Allure.step("Clicked Run Button");
		Run.click();
	}

	public Datastructurepage verifyDataStructurePage() {
		LoggerLoad.logInfo("Entering Method : verifyDataStructurePage");
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty("datastructurepage"), url);
		Allure.step("Verified Datastructure Page");
		return this;
	}

	public Datastructurepage verifyTimeComplexityPage() {
		LoggerLoad.logInfo("Entering Method : verifyTimeComplexityPage ");
		String url = driver.getCurrentUrl();
		LoggerLoad.logDebug("The current URL of the page is " + url);
		AssertJUnit.assertEquals(Configreader.getProperty("timecomplexity"), url);
		Allure.step("Verified TimeComplexity Page");
		return this;
	}

}
