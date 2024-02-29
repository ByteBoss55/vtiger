package com.vtiger.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Handling {
  public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
		    WebDriver driver= new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.get("http://localhost:100");
		    driver.findElement(By.name("user_name")).sendKeys("admin");
		    driver.findElement(By.name("user_password")).sendKeys("admin");
		    driver.findElement(By.name("Login")).click();
		    driver.findElement(By.linkText("New Lead")).click();
		    driver.findElement(By.name("button")).click();
		    Alert at = driver.switchTo().alert();
		    System.out.println(at.getText());
		    at.accept();
		    driver.findElement(By.name("lastname")).sendKeys("modi");
		    driver.findElement(By.name("company")).sendKeys("afd");
		}
}
