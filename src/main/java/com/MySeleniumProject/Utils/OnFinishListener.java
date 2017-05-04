package com.MySeleniumProject.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class OnFinishListener implements ITestListener {

	WebDriver driver = null;
	String filePath = "C:\\Screenshots\\";

	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		String testClassName = getTestClassName(result.getInstanceName()).trim();
		String methodName = result.getName().toString().trim();
		takeScreenShot(testClassName, methodName);

	}

	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}

	public void takeScreenShot(String className, String methodName) {
		// get the driver
		driver = TestsBaseSetUP.getDriver();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in c drive with test
		// method name
		try {
			File file = new File(filePath +className+"\\"+methodName + ".png" + "\\");
			if (!file.exists()) {
				System.out.println("File created " + file);
				//file.createNewFile();
				file.getParentFile().mkdir();
			}

			FileUtils.copyFile(scrFile, file);

			// FileUtils.copyFile(scrFile, new File(filePath));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
