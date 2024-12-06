package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.SeleniumBase;

public class AboutPage extends SeleniumBase {
	// ------------------------Page object initializing-------------------
	public AboutPage() {
		PageFactory.initElements(driver, this);
	}

//------------------------------PageObject------------------------------
	@FindBy(xpath = "//h6[normalize-space()='About']")
	WebElement aboutHeader;
	@FindBy(xpath = "//p[normalize-space()='Company Name:']")
	WebElement aboutCompanyName;
	@FindBy(xpath = "//p[normalize-space()='Version:']")
	WebElement aboutVersion;
	@FindBy(xpath = "//p[normalize-space()='Active Employees:']")
	WebElement aboutActiveEmployees;
	@FindBy(xpath = "//p[normalize-space()='Employees Terminated:']")
	WebElement aboutEmployeesTerminated;
	@FindBy(xpath = "//p[normalize-space()='OrangeHRM']")
	WebElement aboutCompanyNameValue;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-about-text'][normalize-space()='OrangeHRM OS 5.7']")
	WebElement aboutVersionValue;
	@FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[6]")
	WebElement aboutActiveEmployeesValue;
	@FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[8]")
	WebElement aboutEmployeesTerminatedValue;

	// ------------------------------Actions------------------------------
	public boolean aboutHeader() {
		return aboutHeader.isDisplayed();
	}

	public boolean aboutCompanyName() {
		return aboutCompanyName.isDisplayed();
	}

	public boolean aboutVersion() {
		return aboutVersion.isDisplayed();
	}

	public boolean aboutActiveEmployees() {
		return aboutActiveEmployees.isDisplayed();
	}

	public boolean aboutEmployeesTerminated() {
		return aboutEmployeesTerminated.isDisplayed();
	}

	public boolean aboutCompanyNameValue() {
		return aboutCompanyNameValue.isDisplayed();
	}

	public boolean aboutVersionValue() {
		return aboutVersionValue.isDisplayed();
	}

	public boolean aboutActiveEmployeesValue() {
		return aboutActiveEmployeesValue.isDisplayed();
	}

	public boolean aboutEmployeesTerminatedValue() {
		return aboutEmployeesTerminatedValue.isDisplayed();
	}

}
