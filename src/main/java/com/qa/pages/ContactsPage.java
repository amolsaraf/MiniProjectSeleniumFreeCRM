package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.testbase.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Amol Saraf')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//td[@class='datacardtitle' and @align='right' and @valign='top']//following-sibling::input[@type='button' and @value='New Contact']")
	WebElement newContactBtn;
	
	@FindBy(xpath = "//select[@name='title']")
	WebElement titleDropDown;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//td[@colspan='2' and @align='center']//following-sibling::input[@value='Save']")
	WebElement saveBtn;
	
	

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	
	public void createNewContact(String title, String fName, String lName, String comp) {
		
		newContactBtn.click();
		Select selectTitle = new Select(titleDropDown);
		selectTitle.selectByVisibleText(title);
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
}
