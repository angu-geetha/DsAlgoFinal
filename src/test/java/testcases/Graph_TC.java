package testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.Loginpage;
import pages.Graphpage;
import pages.Homepage;
import utils.Configreader;
import utils.LoggerLoad;

public class Graph_TC extends Base{

	
	Graphpage graphpage; 
	Loginpage loginpage;
	Homepage homepage;

	@BeforeTest
	public void setup() throws InterruptedException, IOException, Exception {
		this.fileName = "Graph";
		this.testAuthor = "group4";
		this.testCategory = "Regression";
		
	}
		
	@BeforeMethod
	public void setupData() throws Exception{
		
	loginpage= new Loginpage(driver);
	homepage = new Homepage(driver);
	 try {
		 if(loginpage.isLoggedIn()) {
			 graphpage =   homepage.openHomePage()
					                .verifyHomePage()
					                .clickGraphpageDropDown();
			 
		 } else {
		 graphpage= loginpage.login()
			         .verifyHomePage()
			         .clickGraphpageDropDown();
			         
		 }
		 } catch (InterruptedException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider="fetchData")
	public void validateGraphPage(String testCaseNo, String pythodCode , String message) throws InterruptedException
	{
		LoggerLoad.logInfo("Entering Method : open home page" );
		
		graphpage.verifyGraphPage()
		.clickLink(testCaseNo)
		.Tryhere_button()
		.verifyTryEditorPage()
		.sendPythonCode(pythodCode)
		.Run_button()
		.verifyresult(message);
		
		LoggerLoad.logInfo("Exiting Method : Data Structure Introduction page " );
	}
	
	@Test()
	public void validateGraphPractice() {
		LoggerLoad.logInfo("Entering Method : open home page" );
		this.testName = "graphpracticepage";
		graphpage.clickgraph()
		.clickpracticeButton()
		.verifyPracticePage(this.testName);
		LoggerLoad.logInfo("Exiting Method : Data Structure Introduction page " );
	}

}
