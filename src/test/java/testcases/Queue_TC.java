 package testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.Homepage;
import pages.Loginpage;
import pages.Queuepage;
import utils.Configreader;
import utils.LoggerLoad;

public class Queue_TC extends Base{

	Queuepage queuepage;
	Homepage homepage;
	Loginpage loginpage;
	
	@BeforeTest
	public void setData() throws InterruptedException, IOException, Exception {
		this.fileName = "QueuePage";

		this.testAuthor = "group4";
		this.testCategory = "Regression";
		
	}
		
	@BeforeMethod
	public void setupData() {
		
	loginpage= new Loginpage(driver);
	homepage = new Homepage(driver);
	try {
		 if(loginpage.isLoggedIn()) {
			 queuepage =   homepage.openHomePage()
					                .verifyHomePage()
					                .clickQueuepageDropDown();
			 
		 } else {
		
			queuepage= loginpage.opensSigninPage()
				         .enterUsername(Configreader.getProperty("userName"))
				    
				         .enterPassword(Configreader.getProperty("passWord"))
				         .clickLoginButton()
				         .verifyHomePage()
				         .clickQueuepageDropDown();
		
			         
		} 
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
	}
	
	@Test(dataProvider="fetchData")
	public void validateQueuePageLinks(String Link, String pythonCode , String message) throws InterruptedException
	{
		LoggerLoad.logInfo("Entering Method : open home page" );
		
		queuepage.verifyQueuePage()
		.clickLink(Link)
		.Tryhere_button()
		.verifyTryEditorPage()
		.sendPythonCode(pythonCode)
		.Run_button()
		.verifyresult(message);
		
		
		
		
		
		
		LoggerLoad.logInfo("Exiting Method : Data Structure Introduction page " );
	}
}


