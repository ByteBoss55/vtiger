package com.vtiger.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class LoginPage extends CommonActions {

	public LoginPage(WebDriver driver, ExtentTest Logger) {
		super(driver, Logger);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	WebElement tb_username;

	@FindBy(name = "user_password")
	WebElement tb_password;

	@FindBy(name = "login_theme")
	WebElement dd_theme;

	@FindBy(name = "Login")
	WebElement btn_login;

	@FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password.')]")
	WebElement txt_ErrMsg;

	@FindBy(xpath = "//img[@src='include/images/vtiger-crm.gif']")
	WebElement img_logo;

	// String username = "user_name";
	// By name = By.name("user_name");

	public void login(String userid, String pwd, String theme) {

		SetuserName(userid);
		SetuserPassword(pwd);
		SelectTheme(theme);
		clickLogin();

	}

	public void SetuserName(String userid) {

		InputText(tb_username, userid, userid + "has been entered into username field");
	}

	public void SetuserPassword(String pwd) {

		InputText(tb_password, pwd, pwd + "has been entered into password field");
	}

	public void SelectTheme(String theme) {

		SelectByIndex(dd_theme, theme + "has been selected from theme dropdown", theme);
	}

	public void clickLogin() {

		clickElement(btn_login, "Login button clicked");
	}

	public void verifyErrorMsg() {

		ElementExist(txt_ErrMsg, "Error msg exist on Login Page");
	}

	public void verifyLogo() {
		ElementExist(img_logo, "Logo has been displayed successfully");
	}

}
