package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import io.qameta.allure.Allure;
import pages.Homepage;
import pages.StartPage;

import utils.Configreader;
import utils.LoggerLoad;




public class Home_TC extends Base {
	Homepage homepage;
	StartPage startpage;
	
	
	
	
	
	
	@BeforeTest
	public void setData() {
		this.fileName = "Homepage";

		this.testAuthor = "group4";
		this.testCategory = "Regression";
		startpage = new StartPage(driver);
	
	}

	@Test()
	public void testCase001()  {
		LoggerLoad.logInfo("Entering Method : Home_TC.testCase001");
		// chromedriver.navigate().to(homePageUrl);
		homepage = startpage.openDsAlgoPage()
		         .clickGetStarted()
		         .verifyHomePage();
		LoggerLoad.logInfo("Exiting Method : Home_TC.testCase001" );
		
	}	
	
	
	@Test(dataProvider="fetchDataForMethodName")
	public void testCase002(String elementName) {
		LoggerLoad.logInfo("Entering Method : Home_TC.testCase002()");
		Allure.step("opening home page ");
		// chromedriver.navigate().to(homePageUrl);
		homepage.openHomePage()
		        .dropdownclick(elementName)
		        .verifyErrorMessage();
		Allure.step("clicking dropdown button without login");
		Allure.step("verifying error message");
		LoggerLoad.logInfo("Exiting Method : Home_TC.testCase002()");
	}
	

	@Test(dataProvider="fetchDataForMethodName")
	public void testCase003(String elementName) {
		LoggerLoad.logInfo("Entering Method : Home_TC.testCase003()");
		// chromedriver.navigate().to(homePageUrl)
		Allure.step("opening home page ");
		
		homepage.openHomePage()
		        .getstartedclick(elementName)
		        .verifyErrorMessage();
		Allure.step("clicking getstarted button without login");
		Allure.step("verifying error message");
		LoggerLoad.logInfo("Exiting Method : Home_TC.testCase003()");
	}
	
	   
		@Test()
		public void testCase004() {
			LoggerLoad.logInfo("Entering Method : Home_TC.testCase004()");
			// chromedriver.navigate().to(homePageUrl)
			Allure.step("opening home page ");
			homepage.openHomePage()
	               .signinlink()
	               .verifyLoginpage();
			Allure.step("opening login page");
			Allure.step("verifying login page");
			LoggerLoad.logInfo("Exiting Method : Home_TC.testCase004()");
		}
		
		@Test()
		public void testCase005() throws IOException {
			LoggerLoad.logInfo("Entering Method :Home_TC.testCase005()");
			// chromedriver.navigate().to(homePageUrl);
			Allure.step("opening home page ");
			homepage.openHomePage()
			         .clickregisterbtn()
			         .verifyRegisterPage();
			Allure.step("opening register page");
			Allure.step("verifying register page");
	      
			LoggerLoad.logInfo("Exiting Method :Home_TC.testCase005()");
		}
		
}
