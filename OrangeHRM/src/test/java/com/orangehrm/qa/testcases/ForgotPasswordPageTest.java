package com.orangehrm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.SeleniumBase;
import com.orangehrm.qa.pages.ForgotPasswordPage;
import com.orangehrm.qa.pages.LoginPage;

public class ForgotPasswordPageTest extends SeleniumBase {
	ForgotPasswordPage forgotpasswordpage;
	LoginPage loginpage;

	public ForgotPasswordPageTest() {
		super();
	}

	// --------------------To Initiate browser------------------------
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		forgotpasswordpage = loginpage.clickOnForgotPasswordLink();

	}

	@Test(priority = 1)
	public void headerResetPasswordTest() {
		boolean headerResetPassword = forgotpasswordpage.headerResetPassword();
		assertTrue(headerResetPassword, "header of the forgot password page is not displayed");

	}

	@Test(priority = 2)
	public void descriptionTextTest() {
		boolean descriptionText = forgotpasswordpage.descriptionText();
		assertTrue(descriptionText, "description of the forgot password page is not displayed");

	}

	@Test(priority = 3)
	public void iconPersonTest() {
		boolean iconPerson = forgotpasswordpage.iconPerson();
		assertTrue(iconPerson, "person icon of the forgot password page is not displayed");

	}

	@Test(priority = 4)
	public void labelUsernameTest() {
		boolean labelUsername = forgotpasswordpage.labelUsername();
		assertTrue(labelUsername, "username label of the forgot password page is not displayed");
	}

	@Test(priority = 5)
	public void labelVersionTest() {
		boolean labelVersion = forgotpasswordpage.labelVersion();
		assertTrue(labelVersion, "version of the forgot password page is not displayed");

	}

	@Test(priority = 6)
	public void clickCancelButtonTest() {
		forgotpasswordpage.clickCancelButton();
		boolean validateLogoHeader = loginpage.validateLogoHeader();
		assertTrue(validateLogoHeader, "cancel button in the forgot password page is not working ");

	}

	@Test(priority = 7)
	public void clickResetButtonTest() {
		forgotpasswordpage.clickResetButton();
		boolean requiredMessage = forgotpasswordpage.requiredMessage();
		assertTrue(requiredMessage, "required the username is not display when click the reset button");
		forgotpasswordpage.enterUsername(prop.getProperty("username"));
		boolean resetPasswordLink = forgotpasswordpage.resetPasswordLink();
		assertTrue(resetPasswordLink, "reset password page is not displayed when click the reset button");
	}

	@Test(priority = 8)
	public void enterUsernameTest() {
		forgotpasswordpage.enterUsername(prop.getProperty("username"));
		forgotpasswordpage.clickResetButton();
		boolean resetPasswordLink = forgotpasswordpage.resetPasswordLink();
		assertTrue(resetPasswordLink, "reset password page is not displayed when click the reset button");

	}

	@Test(priority = 9)
	public void clickMainPageLinkTest() {
		forgotpasswordpage.clickMainPageLink();
		testutil.switchToWindowByIndex(driver, 1);
		boolean logoMainPage = forgotpasswordpage.logoMainPage();
		assertTrue(logoMainPage, "main orangeHRM website logo is not displayed when click the main website link");
		driver.close();
		testutil.switchToWindowByIndex(driver, 0);
		boolean headerResetPassword = forgotpasswordpage.headerResetPassword();
		assertTrue(headerResetPassword, "header of the forgot password page is not displayed");

	}

	// ------------------------------To Quit Browser------------------------------
	@AfterMethod
	public void tearDown() {
		try {
			if (driver != null) {
				driver.quit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
