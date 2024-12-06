package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.SeleniumBase;
import com.orangehrm.qa.pages.AboutPage;
import com.orangehrm.qa.pages.ChangePasswordPage;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.SupportPage;

public class DashboardPageTest extends SeleniumBase {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AboutPage aboutpage;
	SupportPage supportpage;
	ChangePasswordPage changepasswordpage;

//------------------------------To Initiate browser------------------------------
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage = new LoginPage();
		dashboardpage = loginpage.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		aboutpage = new AboutPage();
		supportpage = new SupportPage();
		changepasswordpage = new ChangePasswordPage();
	}

//------------------------------Header------------------------------
	@Test(priority = 1)
	public void upgradeLinkTest() {
		dashboardpage.upgradeLink();
		testutil.switchToWindowByIndex(driver, 1);
		boolean mainWebsiteLogo = dashboardpage.mainWebsiteLogo();
		Assert.assertTrue(mainWebsiteLogo,
				"after click the upgrade link it does not navigate to main orangeHRM website");
		driver.close();
		testutil.switchToWindowByIndex(driver, 0);
		boolean labelUsername = dashboardpage.labelUsername();
		Assert.assertTrue(labelUsername,
				"after close the new window the driver does not navigate to the dashboard page");
	}

	@Test(priority = 2)
	public void labelUsernameTest() {
		boolean labelUsername = dashboardpage.labelUsername();
		Assert.assertTrue(labelUsername, "username label in the dashboard is not displayed");
	}

	@Test(priority = 3)
	public void labelUsernameImageTest() {
		boolean labelUsernameImage = dashboardpage.labelUsernameImage();
		Assert.assertTrue(labelUsernameImage, "username image in the dashboard is not displayed");
	}

	@Test(priority = 4)
	public void labelUsernameDropdownIconTest() {
		dashboardpage.labelUsernameDropdownIcon();
		boolean headerDropdownMenu = dashboardpage.headerDropdownMenu();
		Assert.assertTrue(headerDropdownMenu, "the header dropdown is not shown when click the dropdown icon");
	}

	@Test(priority = 5)
	public void helpButtonTest() {
		dashboardpage.headerHelp();
		testutil.switchToWindowByIndex(driver, 1);
		boolean headerHelpMain = dashboardpage.headerHelpMain();
		Assert.assertTrue(headerHelpMain, "the driver does not switch to new window ");
		driver.close();
		testutil.switchToWindowByIndex(driver, 0);
		boolean labelUsername = dashboardpage.labelUsername();
		Assert.assertTrue(labelUsername, "the driver does not switch to parent window");
	}

	// ------------------------------Header DropDown------------------------------
	@Test(priority = 6)
	public void headerDropdownAboutTest() {
		dashboardpage.headerDropdownAbout();
		boolean aboutHeader = aboutpage.aboutHeader();
		Assert.assertTrue(aboutHeader, "in headerdropdown click on about it does not navigate to about page");
	}

	@Test(priority = 7)
	public void headerDropdownSupportTest() {
		dashboardpage.headerDropdownSupport();
		boolean supportDescription = supportpage.supportDescription();
		Assert.assertTrue(supportDescription,
				"in header dropdown click on support it does not navigate to support page");
	}

	@Test(priority = 8)
	public void headerDropdownChangePasswordTest() {
		dashboardpage.headerDropdownChangePassword();
		boolean changeHeaderUsername = changepasswordpage.changeHeaderUsername();
		Assert.assertTrue(changeHeaderUsername,
				"in header dropdown click on change pasword it does not navigate to change password page");
	}

	@Test(priority = 9)
	public void headerDropdownLogout() {
		dashboardpage.headerDropdownLogout();
		boolean validateLogoHeader = loginpage.validateLogoHeader();
		Assert.assertTrue(validateLogoHeader,
				"in header dropdown click on logout it does not logout the account and navigate to login page");
	}

//------------------------------To Quit Browser------------------------------
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
