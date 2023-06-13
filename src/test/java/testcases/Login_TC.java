package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import base.Base;
import io.qameta.allure.Allure;
import pages.Homepage;
import pages.Loginpage;
import pages.StartPage;
import utils.Configreader;
import utils.LoggerLoad;

public class Login_TC extends Base {

	Loginpage loginpage;

	@BeforeTest
	public void setUp() {
		this.fileName = "Login";
		this.testName  ="login";
		this.testDescription="login";
		this.testAuthor = "group4";
		this.testCategory = "Login";
		loginpage = new Loginpage(driver);
		
		
	}
	@BeforeMethod
	public void setData() {
		
	}

	@Test
	public void validateRegisterPage() {
		LoggerLoad.logInfo("Entering Method : Login_TC.001");
		try {
			loginpage.opensSigninPage().register().verifyRegisterPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LoggerLoad.logInfo("Exiting Method :Login_TC.001");

	}

	@Test(dataProvider = "fetchData")
	public void validateLoginPage(String testcaseNo, String userName, String password, String message)
			throws InterruptedException, IOException {
		this.testName = "testCase002";
		this.testDesc = "testCase002";
		LoggerLoad.logInfo("Entering Method :Login_TC.002 ");
		try {
			loginpage.opensSigninPage()
					.enterUsername(userName)
					.enterPassword(password)
					.clickLoginButton()
					.verifyHomePage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AssertJUnit.assertTrue(true);
		}
		
		
		LoggerLoad.logInfo("Exiting Method :  Login_TC.002");
		
	}

	@Test()
	public void validateLogOut() {
		LoggerLoad.logInfo("Entering Method : Login_TC.003");
		try {
			loginpage.opensSigninPage()
					 .enterUsername(Configreader.getProperty("userName"))
					.enterPassword(Configreader.getProperty("passWord"))
					.clickLoginButton()
					.verifyHomePage()
					.logout();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AssertJUnit.assertTrue(true);
		}
		Allure.step("verifying signout link");
		LoggerLoad.logInfo("Exiting Method :Login_TC.003");

	}

}
