package com.MySeleniumProject.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.os.WindowsUtils;

//Basic utility class 

public class BaseUtils {
	// protected WebDriver driver;

	/*
	 * Utility method uses java script executor to set web element attribute
	 * value example: for a masked text box, sendKeys() method may not work well
	 * and setting the value of the text box will overcome this issue
	 */
	public static void setWebElementAttribute(WebElement element, String attributeName, String value) {
		// not working throwing error while wrapping webelement
		WrapsDriver wrappedElement = (WrapsDriver) element;
		JavascriptExecutor jsDriver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
		jsDriver.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attributeName, value);
	}

	/*
	 * Utility method to scroll to bottom of the page and then perform
	 * operations
	 */

	public void scrollingToBottomofAPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/*
	 * Utility method to scroll to particular element
	 */
	public void scrollingToElementofAPage(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	/*
	 * Utility method use the coordinates to scroll to particular position by
	 * passing the coordinates
	 */
	public void scrollingByCoordinatesofAPage(WebDriver driver, int coordinateX, int CoordinateY) {
		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollBy(0,500)");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(coordinateX,CoordinateY)");
	}

	/**
	 * @description:Sets the input text after the element is displayed
	 */
	public static void setInput(WebElement element, String value) {
		// WaitUtil.waitForElementToDisplay(element);
		element.click();
		element.clear();
		if (value != null) {
			element.sendKeys(value);
		}
	}

	/**
	 * @description:Clicks on a web element after element is displayed
	 */
	public static void clickElement(WebDriver driver, WebElement element) {
		WaitUtil.waitForElementToClick(driver, element);
		element.click();
	}

	/**
	 * @description:Double clicks on an element
	 */
	public static void doubleClickElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick(element).perform();
	}

	/**
	 * @description:Deletes the cookies cache and refresh the page
	 */
	public static void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	/**
	 * @description:Kills the driver.exe process running 
	 */
	public static void killBackgroundProcesses(String driverExe){
		//if(webDriverException.getMessage().contains("org.openqa.selenium.WebDriverException: Error communicating with the remote browser. It may have died"){
		      // Kill IEDriverServer.exe process
		      // Using WebDriver WindowUtils utility 
		      WindowsUtils.killByName(driverExe);

		      // Or using JavaRunTime
		    // Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe")

	}

	/**
	   * @description:Clicks on a web element using Java Script Executor after element is displayed
	   */
	  public static void clickElementUsingJavaScript(WebElement element,WebDriver driver) {
	    WaitUtil.waitForVisibilityOfElement(driver, element);;
	    JavascriptExecutor executor =( (JavascriptExecutor)driver);
	    executor.executeScript("arguments[0].click();", element);
	  }
}


