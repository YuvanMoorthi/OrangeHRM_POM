package com.orangehrm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.SeleniumBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.ForgotPasswordPage;
import com.orangehrm.qa.pages.LoginPage;

public class LoginPageTest extends SeleniumBase {
	LoginPage loginpage;
	ForgotPasswordPage forgotpasswordpage;
	DashboardPage dashboardpage;

	public LoginPageTest() {
		super();
	}

	// --------------------To Initiate browser------------------------s
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage = new LoginPage();
		forgotpasswordpage = new ForgotPasswordPage();
		dashboardpage = new DashboardPage();
	}

	@Test(priority = 1)
	public void validateBrandLogoTest() {
		boolean validateBrandLogo = loginpage.validateBrandLogo();
		Assert.assertTrue(validateBrandLogo, "Brand logo of the login page is not displayed");
	}

	@Test(priority = 2)
	public void validateLogoHeaderTest() {
		boolean validateLogoheader = loginpage.validateLogoHeader();
		Assert.assertTrue(validateLogoheader, "Logo header of the login page is not displayed");
	}

	@Test(priority = 3)
	public void validateDemoUserTest() {
		boolean validateDemoUser = loginpage.validateDemoUser();
		Assert.assertTrue(validateDemoUser, "Demo username of the login page is not displayed");
	}

	@Test(priority = 4)
	public void validateDemoPasswordTest() {
		boolean validateDemoPassword = loginpage.validateDemoPassword();
		Assert.assertTrue(validateDemoPassword, "Demo password of the login page is not displayed");
	}

	@Test(priority = 5)
	public void validateIconUserTest() {
		boolean validateIconUser = loginpage.validateIconUser();
		Assert.assertTrue(validateIconUser, "Icon user of the login page is not displayed");
	}

	@Test(priority = 6)
	public void validateIconPersonTest() {
		boolean validateIconPerson = loginpage.validateIconPerson();
		Assert.assertTrue(validateIconPerson, "Icon person of the login page is not displayed");
	}

	@Test(priority = 7)
	public void validateViewUsernameTest() {
		boolean validateViewUsername = loginpage.validateViewUsername();
		Assert.assertTrue(validateViewUsername, "View username of the login page is not displayed");
	}

	@Test(priority = 8)
	public void validateViewPasswordTest() {
		boolean validateViewPassword = loginpage.validateViewPassword();
		Assert.assertTrue(validateViewPassword, "View password of the login page is not displayed");
	}

	@Test(priority = 9)
	public void validateViewVersionTest() {
		boolean validateViewVersion = loginpage.validateViewVersion();
		Assert.assertTrue(validateViewVersion, "View version of the login page is not displayed");
	}

	@Test(priority = 10)
	public void validateViewCopyRightsTest() {
		boolean validateViewCopyRights = loginpage.validateViewCopyRights();
		Assert.assertTrue(validateViewCopyRights, "View copyrights of the login page is not displayed");
	}

	@Test(priority = 11)
	public void validateViewSocialLinksTest() {
		boolean validateViewSocialLinks = loginpage.validateViewSocialLinks();
		Assert.assertTrue(validateViewSocialLinks, "View social links of the login page is not displayed");
	}

	@Test(priority = 12)
	public void clickOnForgtPasswordLinkTest() {
		loginpage.clickOnForgotPasswordLink();
		boolean headerResetPassword = forgotpasswordpage.headerResetPassword();
		assertTrue(headerResetPassword, "Forgot password link is not navigate to forgotpassword page");

	}

	@Test(priority = 13)
	public void clickOrangehrmWebsiteTest() {
		loginpage.clickOrangehrmWebsite();
		testutil.switchToWindowByIndex(driver, 1);
		boolean mainOrangehrmImage = loginpage.mainOrangehrmImage();
		assertTrue(mainOrangehrmImage, "driver does not switched to new window");
		driver.close();
		testutil.switchToWindowByIndex(driver, 0);
		boolean validateLogoHeader = loginpage.validateLogoHeader();
		assertTrue(validateLogoHeader, "driver does not switch to login page");
	}

	@Test(priority = 14)
	public void verifyLoginTest() {
		loginpage.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		boolean labelUsername = dashboardpage.labelUsername();
		assertTrue(labelUsername, "Wrong login credentials is entered");
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