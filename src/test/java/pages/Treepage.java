package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import base.Page;
import utils.Configreader;
import utils.LoggerLoad;

public class Treepage extends Page {

	public Treepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Implementation Of BST']") WebElement implementationofbstbtn;
	@FindBy(xpath = "//a[text()='Binary Search Trees']") WebElement binarysearchtreessbtn;
	@FindBy(xpath = "//a[text()='Applications of Binary trees']") WebElement applicationbinarytreessbtn;
	@FindBy(xpath = "//a[text()='Implementation of Binary Trees']") WebElement implementationbinarytreessbtn;
	@FindBy(xpath = "//a[text()='Binary Tree Traversals']") WebElement binarytreetraversalsbtn;
	@FindBy(xpath = "//a[text()='Implementation in Python']") WebElement implementationsbtn;
	@FindBy(xpath = "//a[text()='Types of Binary Trees']") WebElement typesofbinarytreesbtn;
	@FindBy(xpath = "//a[text()='Binary Trees']") WebElement binarytreesbtn;
	@FindBy(xpath = "//a[text()='Traversals-Illustration']") WebElement traversalsillustrationbtn;
	@FindBy(xpath = "//a[text()='Tree Traversals']") WebElement treetraversalsbtn;
	@FindBy(xpath = "//a[text()='Types of Trees']") WebElement typesoftreesbtn;
	@FindBy(xpath = "//a[text()='Terminologies']") WebElement terminologiesbtn;
	@FindBy(xpath = "//div[@class='code-area']/div/pre") WebElement runresult;
	@FindBy(xpath = "//textarea[@tabindex='0']") WebElement tryhere;
	//@FindBy(xpath = "//div[@class='input']//div[1]/div/textarea") WebElement tryhere;
	//@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea") WebElement tryhere;
	@FindBy(xpath = "//button[contains(text(),'Run')]") WebElement runbutton;
	@FindBy(xpath = "//a[text()='Try here>>>']") WebElement tryherebtn;
	@FindBy(xpath = "//div[@id='navbarCollapse']//a[contains(text(),'Data Structures')]") WebElement dropdownbtn;
	
	@FindBy(xpath = "//input[@id='id_username']") WebElement Usernamebtn;
	@FindBy(xpath = "//input[@id='id_password']") WebElement Passwotdbtn;
	@FindBy(xpath = "//input[@value='Login']") WebElement loginbtn;
	
	@FindBy(xpath ="//a[text()='Tree']") WebElement treedropdownbtn;
	
	@FindBy(xpath ="//a[text()='Overview of Trees']") WebElement overviewtreebtn;
	@FindBy(xpath = "//a[text()='Practice Questions']") WebElement practicebtn;
	
	
	
	
	public void opensSigninPage() {

	//driver.navigate().to(loginpageurl);

	}
	
	

	public void inputusername(String name) {

		(Usernamebtn).sendKeys(name);

	}
	public void sendpassword(String password) {

		(Passwotdbtn).sendKeys(password);

	}
	public void clickLoginButton() {

		(loginbtn).click();

	}
	
	
	
	public void clickTreeDropdownButton() {

		(treedropdownbtn).click();

	}
	
	
	
	public void clickDropdownButton() {

		(dropdownbtn).click();

	}
	
	
	public Treepage clickTreeOverviewButton() {

		(overviewtreebtn).click();
		return this;

	}
	

	public void clicktryherebtn() {

		(tryherebtn).click();

	}
	public void clickRunnbutton() {

		(runbutton).click();

	}
public void sendPythonCode(String code) {
		
		//(tryhere).clear();
		//ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' CodeMirror-line ']"));
		
		try {
			Thread.sleep(3000);
			(tryhere).sendKeys(code);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
public Treepage clickTypesofTrees() {

	 typesoftreesbtn.click();
	return this;

}
	
	
	


public Treepage clickTermonoligies() {

	terminologiesbtn.click();
	return this;

}
public Treepage clickTreeTraversals() {

	treetraversalsbtn.click();
	return this;

}
public Treepage clickTraversalsIllustration() {

	traversalsillustrationbtn.click();
	return this;

}
public Treepage clickBinaryTrees() {

	 binarytreesbtn.click();
	return this;

}
public Treepage clicKTypesofBinaryTrees() {

	 typesofbinarytreesbtn.click();
	return this;

}
public Treepage clicKImplementationinPython() {

	 implementationsbtn.click();
	return this;

}
public Treepage clicKBinaryTreeTraversals() {

	binarytreetraversalsbtn.click();
	return this;

}
public Treepage clickImplementationofBinaryTrees() {

	 implementationbinarytreessbtn.click();
	return this;

}

public Treepage clickApplicationofBinaryTrees() {

	applicationbinarytreessbtn.click();
	return this;

}
public Treepage clickBinarySearchTrees() {

	binarysearchtreessbtn.click();
	return this;

}
public Treepage clickImplementationofBST() {
	
	 implementationofbstbtn.click();
	return this;

}

public Treepage clickLink(String String) {

	

	switch (String) {

	case "OverviewofTrees":
		clickTreeOverviewButton();
		
		break;
	case "Terminologies":
		clickTermonoligies();
		break;
	case "TypesofTrees":
		clickTypesofTrees();
		break;
	case "TreeTraversals":
	    clickTreeTraversals();
		break;
	case "TraversalsIllustration":
		clickTraversalsIllustration();
		break;
	case "BinaryTrees":
		clickBinaryTrees();
	case "TypesofBinaryTrees":
		clicKTypesofBinaryTrees();
		break;
	case "ImplementationinPython":
		clicKImplementationinPython();
		break;
	case "BinaryTreeTraversals":
	    clicKBinaryTreeTraversals();
		break;
	case "ImplementationofBinaryTrees":
		clickImplementationofBinaryTrees();
		break;
	case "ApplicationsofBinaryTrees":
		clickApplicationofBinaryTrees();
	case "BinarySearchTrees":
		clickBinarySearchTrees();
		break;
	case "ImplemetationofBST":
		clickImplementationofBST();
		break;
	}
	return this;
}

public Treepage verifyTreePage() {
	String url = driver.getCurrentUrl();
	LoggerLoad.logDebug("The current URL of the page is " + url);
	AssertJUnit.assertEquals(Configreader.getProperty("treepageurl"),url);
	return this;
}
}
