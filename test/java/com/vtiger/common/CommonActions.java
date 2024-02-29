package com.vtiger.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class CommonActions {
	public WebDriver driver;
	public WebDriverWait wait;
	public static ExtentTest Logger;

	public CommonActions(WebDriver driver, ExtentTest Logger) {
		this.driver = driver;
		this.Logger = Logger;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void InputText(WebElement elm, String value, String msg) {

		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();
			elm.sendKeys(value);
			Logger.pass(msg);
		}

		catch (Exception e) {
			e.printStackTrace();
			Logger.fail("Step failed due to error :" + e.getMessage() + "<a href=" + getScreenshot()
					+ "'><span class= 'label end-time'>Screenshot</span></a>");
		}
	}

	public void SelectByIndex(WebElement elm, String value, String msg) {

		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			Select sel = new Select(elm);
			sel.selectByIndex(Integer.parseInt(value));
			// sel.getFirstSelectedOption();
			// List<WebElement>Is = sel.getOptions();
			// System.out.println(Is.size());
			Logger.pass(msg);
		}

		catch (Exception e) {
			e.printStackTrace();
			Logger.fail("Step failed due to error :" + e.getMessage() + "<a href=" + getScreenshot()
					+ "'><span class= 'label end-time'>Screenshot</span></a>");
		}
	}

	public void clickElement(WebElement elm, String msg) {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			elm.click();
			Logger.pass(msg);
		}

		catch (Exception e) {
			e.printStackTrace();
			Logger.fail("unable to click on Login button :" + e.getMessage() + "<a href=" + getScreenshot()
					+ "'><span class= 'label end-time'>Screenshot</span></a>");
		}

	}

	public void ElementExist(WebElement elm, String msg) {

		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.isDisplayed();
			Logger.pass(msg);
		}

		catch (Exception e) {
			e.printStackTrace();
			Logger.fail("element does not exist due to error :" + e.getMessage() + "<a href=" + getScreenshot()
					+ "'><span class= 'label end-time'>Screenshot</span></a>");

		}
	}

	public String getScreenshot() {
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String path = System
				.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screeenshots/image" + str + ".png";
		File DestFile = new File(path);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			e.getStackTrace();

		}
		return path;
	}
}