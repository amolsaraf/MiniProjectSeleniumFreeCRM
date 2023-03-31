package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	TestUtil testUtil;
	ContactsPage contactsPage;
	LoginPage loginPage;
	HomePage homePage;
	
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
	    testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("Test 2 Test 2");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("Test 2 Test 2");
		contactsPage.selectContactsByName("Test 01 Tester");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateNewContact(String title, String firstname, String lastname, String company) {
//		contactsPage.createNewContact("Mr.", "Akshu", "SarafS", "Google");
		contactsPage.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
