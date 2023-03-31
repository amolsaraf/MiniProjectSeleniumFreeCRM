package com.qa.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

import com.qa.testbase.TestBase;

public class CustomListener extends TestBase implements ITestListener  {
	
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
