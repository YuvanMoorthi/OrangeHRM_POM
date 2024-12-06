package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.SeleniumBase;
import com.orangehrm.qa.util.TestUtil;

public class ForgotPasswordPage extends SeleniumBase {
	TestUtil testutil = new TestUtil();

	// ------------------------Page object initializing-------------------
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	// ------------------------PageObject-------------------
	@FindBy(tagName = "h6")
	WebElement headerResetPassword;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p']")
	WebElement descriptionText;
	@FindBy(tagName = "i")
	WebElement iconPerson;
	@FindBy(tagName = "label")
	WebElement labelUsername;
	@FindBy(name = "username")
	WebElement inputUsername;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement clickCancelButton;
	@FindBy(xpath = "//button[normalize-space()='Reset Password']")
	WebElement clickResetButton;
	@FindBy(tagName = "span")
	WebElement requiredSpan;
	@FindBy(xpath = "//p[normalize-space()='OrangeHRM OS 5.7']")
	WebElement labelVersion;
	@FindBy(linkText = "OrangeHRM, Inc")
	WebElement clickMainPage;
	@FindBy(xpath = "//img[@src='/public/_resources/themes/orangehrm/dist/images/OrangeHRM_Logo.svg']")
	WebElement logoMainPage;
	@FindBy(tagName = "h6")
	WebElement resetPasswordLink;

	// ------------------------------Actions------------------------------
	public boolean headerResetPassword() {
		return headerResetPassword.isDisplayed();
	}

	public boolean descriptionText() {
		return descriptionText.isDisplayed();
	}

	public boolean iconPerson() {
		return iconPerson.isDisplayed();
	}

	public boolean labelUsername() {
		return labelUsername.isDisplayed();
	}

	public boolean labelVersion() {
		return labelUsername.isDisplayed();
	}

	public void clickCancelButton() {
		clickCancelButton.click();
	}

	public void clickResetButton() {
		clickResetButton.click();
	}

	public boolean requiredMessage() {
		return requiredSpan.isDisplayed();
	}

	public void enterUsername(String username) {
		inputUsername.sendKeys(username);
	}

	public void clickMainPageLink() {
		clickMainPage.click();
	}

	public boolean logoMainPage() {
		return logoMainPage.isDisplayed();

	}

	public boolean resetPasswordLink() {
		return resetPasswordLink.isDisplayed();
	}

}
