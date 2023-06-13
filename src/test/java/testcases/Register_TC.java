package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import base.Base;
import io.qameta.allure.Allure;
import pages.Homepage;
import pages.Registerpage;
import pages.StartPage;
import utils.LoggerLoad;




import org.testng.annotations.BeforeTest;


public class Register_TC extends Base {

	StartPage startPage;
	Registerpage registerpage;
	Homepage homepage;
	

	@BeforeTest
	public void setData() {
		this.fileName = "RegisterPage";

		this.testAuthor = "group4";
		this.testCategory = "Regression";
		startPage = new StartPage(driver);
		registerpage = new Registerpage(driver);
		homepage = new Homepage(driver);
	}

	@Test
	public void validateHomePage() {
		LoggerLoad.logInfo("Entering Method :" );
		this.testName = "testCase001";
		this.testDesc = "testCase001";
		startPage.openDsAlgoPage()
				 .clickGetStarted();
			homepage.verifyHomePage();
			Allure.step("verifying Home page");
		LoggerLoad.logInfo("Exiting Method : " );
	}

	@Test(dataProvider = "fetchData")
	public void validateRegisterPage(String testcaseNo, String userName, String password, String confPsswd, String message) {
		this.testName = "testCase002";
		this.testDesc = "testCase002";
		LoggerLoad.logInfo("Entering Method : testCase002");

		registerpage.opensregisterPage()
		            .clearusername()
		            .inputusername(userName)
		            .clearpassword()
		            .sendpassword(password)
				    .clearpasswordconfirmation().sendpasswordConfirmation(confPsswd).clickRegisterbtn()
				    .validateErrorMessage(testcaseNo, message);
		Allure.step("verifying with valid and invalid usernames and passwords");
		Allure.step("verifying error message");
		LoggerLoad.logInfo("Exiting Method : " );
	}

}
