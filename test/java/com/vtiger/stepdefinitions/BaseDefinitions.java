package com.vtiger.stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDefinitions {

	public static Properties prop;
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static Map<String, Map<String, String>> dt;
	public static ExtentTest Logger;
	public static String TCName;

	public void initiation() {
		if (prop == null)
			prop = readproperties();
		if (extent == null)
			createExtentReport();
		if (dt == null)
			dt = Json_Reader();
	}

	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
		
	}

	public void CloseApp() {
		driver.close();
	}

	public Properties readproperties() {
		Properties prop = null;
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/settings/conf.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public Map<String, Map<String, String>> Json_Reader() {
		Map<String, Map<String, String>> userData = null;
		ObjectMapper mapper = new ObjectMapper();
		// create instance of the File class
		File fileObj = new File(System.getProperty("user.dir") + "/src/test/resources/Data/TestName.json");
		// use try-catch block to convert JSON data into Map
		try {
			// read JSON data from file using fileObj and map it using ObjectMapper and
			// TypeReference classes
			userData = mapper.readValue(fileObj, new TypeReference<Map<String, Map<String, String>>>() {
			});
			// print all key-value pairs
			System.out.println("TCName : " + userData.get("verifyInvalidLogin_TC04").get("Userid"));
			System.out.println("TCName : " + userData.get("verifyInvalidLogin_TC04").get("Password"));

		} catch (Exception e) {
			// show error message
			e.printStackTrace();
		}
		return userData;
	}

	public void createExtentReport() {
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhss");
		String filename = ft.format(d);
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport" + filename + "html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		extent.setSystemInfo("Username", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report comes here");
		htmlReporter.config().setReportName("Name of the report comes here");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

//	public String getScreenshot() {
//		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
//		Date d = new Date();
//		String str = f.format(d);
//		TakesScreenshot scrShot = ((TakesScreenshot) driver);
//		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//		String path = System
//				.getProperty("user.dir" + "/src/test/java/com/vtiger/reports/screeenshots/image" + str + ".png");
//		File DestFile = new File(path);
//		try {
//			FileUtils.copyFile(SrcFile, DestFile);
//		} catch (Exception e) {
//			e.getStackTrace();
//
//		}
//		return path;
//	}
}
