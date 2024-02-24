package com.qa.task3LoginTest;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.base.TestBase;
import com.qa.pages.Task3_HomePage;
import com.qa.pages.Task3_LoginPage;

public class Task3_LoginTest extends TestBase {
	Task3_LoginPage loginPage;
	Task3_HomePage homePage;

	public Task3_LoginTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		intialization();

		loginPage = new Task3_LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}

	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("T3_username"), prop.getProperty("T3_password"));
	}

	@Test(priority = 3)
	public void logoutTest() {
		loginPage.logout();
	}

	@Test(priority = 4)
	public void loginTestFalse() {
		homePage = loginPage.login(prop.getProperty("T3_usernameFalse"), prop.getProperty("T3_password"));
		boolean flag = loginPage.validateWrogLoginErrorMessage();
		Assert.assertTrue(flag);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
