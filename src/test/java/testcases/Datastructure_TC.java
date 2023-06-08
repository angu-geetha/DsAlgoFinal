package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import io.qameta.allure.Allure;
import pages.Datastructurepage;
import pages.Homepage;
import pages.Loginpage;
import pages.Tryeditorpage;
import utils.Configreader;
import utils.LoggerLoad;

public class Datastructure_TC extends Base {

	Datastructurepage dspage;
	Loginpage loginpage;

	
	@BeforeTest
	public void setUp() throws InterruptedException, IOException , Exception{
		this.fileName = "DataStructure";
		this.testAuthor = "group4";
		this.testCategory = "Datastructure";
		}
		
		@BeforeMethod
		public void setUpdata() throws  Exception{
		LoggerLoad.logInfo("Entering Before Method DataStructure_TC ");
		loginpage = new Loginpage(driver);

		
			dspage = loginpage.opensSigninPage().enterUsername(Configreader.getProperty("userName"))

					.enterPassword(Configreader.getProperty("passWord"))
					.clickLoginButton()
					.verifyHomePage()
					.clickDataStucture();
			LoggerLoad.logInfo("Exiting Before Method DataStructure_TC");
		}
		

		// driver.get(Configreader.getProperty("datastructurepage"));

	

	@Test(dataProvider = "fetchData")
	public void ts001(String testCaseNo, String pythodCode, String message) throws InterruptedException {
		LoggerLoad.logInfo("Entering Method :DataStructure_TC.ts001");

		dspage.verifyDataStructurePage()
			  .TimeComplexity_link()
			  .verifyTimeComplexityPage()
			  .Tryhere_button()
			   .verifyTryEditorPage().
			   sendPythonCode(pythodCode)
			   .Run_button().
			   verifyresult(message);
		LoggerLoad.logInfo("Exiting Method :DataStructure_TC.ts001 ");
	}

}
