package com.vtiger.stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.vtiger.page.HomePage;
import com.vtiger.page.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginstepdefinitions extends BaseDefinitions {
	public WebDriver driver;
	public LoginPage lp;
	public HomePage hp;

	@Before
	public void getScenarioName(Scenario scenario) {
		initiation();
	    TCName = scenario.getName();
		Logger = extent.createTest(TCName);

	}

	@After
	public void tierDown() {
		extent.flush();
		driver.quit();
	}

	@Given("user should on be login page")
	public void user_should_on_be_login_page() {
		launchApp();
		lp = new LoginPage(driver, Logger);
		hp = new HomePage(driver);
	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {
		lp.SetuserName(dt.get(TCName).get("Userid"));
		lp.SetuserPassword(dt.get(TCName).get("Password"));

	}
	@When("valid_login_with_theme_TC06")
	public void user_enters_valid_credentials_theme() {
		lp.SetuserName(dt.get(TCName).get("Userid"));
		lp.SetuserPassword(dt.get(TCName).get("Password"));
		lp.SelectTheme(dt.get(TCName).get("Theme"));
	}
	@When("click on login the button")
	public void click_on_login_the_button() {
	    lp.clickLogin();
	}

	@Then("user should be on home page")
	public void user_should_be_on_home_page() {
		hp.verifyLogout();
	}

	@Then("user can see logout option")
	public void user_can_see_logout_option() {
		hp.verifyLogout();
	}

	@When("user enters valid credentials user id {string} and password {string}")
	public void user_enters_valid_crdentials_user_id_and_password(String x, String y) {
		lp.SetuserName(x);
		lp.SetuserPassword(y);
	}

	@When("user enters valid credentials user id as {string} and password as {string}")
	public void user_enters_valid_credentials_user_id_as_and_password_as(String x, String y) {
		lp.SetuserName(x);
		lp.SetuserPassword(y);
	}

}