package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.SeleniumBase;

public class LoginPage extends SeleniumBase {
	// ------------------------Page object initializing-------------------
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// ------------------------------comment------------------------------
	@FindBy(name = "username")
	WebElement enterUsername;
	@FindBy(name = "password")
	WebElement enterPassword;
	@FindBy(xpath = "//button[.=' Login ']")
	WebElement clickLogin;
	@FindBy(xpath = "//div[@class='orangehrm-login-branding']")
	WebElement brandLogo;
	@FindBy(xpath = "//h5[normalize-space()=\"Login\"]")
	WebElement logoHeader;
	@FindBy(xpath = "//p[normalize-space()=\"Username : Admin\"]")
	WebElement demoUser;
	@FindBy(xpath = "//p[normalize-space()=\"Password : admin123\"]")
	WebElement demoPassword;
	@FindBy(xpath = "//i[@class=\"oxd-icon bi-person oxd-input-group__label-icon\"]")
	WebElement iconUser;
	@FindBy(xpath = "//i[@class=\"oxd-icon bi-key oxd-input-group__label-icon\"]")
	WebElement iconPerson;
	@FindBy(xpath = "//label[normalize-space()=\"Username\"]")
	WebElement viewUsername;
	@FindBy(xpath = "//label[normalize-space()=\"Password\"]")
	WebElement viewPassword;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement forgotPasswordLink;
	@FindBy(xpath = "//p[normalize-space()=\"OrangeHRM OS 5.7\"]")
	WebElement viewVersion;
	@FindBy(xpath = "//div[@class=\"orangehrm-login-footer\"]//p[2]")
	WebElement viewCopyRights;
	@FindBy(linkText = "OrangeHRM, Inc")
	WebElement clickOrangehrmWebsite;
	@FindBy(xpath = "//div[@class='orangehrm-login-footer-sm']")
	WebElement viewSocialLinks;
	@FindBy(xpath = "//img[@src='/public/_resources/themes/orangehrm/dist/images/OrangeHRM_Logo.svg']")
	private WebElement mainOrangehrmImage;

	// ------------------------Actions-------------------
	public boolean validateBrandLogo() {
		return brandLogo.isDisplayed();
	}

	public boolean validateLogoHeader() {
		return logoHeader.isDisplayed();
	}

	public boolean validateDemoUser() {
		return demoUser.isDisplayed();
	}

	public boolean validateDemoPassword() {
		return demoPassword.isDisplayed();
	}

	public boolean validateIconUser() {
		return iconUser.isDisplayed();
	}

	public boolean validateIconPerson() {
		return iconPerson.isDisplayed();
	}

	public boolean validateViewUsername() {
		return viewUsername.isDisplayed();
	}

	public boolean validateViewPassword() {
		return viewPassword.isDisplayed();
	}

	public boolean validateViewVersion() {
		return viewVersion.isDisplayed();
	}

	public ForgotPasswordPage clickOnForgotPasswordLink() {
		forgotPasswordLink.click();
		return new ForgotPasswordPage();
	}

	public boolean validateViewCopyRights() {
		return viewCopyRights.isDisplayed();
	}

	public boolean validateViewSocialLinks() {
		return viewSocialLinks.isDisplayed();
	}

	public LoginPage clickOrangehrmWebsite() {
		clickOrangehrmWebsite.click();
		return new LoginPage();
	}

	public boolean mainOrangehrmImage() {
		return mainOrangehrmImage.isDisplayed();
	}

	public DashboardPage enterLoginCredentials(String Username, String Password) {
		enterUsername.sendKeys(Username);
		enterPassword.sendKeys(Password);
		clickLogin.click();
		return new DashboardPage();
	}

}
