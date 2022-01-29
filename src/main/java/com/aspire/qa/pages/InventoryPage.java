package com.aspire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.TestBase;

public class InventoryPage extends TestBase{
	
	@FindBy(xpath = "//span[text()='Inventory Overview']")
	WebElement inventoryPageLabel;
	
	@FindBy(xpath = "//button[@title='Products']")
	WebElement productsMenuItem;
	
	@FindBy(xpath = "//a[text()='Products']")
	WebElement productsSubMenuItem;
	
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyInventoryPage(){
		return inventoryPageLabel.isDisplayed();
	}
	
	public ProductPage clickOnProductMenu(){
		productsMenuItem.click();
	//	Actions actions = new Actions(driver);
	//	actions.moveToElement(productsSubMenuItem).click();
		productsSubMenuItem.click();
		return new ProductPage();
	}
	
	
	
	
	
	
	

}
