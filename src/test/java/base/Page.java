package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Allure;
import pages.Practicepage;
import pages.Tryeditorpage;

public class Page  extends  Base{
	
	
	protected WebDriver driver;
	
	public Page(WebDriver inputdriver) {
		this.driver = inputdriver;
		PageFactory.initElements(driver, this);

	}
	
	
	
	
	@FindBy(xpath = "//a[text()='Practice Questions']") WebElement practicebtn;

	@FindBy(xpath = "//a[@class='btn btn-info']")
	 WebElement Tryhere;
	
	  public Tryeditorpage Tryhere_button() {
			
		   Allure.step("Clicked Try here Button");
		   Tryhere.click();
		   return new Tryeditorpage(driver);
	      }
	  

		public Practicepage clickpracticeButton() {
			Allure.step("Clicked Practice Question  Link");
			(practicebtn).click();
			return new Practicepage(driver);
		}
		
		
	  
	  
	  
	  
	
}
