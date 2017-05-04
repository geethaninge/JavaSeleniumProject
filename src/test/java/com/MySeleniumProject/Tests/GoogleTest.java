package com.MySeleniumProject.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MySeleniumProject.Pages.GoogleHomePage;
import com.MySeleniumProject.Pages.GoogleSearchPage;
import com.MySeleniumProject.Pages.GoogleSignInPage;
import com.MySeleniumProject.Utils.RetryAnalyser;
import com.MySeleniumProject.Utils.TestsBaseSetUP;

import testData.DataProviderClass;

@Listeners(com.MySeleniumProject.Utils.OnFinishListener.class)
public class GoogleTest extends TestsBaseSetUP {
	private WebDriver driver;
	private GoogleHomePage homePage;
	private GoogleSearchPage searchPage;
	private GoogleSignInPage signInPage;

	// @BeforeClass(alwaysRun = true, dependsOnMethods =
	// "initializeTestBaseSetup")
	@BeforeMethod(alwaysRun = true, dependsOnMethods = "initializeTestBaseSetup")
	public void setUp() {
		driver = getDriver();
	}

	// retryAnalyzer, to retry failed test cases
	@Test(retryAnalyzer = RetryAnalyser.class)
	@Parameters("pageTitle")
	public void testGoogleSearchTitle(String pageTitle) {
		homePage = new GoogleHomePage(driver);
		String title = homePage.getPageTitle();
		Assert.assertEquals(title, pageTitle);
		//Assert.assertTrue(false);
	}

	// @Parameters("searchTerm")
	// @Test(dataProvider = "SearchProvider", dataProviderClass =
	// DataProviderClass.class)

	public void testGoogleSearch(String searchTerm) {
		homePage = new GoogleHomePage(driver);
		searchPage = homePage.doSearch(searchTerm);
		String title = searchPage.getPageTitle();
		Assert.assertTrue(title.contains(searchTerm));
	}

	@Parameters({ "userName", "passWord" })
	// @Test
	public void testGoogleMailLogin(String userName, String passWord) {
		homePage = new GoogleHomePage(driver);
		signInPage = homePage.clickOnSignIn();
		homePage = signInPage.googleMailLogin(userName, passWord);
		String accountTitle = homePage.getAccountLoggedInTitle();
		Assert.assertTrue(accountTitle.contains(userName));
		homePage.googleAccountSignOut();
		boolean isSignInDisplayed = homePage.isSignInButtonDisplayed();
		Assert.assertTrue(isSignInDisplayed);
	}
}
