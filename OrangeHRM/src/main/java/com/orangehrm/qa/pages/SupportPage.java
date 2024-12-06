package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.SeleniumBase;

public class SupportPage extends SeleniumBase {
	// ----------------PageObject Initializing-------------------------------
	public SupportPage() {
		PageFactory.initElements(driver, this);
	}

	// ------------------------------PageObject------------------------------
	@FindBy(xpath = "//div[@class='orangehrm-card-container']/p[1]")
	WebElement supportDescription;
	@FindBy(xpath = "//div[@class='orangehrm-card-container']/p[2]")
	WebElement supportInformation;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-sub-title']")
	WebElement supportCustomerSupport;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//p[@class='oxd-text oxd-text--p orangehrm-support-text']")
	WebElement supportConnactSupport;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//p[@class='oxd-text oxd-text--p orangehrm-support-text']")
	WebElement supportversion;
	@FindBy(xpath = "//div[@class='oxd-layout-footer']//p[2]")
	WebElement supportCopyrights;
	@FindBy(linkText = "OrangeHRM, Inc")
	WebElement supportMainWebsite;
	@FindBy(xpath = "//img[@src='/public/_resources/themes/orangehrm/dist/images/OrangeHRM_Logo.svg']")
	WebElement SupportMainWebsiteLogo;

	// ------------------------------Actions---------------------------------
	public boolean supportDescription() {
		return supportDescription.isDisplayed();
	}

	public boolean supportInformation() {
		return supportInformation.isDisplayed();
	}

	public boolean supportCustomerSupport() {
		return supportCustomerSupport.isDisplayed();
	}

	public boolean supportConnactSupport() {
		return supportConnactSupport.isDisplayed();
	}

	public boolean supportversion() {
		return supportversion.isDisplayed();
	}

	public boolean supportCopyrights() {
		return supportCopyrights.isDisplayed();
	}

	public void supportMainWebsite() {
		supportMainWebsite.click();
	}

	public boolean SupportMainWebsiteLogo() {
		return SupportMainWebsiteLogo.isDisplayed();
	}
}
