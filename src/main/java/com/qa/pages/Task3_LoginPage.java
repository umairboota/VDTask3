package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class Task3_LoginPage extends TestBase {

//	Login Page objects

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement usernameInput;

	@FindBy(id = "password")
	WebElement passwordInput;

	@FindBy(id = "login-button")
	WebElement loginButton;

	@FindBy(id = "logout_sidebar_link")
	WebElement logoutButton;

	@FindBy(xpath = "(//button[normalize-space()='Open Menu'])")
	WebElement sidBar;
	
	@FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match a')]")
	WebElement errorMessage;
	
	

//	initializing the page objects
	public Task3_LoginPage() {
		PageFactory.initElements(driver, this);
	}

//	ActionMethods
	public Task3_HomePage login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();

		return new Task3_HomePage();
	}

	public void logout() {
		sidBar.click();
		logoutButton.click();

	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateWrogLoginErrorMessage() {
		return errorMessage.isDisplayed();
	}

}
