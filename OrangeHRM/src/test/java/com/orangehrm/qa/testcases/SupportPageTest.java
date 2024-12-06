package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.SeleniumBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.SupportPage;

public class SupportPageTest extends SeleniumBase {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	SupportPage supportpage;

	public SupportPageTest() {
		super();
	}

//-----------------To Initiate browser------------------------
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage = new LoginPage();
		dashboardpage = loginpage.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		supportpage = dashboardpage.headerDropdownSupport();
	}

	@Test(priority = 1)
	public void supportDescriptionTest() {
		boolean supportDescription = supportpage.supportDescription();
		Assert.assertTrue(supportDescription, "description of the support page is not displayed");
	}

	@Test(priority = 2)
	public void supportInformationTest() {
		boolean supportInformation = supportpage.supportInformation();
		Assert.assertTrue(supportInformation, "Information of the support page is not displayed");
	}

	@Test(priority = 3)
	public void supportConnactSupportTest() {
		boolean supportConnactSupport = supportpage.supportConnactSupport();
		Assert.assertTrue(supportConnactSupport, "Connact Support Support of the support page is not displayed");
	}

	@Test(priority = 4)
	public void supportversionTest() {
		boolean supportversion = supportpage.supportversion();
		Assert.assertTrue(supportversion, "version of the support page is not displayed");
	}

	@Test(priority = 5)
	public void supportCopyrightsTest() {
		boolean supportCopyrights = supportpage.supportCopyrights();
		Assert.assertTrue(supportCopyrights, "Copyrights of the support page is not displayed");
	}

	@Test(priority = 6)
	public void supportMainWebsiteTest() {
		supportpage.supportMainWebsite();
		testutil.switchToWindowByIndex(driver, 1);
		boolean supportMainWebsiteLogo = supportpage.SupportMainWebsiteLogo();
		Assert.assertTrue(supportMainWebsiteLogo, "orangeHRM main website is not navigate to main page");
		driver.close();
		testutil.switchToWindowByIndex(driver, 0);
		boolean supportDescription = supportpage.supportDescription();
		Assert.assertTrue(supportDescription,
				"after close the new window driver does not come back to the parent window");
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
