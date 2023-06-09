package utils;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.Base;
import io.qameta.allure.Attachment;



public class TestListener implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentManager.createExtentReports();
	WebDriver driver;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest> ();
	
	
	 public void onTestStart(ITestResult result) { 
		 ITestContext context = result.getTestContext();
		driver = (WebDriver)context.getAttribute("WebDriver");
		 test =  extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	 }
	 
	 public void onTestSuccess(ITestResult result) {   
		 test.log(Status.PASS, "Test Passed");
	 }
	
	
    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	extentTest.get().fail(result.getThrowable());
    	String filePath= null;
		try {
			filePath = takeSnapShot(result.getMethod().getMethodName().trim(),getTestClassName(result.getInstanceName()).trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    	saveScreenshotPNG(driver);
    	

    }
    
    public String takeSnapShot(String tescaseName,String testClass) throws IOException {

		TakesScreenshot srcShot = (TakesScreenshot) driver;
		File src = srcShot.getScreenshotAs(OutputType.FILE);
		String dir = "./";
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String path = dir +"src/test/resources/screenshot/"+testClass+"/"+tescaseName+"_"+timestamp+".jpeg";
		File destfile = new File(path);
		FileUtils.copyFile(src, destfile);
		path = destfile.getAbsolutePath();// c:Users/Dom/TestingProject/MyProject/snaps/photo1234.png
		return path;

	}
    
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    
   
    public String takeScreenShot(String methodName,String testClassName, WebDriver driver) {
    	
    	TakesScreenshot screenshot = (TakesScreenshot)driver;
    	
    	File srcfile	=screenshot.getScreenshotAs(OutputType.FILE);
    	saveScreenshotPNG(driver);
    	
    	String dir = "./";
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    		String path = dir +"src/test/resources/screenshot/"+testClassName+"/" +methodName+"_"+timestamp+".jpeg";
    	
        File destfile = new File(path);
     	try {
    		FileUtils.copyFile(srcfile, destfile);
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
     	return path;
    }
    
    public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}
    
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
  
   
  
   

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  