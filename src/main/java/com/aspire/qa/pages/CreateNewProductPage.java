package com.aspire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.TestBase;

public class CreateNewProductPage extends TestBase{
	
	@FindBy(xpath = "//label[text()='Product Name']")
	WebElement productNameLabel;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement inputProductName;
	
	@FindBy(xpath = "//button[@title='Save record']")
	WebElement saveProduct;
	
	@FindBy(xpath = "//button[@name='action_update_quantity_on_hand']")
	WebElement updateQuantityButton;
	
	@FindBy(xpath = "//button[@class='btn btn-primary o_list_button_add']")
	WebElement quantityUpdateRowCreateButton;
	
	@FindBy(xpath = "//input[@name='inventory_quantity']")
	WebElement UpdateQuantityInput;
	
	@FindBy(xpath = "//a[@title='Home menu']")
	WebElement HomeMenuButton;
	
		
	public CreateNewProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyNewProductPage(){
		return productNameLabel.isDisplayed();
	}
	
	public void EnterProductName(String prductName){
		inputProductName.sendKeys(prductName);	
	}
	
	public void UpdateProductQuantityAndSaveProduct(String Quantity){
		updateQuantityButton.click();
		quantityUpdateRowCreateButton.click();
		UpdateQuantityInput.clear();
		UpdateQuantityInput.sendKeys(Quantity);
		saveProduct.click();
	}
	
	public HomePage ClickHomeMenu(){
		HomeMenuButton.click();
		return new HomePage();
	}

}
