package com.aspire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[text()='User']")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//div[text()='Inventory']/parent::a")
	WebElement inventoryLink;
	
	@FindBy(xpath = "//div[text()='Manufacturing']/parent::a")
	WebElement manufacturingLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
		
	public boolean verifyHomePage(){
		return userNameLabel.isDisplayed();
	}
	
	public InventoryPage clickOnInventoryLink(){
		inventoryLink.click();
		return new InventoryPage();
	}
	
	public ManufacturingOrderPage clickOnManufacturingLink(){
		manufacturingLink.click();
		return new ManufacturingOrderPage();
	}
	
}
