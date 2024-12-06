package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.SeleniumBase;

public class ChangePasswordPage extends SeleniumBase {
	// --------------------PageObject Initializing------------------
	public ChangePasswordPage() {
		PageFactory.initElements(driver, this);
	}

	// ------------------------------PageObject------------------------------
	@FindBy(xpath = "//label[normalize-space()='Username']")
	WebElement changeHeaderUsername;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-user-name']")
	WebElement changeUsernameAdmin;
	@FindBy(xpath = "//label[normalize-space()='Current Password']")
	WebElement changeCurrentPassword;
	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement changeCurrentPassswordValue;
	@FindBy(xpath = "//label[normalize-space()='Password']")
	WebElement changePassword;
	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement changePasswordValue;
	@FindBy(xpath = "//label[normalize-space()='Confirm Password']")
	WebElement changeConfirmPassword;
	@FindBy(xpath = "(//input[@type='password'])[3]")
	WebElement changeConfirmPasswordValue;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p user-password-hint']")
	WebElement changeUserPasswordHint;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-form-hint']")
	WebElement changeRequiredText;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement changeCancelButton;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement changeResetButton;

	// ------------------------------Required------------------------------
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required']")
	WebElement changeCurrentPasswordRequired;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required']")
	WebElement changePasswordRequired;
	@FindBy(xpath = "//span[normalize-space()='Passwords do not match']")
	WebElement changeConfirmPasswordRequired;

	// ------------------------------Actions------------------------------
	public boolean changeHeaderUsername() {
		return changeHeaderUsername.isDisplayed();
	}

	public boolean changeUsernameAdmin() {
		return changeUsernameAdmin.isDisplayed();
	}

	public boolean changeCurrentPassword() {
		return changeCurrentPassword.isDisplayed();
	}

	public boolean changeCurrentPassswordValue(String password) {
		changeCurrentPassswordValue.sendKeys(password);
		return changeCurrentPassswordValue.isDisplayed();
	}

	public boolean changePassword() {
		return changePassword.isDisplayed();
	}

	public boolean changePasswordValue() {
		return changePasswordValue.isDisplayed();
	}

	public boolean changeConfirmPassword() {
		return changeConfirmPassword.isDisplayed();
	}

	public boolean changeConfirmPasswordValue() {
		return changeConfirmPasswordValue.isDisplayed();
	}

	public boolean changeUserPasswordHint() {
		return changeUserPasswordHint.isDisplayed();
	}

	public boolean changeRequiredText() {
		return changeRequiredText.isDisplayed();
	}

	public boolean changeCancelButton() {
		return changeCancelButton.isDisplayed();
	}

	public boolean changeResetButton() {
		return changeResetButton.isDisplayed();
	}

	public boolean changeCurrentPasswordRequired() {
		return changeCurrentPasswordRequired.isDisplayed();
	}

	public boolean changePasswordRequired() {
		return changePasswordRequired.isDisplayed();
	}

	public boolean changeConfirmPasswordRequired() {
		return changeConfirmPasswordRequired.isDisplayed();
	}
}
