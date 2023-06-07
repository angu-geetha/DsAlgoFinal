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

import io.qameta.allure.Attachment;



public class TestListener implements ITestListener {
	WebDriver driver=null;
	
    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        String testClassName = getTestClassName(result.getInstanceName()).trim();

       WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
    	takeScreenShot(methodName,testClassName, driver);
    }
    
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    
   
    public void takeScreenShot(String methodName,String testClassName, WebDriver driver) {
    	
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
    }
    
    public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}
    
	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  