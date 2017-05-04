package com.MySeleniumProject.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//Class does the initial base setup before tests execution like setting browser ,loading application etc
public class TestsBaseSetUP {
	private static WebDriver driver;
	static String driverPath = "C:\\My Dude\\";

	private enum Browser {
		CHROME, FIREFOX;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) {
		Browser browser = Browser.valueOf(browserType);
		switch (browser) {
		case CHROME:
			driver = initChromeDriver(appURL);
			break;
		case FIREFOX:
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver(chromeCapabilities);
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}

	@Parameters({ "browserType", "appURL" })
	// @BeforeClass
	@BeforeMethod
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);
			// driver = getDriver();

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
		// return driver;

	}

	//@AfterClass(alwaysRun = true)
	@AfterMethod
	public void tearDown() {
		if (driver != null)
			//driver.close();
		 driver.quit();
	}
}
