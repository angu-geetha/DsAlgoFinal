package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import utils.Configreader;
import utils.ExcelReader;

public class Base {
	public WebDriver driver; // null
	public String fileName;
	public Properties prop;
	public String testName, testDesc, testAuthor, testCategory;

	@BeforeSuite
	public void startReport(ITestContext context) throws IOException {
		// System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(); // later change for cross browser here
		context.setAttribute("WebDriver", driver);
		Configreader.loadProperty();
		driver.get(Configreader.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

	}

	public String getMethodName() {
		StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace();
		return stackTraceElements[0].getMethodName();

		// return Thread.currentThread().getStackTrace()[1].getMethodName() ;
	}

	@DataProvider(name = "fetchData")
	public String[][] fetchData() throws IOException {
		return ExcelReader.readRegisterData(fileName);

	}

	@DataProvider(name = "fetchDataForMethodName")

	public String[][] fetchDataForMethodName(Method m) throws IOException {

		return ExcelReader.readRegisterData(fileName + "_" + m.getName());

	}
	
	@AfterSuite
	public void afterSuite() throws IOException {
		driver.close();
		//driver.quit();

	}

}
