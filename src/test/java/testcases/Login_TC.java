package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import base.Base;
import io.qameta.allure.Allure;
import pages.Loginpage;
import utils.Configreader;
import utils.LoggerLoad;

public class Login_TC extends Base {

	Loginpage loginpage;

	@BeforeTest
	public void setUp() {
		this.fileName = "Login";

		this.testAuthor = "group4";
		this.testCategory = "Login";

		loginpage = new Loginpage(driver);

	}

	@Test
	public void testCase001() {
		LoggerLoad.logInfo("Entering Method : TC-001-Verify register Link");
		loginpage.opensSigninPage().register().verifyRegisterPage();
		Allure.step("opening register page");
		Allure.step("verifying register page");
		LoggerLoad.logInfo("Exiting Method : Register page open");

	}

	@Test(dataProvider = "fetchData")
	public void testCase002(String testcaseNo, String userName, String password, String message)
			throws InterruptedException, IOException {
		this.testName = "testCase002";
		this.testDesc = "testCase002";
		LoggerLoad.logInfo("Entering Method : TC-002-Verify login input ");
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
		Allure.step("verifying login page for valid and invalid scenarios");
		
		LoggerLoad.logInfo("Exiting Method :  HomePage  open");
		
	}

	@Test()
	public void testCase003() {
		LoggerLoad.logInfo("Entering Method : TC-003-Verify Signout Link");
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
		LoggerLoad.logInfo("Exiting Method : HomePage  open");

	}

}
