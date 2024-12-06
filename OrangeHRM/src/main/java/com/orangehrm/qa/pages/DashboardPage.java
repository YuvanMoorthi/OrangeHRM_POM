package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.SeleniumBase;
import com.orangehrm.qa.util.TestUtil;

public class DashboardPage extends SeleniumBase {
	// ------------------------Page object initializing-------------------
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	// ------------------------------PageObject------------------------------
	// ------------------------------Header------------------------------
	@FindBy(xpath = "//button[normalize-space()='Upgrade']")
	WebElement upgradeLink;
	@FindBy(xpath = "//img[@alt='OrangeHRM Logo']")
	WebElement mainWebsiteLogo;
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement labelUsername;
	@FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
	WebElement labelUsernameImage;
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement labelUsernameDropdownIcon;
	@FindBy(xpath = "//ul[@role='menu']")
	WebElement headerDropdownMenu;
	@FindBy(xpath = "//button[@title='Help']")
	WebElement headerHelp;
	@FindBy(id = "main-content")
	WebElement headerHelpMain;
	// ------------------------------Header DropDown------------------------------
	@FindBy(linkText = "About")
	WebElement headerDropdownAbout;
	@FindBy(linkText = "Support")
	WebElement headerDropdownSupport;
	@FindBy(linkText = "Change Password")
	WebElement headerDropdownChangePassword;
	@FindBy(linkText = "Logout")
	WebElement headerDropdownLogout;

	// ------------------------------Actions------------------------------
	// ------------------------------Header------------------------------
	public void upgradeLink() {
		upgradeLink.click();
	}

	public boolean mainWebsiteLogo() {
		return mainWebsiteLogo.isDisplayed();
	}

	public boolean labelUsername() {
		return labelUsername.isDisplayed();
	}

	public boolean labelUsernameImage() {
		return labelUsernameImage.isDisplayed();
	}

	public void labelUsernameDropdownIcon() {
		labelUsernameDropdownIcon.click();
	}

	public boolean headerDropdownMenu() {
		return headerDropdownMenu.isDisplayed();
	}

	public void headerHelp() {
		headerHelp.click();
	}

	public boolean headerHelpMain() {
		return headerHelpMain.isDisplayed();
	}

	// ------------------------------Header DropDown------------------------------
	public AboutPage headerDropdownAbout() {

		labelUsernameDropdownIcon.click();
		TestUtil.waitForElementToBeClickable(headerDropdownAbout);
		headerDropdownAbout.click();
		return new AboutPage();
	}

	public SupportPage headerDropdownSupport() {

		labelUsernameImage.click();
		TestUtil.waitForElementToBeClickable(headerDropdownSupport);
		headerDropdownSupport.click();
		return new SupportPage();
	}

	public ChangePasswordPage headerDropdownChangePassword() {
		labelUsername.click();
		testutil.waitForElementToBeClickable(headerDropdownChangePassword);
		headerDropdownChangePassword.click();
		return new ChangePasswordPage();
	}

	public LoginPage headerDropdownLogout() {
		labelUsername.click();
		testutil.waitForElementToBeClickable(headerDropdownLogout);
		headerDropdownLogout.click();
		return new LoginPage();
	}
}
