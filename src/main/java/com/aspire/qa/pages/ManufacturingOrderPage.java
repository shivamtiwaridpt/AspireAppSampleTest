package com.aspire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.TestBase;

public class ManufacturingOrderPage extends TestBase{
	
	@FindBy(xpath = "//span[text()='Manufacturing Orders']")
	WebElement manufacturingPageLabel;
	
	@FindBy(xpath = "//button[@class='btn btn-primary o_list_button_add']")
	WebElement manufacturingOrderCreateButton;
	
	public ManufacturingOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyManufacturingPage(){
		return manufacturingPageLabel.isDisplayed();
	}
	
	public NewManufacturingOrderPage clickOnCreateButton(){
		manufacturingOrderCreateButton.click();
		return new NewManufacturingOrderPage();
	}
	
	
	
	
	
	
	

}
