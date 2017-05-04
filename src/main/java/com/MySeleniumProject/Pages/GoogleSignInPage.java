package com.MySeleniumProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.MySeleniumProject.Utils.BaseUtils;
import com.MySeleniumProject.Utils.WaitUtil;

public class GoogleSignInPage {
	private WebDriver driver;

	@FindBy(id = "Email")
	private WebElement emailId;

	@FindBy(id = "next")
	private WebElement nextButton;

	@FindBy(id = "Passwd")
	private WebElement password;

	@FindBy(id = "signIn")
	private WebElement signInButton;

	public GoogleSignInPage(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
		// Wait 20 Second To Find Element If Element Is Not Present
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	public GoogleHomePage googleMailLogin(String userName, String passWord) {
		WaitUtil.waitForVisibilityOfElement(driver, emailId);
		BaseUtils.setInput(emailId, userName);
		BaseUtils.clickElement(driver, nextButton);
		WaitUtil.waitForVisibilityOfElement(driver, password);
		BaseUtils.setInput(password, passWord);
		BaseUtils.clickElement(driver, signInButton);
		return new GoogleHomePage(driver);
	}
}
