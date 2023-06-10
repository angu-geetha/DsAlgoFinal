package testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import base.Page;
import pages.Loginpage;
import pages.StartPage;
import pages.Arraypage;
import utils.Configreader;
import utils.LoggerLoad;

public class Array_Practice_TC extends Base{
	
	Arraypage arraypage; 
	Loginpage loginpage;

	@BeforeTest
	public void setData() throws InterruptedException, IOException, Exception {
		this.fileName = "Array_Practice";
		this.testAuthor = "group4";
		this.testCategory = "Regression";
		
	}
		
	@BeforeMethod
	public void setupData() throws Exception{
		
	loginpage= new Loginpage(driver);
	 try {
		 arraypage= loginpage.opensSigninPage()
			         .enterUsername(Configreader.getProperty("userName"))
			         .enterPassword(Configreader.getProperty("passWord"))
			         .clickLoginButton()
			         .verifyHomePage()
			         .clickArraypageDropDown();
			         
		} catch (InterruptedException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider="fetchData")
	public void ts001(String testCaseNo, String pythodCode , String message) {
		LoggerLoad.logInfo("Entering Method : open home page" );
		arraypage.verifyArrayPage()
		.clickbasicOperationListinPython()
		.clickpracticeButton()
		.verifyPracticePage()
		.clickLinkPractise(testCaseNo)
		.sendPythonCode(pythodCode)
		.submitCode()
		.verifyresult(message);	
	
		LoggerLoad.logInfo("Exiting Method : Data Structure Introduction page " );
	}

}
