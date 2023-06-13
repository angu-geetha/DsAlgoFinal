package testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.Homepage;
import pages.Loginpage;
import pages.Stackpage;
import utils.Configreader;
import utils.LoggerLoad;

public class Stack_TC extends Base {
	Stackpage stackpage;
	Homepage homepage;
	Loginpage loginpage;
	
	@BeforeTest
	public void setData() throws InterruptedException, IOException, Exception {
		this.fileName = "Stackpage";

		this.testAuthor = "group4";
		this.testCategory = "Regression";
		
	}
		
	@BeforeMethod
	public void setupData() throws Exception{
		
	loginpage= new Loginpage(driver);
	homepage =  new Homepage(driver);
	 try {
		 
		 if(loginpage.isLoggedIn()) {
			 stackpage =   homepage.openHomePage()
					                .verifyHomePage()
					                .clickStackpageDropDown();
			 
		 } else {
		 stackpage= loginpage.opensSigninPage()
			         .enterUsername(Configreader.getProperty("userName"))
			    
			         .enterPassword(Configreader.getProperty("passWord"))
			         .clickLoginButton()
			         .verifyHomePage()
			         .clickStackpageDropDown();
			         
		} 
	 }catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
}
	@Test(dataProvider="fetchData")
	public void validateStackPage(String Link, String pythonCode , String message) throws InterruptedException
	{
		LoggerLoad.logInfo("Entering Method : open home page" );
		
	    stackpage.verifStackPage()
		.clickLink(Link)
		.Tryhere_button()
		.verifyTryEditorPage()
		.sendPythonCode(pythonCode)
		.Run_button()
		.verifyresult(message);
		
		
		LoggerLoad.logInfo("Exiting Method : Data Structure Introduction page " );
	}
}


