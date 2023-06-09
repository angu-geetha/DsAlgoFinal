package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Configreader;
import utils.ExcelReader;
import utils.LoggerLoad;

public class Base {
	public WebDriver driver; // null
	public String fileName;
	public Properties prop;
	public String testName, testDesc, testAuthor, testCategory, testDevice, testDescription;

	@BeforeSuite
	public void startReport(ITestContext context) throws IOException {
		
		Configreader.loadProperty();
		
		String browser = Configreader.getProperty("browser");
		if (browser.equalsIgnoreCase("firefox")) {
			LoggerLoad.logInfo("Testing on firefox");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			LoggerLoad.logInfo("Testing on chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("safari")) {
			LoggerLoad.logInfo("Testing on safari");
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else {
			LoggerLoad.logInfo("Testing on Edge");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.get(Configreader.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		//driver = new ChromeDriver(); // later change for cross browser here
		context.setAttribute("WebDriver", driver);

	}

	public String takeSnapShot(String tescaseName) throws IOException {

		TakesScreenshot srcShot = (TakesScreenshot) driver;
		File src = srcShot.getScreenshotAs(OutputType.FILE);
		String dir = "./";
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String path = dir +"src/test/resources/screenshot/" +tescaseName+"_"+timestamp+".jpeg";
		File destfile = new File(path);
		FileUtils.copyFile(src, destfile);
		path = destfile.getAbsolutePath();// c:Users/Dom/TestingProject/MyProject/snaps/photo1234.png
		return path;

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

	}

}
