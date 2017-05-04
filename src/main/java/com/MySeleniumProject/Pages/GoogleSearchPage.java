package com.MySeleniumProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.MySeleniumProject.Utils.WaitUtil;

//Google search results page.Shows the search results based on search term
public class GoogleSearchPage {

	private WebDriver driver;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
		// Wait 20 Second To Find Element If Element Is Not Present
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	// Method gets the title of the page
	public String getPageTitle() {
		WaitUtil.waitForElementVisibility(driver, By.id("brs"));
		String title = driver.getTitle();
		return title;
	}
}
