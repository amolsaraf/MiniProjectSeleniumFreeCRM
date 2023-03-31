package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.util.TestUtil;

public class TestBase {

	// Global Variables
	public static WebDriver driver;
	public static Properties prop;

	// Create a constructor for the main class --> TestBase()
	public TestBase() {
	try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
				"C:/eclipse/workspace/MiniSeleniumProject" + "/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// Chrome Driver Properties
	public static void initialization() {
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/Amol Saraf/Desktop/Amol/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}

		// Fetch URL From config properties file
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

	}
}
