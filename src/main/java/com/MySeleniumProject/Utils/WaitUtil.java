package com.MySeleniumProject.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class has a wait method to wait for an element to be loaded before
 * continuing.
 */

public class WaitUtil {

	/**
	 * @description: WebDriver Wait to check for title
	 * @param WebDriver
	 *            and title of the page.
	 */
	public static void waitForTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * @description: WebDriver Wait for element to display
	 * @param WebDriver
	 *            and WebElement instance.
	 */
	public static void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * @description: WebDriver Wait for element to display
	 * @param WebDriver
	 *            and WebElement instance.
	 */
	public static void waitForElementVisibility(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * @description: WebDriver Wait for element to click
	 * @param WebDriver
	 *            and WebElement instance.
	 */

	public static void waitForElementToClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * @description :Wait for the element to get displayed with a time duration
	 *              for each iteration
	 * @param element
	 * @param waitTimeForEachItertaion
	 */
	public static void waitForElementToDisplay(WebElement element, int waitTimeForEachItertaion) {
		for (int waitForElement = 0; waitForElement < 100; waitForElement++) {
			try {
				if (element.isDisplayed() || element.isEnabled()) {
					break;
				}
			} catch (Exception e) {
				try {
					Thread.sleep(waitTimeForEachItertaion);
				} catch (InterruptedException e1) {
				}
			}
		}
	}

	/**
	 * @description: WebDriver Wait to check for presence of element
	 * @param WebDriver
	 *            and By instance
	 */
	public static void waitForPresenceOfElement(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
}
