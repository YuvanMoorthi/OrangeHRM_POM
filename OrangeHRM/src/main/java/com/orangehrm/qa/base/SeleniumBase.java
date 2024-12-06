package com.orangehrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.orangehrm.qa.util.TestUtil;

public class SeleniumBase {
	protected static WebDriver driver;
	protected static Properties prop;
	public TestUtil testutil;

	// -----------Constructor to load configuration properties------------
	public SeleniumBase() {
		try {
			prop = new Properties();
			String configLocation = "D:\\Yuvan\\Final_OrangeHRM\\OrangeHRM\\src\\main\\java\\com\\orangehrm\\qa\\config\\Config.properties";
			File file = new File(configLocation);

			// Try-with-resources to close FileInputStream automatically
			try (FileInputStream fileInp = new FileInputStream(file)) {
				prop.load(fileInp);
				System.out.println("Config properties loaded successfully.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Config file not found at the specified location.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading config file.");
			e.printStackTrace();
		}
	}

	// ----------------------Initialization of WebDriver----------------------
	public void initialization() {
		String browserName = prop.getProperty("browser");
		String appUrl = prop.getProperty("url");

		if (browserName == null || appUrl == null) {
			System.out.println("Browser or URL is not specified in the configuration file.");
			return;
		}
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\selenium webdriver\\EdgeDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser specified in the configuration file.");
			return;
		}
		testutil = new TestUtil();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(testutil.implicityWait, TimeUnit.SECONDS);
		driver.get(appUrl);
		System.out.println("Navigated to URL: " + appUrl);
	}
}
