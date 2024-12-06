package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.SeleniumBase;
import com.orangehrm.qa.pages.AboutPage;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;

public class AboutPageTest extends SeleniumBase {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AboutPage aboutpage;

	public AboutPageTest() {
		super();
	}

//--------------------To Initiate browser------------------------
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage = new LoginPage();
		dashboardpage = loginpage.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		aboutpage = dashboardpage.headerDropdownAbout();
	}

	@Test(priority = 1)
	public void aboutHeaderTest() {
		boolean aboutHeader = aboutpage.aboutHeader();
		Assert.assertTrue(aboutHeader, "header of the about page is not displayed");
	}

	@Test(priority = 1)
	public void aboutCompanyNameTest() {
		boolean aboutCompanyName = aboutpage.aboutCompanyName();
		Assert.assertTrue(aboutCompanyName, "company name of the about page is not displayed");
	}

	@Test(priority = 1)
	public void aboutVersionTest() {
		boolean aboutVersion = aboutpage.aboutVersion();
		Assert.assertTrue(aboutVersion, "version of the about page is not displayed");
	}

	@Test(priority = 1)
	public void aboutActiveEmployeesTest() {
		boolean aboutActiveEmployees = aboutpage.aboutActiveEmployees();
		Assert.assertTrue(aboutActiveEmployees, "active employees of the about page is not displayed");
	}

	@Test(priority = 1)
	public void aboutEmployeesTerminatedTest() {
		boolean aboutEmployeesTerminated = aboutpage.aboutEmployeesTerminated();
		Assert.assertTrue(aboutEmployeesTerminated, "employees terminated of the about page is not displayed");
	}

	@Test(priority = 1)
	public void aboutCompanyNameValueTest() {
		boolean aboutCompanyNameValue = aboutpage.aboutCompanyNameValue();
		Assert.assertTrue(aboutCompanyNameValue, "company name value of the about page is not displayed");
	}

	@Test(priority = 1)
	public void aboutVersionValueTest() {
		boolean aboutVersionValue = aboutpage.aboutVersionValue();
		Assert.assertTrue(aboutVersionValue, "version value of the about page is not displayed");
	}

	@Test(priority = 1)
	public void aboutActiveEmployeesValueTest() {
		boolean aboutActiveEmployeesValue = aboutpage.aboutActiveEmployeesValue();
		Assert.assertTrue(aboutActiveEmployeesValue, "active employees value of the about page is not displayed");
	}

	@Test(priority = 1)
	public void aboutEmployeesTerminatedValueTest() {
		boolean aboutEmployeesTerminatedValue = aboutpage.aboutEmployeesTerminatedValue();
		Assert.assertTrue(aboutEmployeesTerminatedValue,
				"employees terminated value of the about page is not displayed");
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
