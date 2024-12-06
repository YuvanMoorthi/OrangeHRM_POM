package com.orangehrm.qa.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.qa.base.SeleniumBase;

public class TestUtil extends SeleniumBase {
	public long implicityWait = 30;

//------------------Wait for element to click able-----------------------
	public static void waitForElementToBeClickable(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used for switch between windows using index value
	 * 
	 * @index - this index is used to switch between the windows
	 */
	public static void switchToWindowByIndex(WebDriver driver, int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			wait.until((ExpectedCondition<Boolean>) d -> driver.getWindowHandles().size() > index);
			List<String> windowHandles = List.copyOf(driver.getWindowHandles());
			if (index >= 0 && index < windowHandles.size()) {
				driver.switchTo().window(windowHandles.get(index));
				System.out.println("Switched to window with index: " + index);
			} else {
				System.out.println("Invalid index: " + index);
			}
		} catch (Exception e) {
			System.err.println("Unable to switch to window at index: " + index);
			e.printStackTrace();
		}
	}
}
