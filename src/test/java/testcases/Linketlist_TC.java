package testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import base.Page;
import pages.Linkedlistpage;
import pages.Loginpage;
import pages.Tryeditorpage;
import utils.Configreader;
import utils.LoggerLoad;




public class Linketlist_TC extends Base {

	Loginpage loginpage;
	Linkedlistpage linkedlist;
	
	
	@BeforeTest
	public void setData() throws InterruptedException, IOException, Exception {
		this.fileName = "LinkedlistPage";

		this.testAuthor = "group4";
		this.testCategory = "Regression";
		
		
		
	}
	
	
	@BeforeMethod
	public void setupData() throws Exception {
		LoggerLoad.logInfo("Entering Before Method Linkedlist_TC ");
		loginpage= new Loginpage(driver);
		 try {
			 linkedlist = loginpage.opensSigninPage()
				         .enterUsername(Configreader.getProperty("userName"))
				    
				         .enterPassword(Configreader.getProperty("passWord"))
				         .clickLoginButton()
				         .verifyHomePage()
				         .clickLinkedList();
				         
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 LoggerLoad.logInfo("Exiting Before Method Linkedlist_TC");
	}
	
	

	@Test(dataProvider="fetchData")
	public void ts001(String testCaseNo, String pythodCode , String message) throws InterruptedException
	{
		LoggerLoad.logInfo("Entering Method : Linkedlist_TC.ts001" );
		
		linkedlist.verifyLinkedListPage()
		.clickLink(testCaseNo)
		.Tryhere_button()
		.verifyTryEditorPage()
		.sendPythonCode(pythodCode)
		.Run_button()
		.verifyresult(message);
		
		
		
		
		
		
		LoggerLoad.logInfo("Exiting Method : Linkedlist_TC.ts001 " );
	}
	
	@Test()
	public void ts002() {
		LoggerLoad.logInfo("Entering Method :Linkedlist_TC.ts002" );
		
		this.testName = "linkedlistpracticequestionpage";
		
		linkedlist.clickintroductionbtn()
		.clickpracticeButton()
		.verifyPracticePage(this.testName);
	
	    
	
		LoggerLoad.logInfo("Exiting Method :Linkedlist_TC.ts002 " );
	}

	
	
}
