package com.MySeleniumProject.Pages;

import org.openqa.selenium.By;
//google home page web elements and methods to perform actions
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.MySeleniumProject.Utils.BaseUtils;
import com.MySeleniumProject.Utils.WaitUtil;

public class GoogleHomePage {

	private WebDriver driver;

	@FindBy(id = "lst-ib")
	private WebElement searchBox;
	@CacheLookup

	@FindBy(name = "btnG")
	private WebElement searchButton;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	@FindBy(xpath = " //a[@class='gb_b gb_cb gb_R']")
	private WebElement accountLoggedInButton;
	
	@FindBy(id="signout")
	private WebElement signOutButton;
	


	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
		// Wait 20 Second To Find Element If Element Is Not Present
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	/*
	 * Method does the google search using search term which is passed as
	 * parameter
	 */
	public GoogleSearchPage doSearch(String searchTerm) {
		// setWebElementAtribute set the value to attribute.if text box is
		// masked this will enable it.
		WaitUtil.waitForPresenceOfElement(driver, By.id("sb_ifc0"));
		// some problem with this setWebElementAttribute method,it is not
		// working
		// BaseUtils.setWebElementAttribute(searchBox, "value", "");
		BaseUtils.setInput(searchBox, searchTerm);
		searchButton.click();
		return new GoogleSearchPage(driver);

	}

	// Method gets the title of the page
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	/*Click on Sign In link on google page
	@return Google sign in page*/
	public GoogleSignInPage clickOnSignIn(){
		signInLink.click();
		return new GoogleSignInPage(driver);
	}
	
	public String getAccountLoggedInTitle(){
		WaitUtil.waitForVisibilityOfElement(driver, accountLoggedInButton);
		String accountLoggedInTitle = accountLoggedInButton.getAttribute("title");
		return accountLoggedInTitle;
	}
	
	public void googleAccountSignOut(){
		BaseUtils.clickElement(driver, accountLoggedInButton);
		WaitUtil.waitForVisibilityOfElement(driver, signOutButton);
		BaseUtils.clickElement(driver, signOutButton);
	}
	
	public boolean isSignInButtonDisplayed(){
		WaitUtil.waitForVisibilityOfElement(driver, signInLink);
		boolean signInButtonDispalyed = signInLink.isDisplayed();
		return signInButtonDispalyed;
	}
      
}
