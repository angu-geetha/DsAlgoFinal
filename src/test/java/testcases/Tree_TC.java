package testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import base.Page;
import pages.Homepage;
import pages.Loginpage;
import pages.StartPage;
import pages.Treepage;
import utils.Configreader;
import utils.LoggerLoad;

public class Tree_TC extends Base {

	Treepage treepage;
	Homepage homepage;
	Loginpage loginpage;

	@BeforeTest
	public void setData() throws InterruptedException, IOException, Exception {
		this.fileName = "TreePage";

		this.testAuthor = "group4";
		this.testCategory = "Regression";

	}

	@BeforeMethod
	public void setupData() throws Exception {

		loginpage = new Loginpage(driver);
		homepage = new Homepage(driver);
		try {

			if (loginpage.isLoggedIn()) {
				treepage = homepage.openHomePage().verifyHomePage().clickTreepage();

			} else {
				treepage = loginpage.opensSigninPage().enterUsername(Configreader.getProperty("userName"))
						.enterPassword(Configreader.getProperty("passWord")).clickLoginButton().verifyHomePage()
						.clickTreepage();

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "fetchData")
	public void ts001(String testCaseNo, String pythodCode, String message) throws InterruptedException {
		LoggerLoad.logInfo("Entering Method : open home page");

		treepage.verifyTreePage().clickLink(testCaseNo).Tryhere_button().verifyTryEditorPage()
				.sendPythonCode(pythodCode).Run_button().verifyresult(message);

		LoggerLoad.logInfo("Exiting Method : Data Structure Introduction page ");
	}

	@Test()
	public void testCase002() {
		LoggerLoad.logInfo("Entering Method : open home page");
		this.testName = "treepracticepage";
		treepage.clickTreeOverviewButton().clickpracticeButton().verifyPracticePage(this.testName);

		LoggerLoad.logInfo("Exiting Method : Data Structure Introduction page ");
	}

}
