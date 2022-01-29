package com.aspire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.TestBase;

public class ProductPage extends TestBase{
	
	@FindBy(xpath = "//button[@title='Create record']")
	WebElement createProductButton;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyProductPage(){
		return createProductButton.isDisplayed();
	}
	
	public CreateNewProductPage clickOnCreateProductButton(){
		createProductButton.click();
		return new CreateNewProductPage();
	}

}
