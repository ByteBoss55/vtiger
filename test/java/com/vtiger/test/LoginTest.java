package com.vtiger.test;

import java.time.Duration;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.page.HomePage;
import com.vtiger.page.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public WebDriver driver;
	public ExtentTest Logger;
	@BeforeTest
	public void LaunchApp() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("http://localhost:100");
	}
	@Test
	public void verifyLoginTC01() {
		
		
		LoginPage lp = new LoginPage(driver, Logger);
		lp.login("admin", "admin", "orange");
		HomePage hp = new HomePage(driver);		
		Assert.assertEquals(true,hp.verifyLogout());
	}
	
}
