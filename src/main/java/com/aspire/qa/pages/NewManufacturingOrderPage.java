package com.aspire.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.TestBase;
import com.aspire.qa.util.TestUtil;

public class NewManufacturingOrderPage extends TestBase{
	
	@FindBy(xpath = "//span[@class='text-muted'][text()='New']")
	WebElement newManufacturingOrderPageLabel;
	
	@FindBy(xpath = "//label[text()='Product']/parent::td/following-sibling::td//input")
	WebElement productNameManufacturingOrderInput;
		
	@FindBy(xpath = "//button[@title='Save record']")
	WebElement saveManufactoringOrder;
	
	@FindBy(xpath = "//button[@name='action_confirm']")
	WebElement confirmButton;
	
	@FindBy(xpath = "//button[@name='button_mark_done'][@class='btn btn-primary']")
	List<WebElement> markAsDoneButton;
	
	@FindBy(xpath = "//footer[@class='modal-footer']/button/span[text()='Ok']")
	List<WebElement> productConfirmationAlertButton;
	
	@FindBy(xpath = "//button[@name='process']/span")
	WebElement alertApplyButton;
	
	@FindBy(xpath = "//a[@name='product_id']/span")
	WebElement createdManufacturingOrderProduct;
	
	public NewManufacturingOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyNewManufacturingOrderPage(){
		return newManufacturingOrderPageLabel.isDisplayed();
	}
	
	public ManufacturingOrderPage CreateNewManufactoringOrder(String prductName, String quantity) throws InterruptedException{
		productNameManufacturingOrderInput.sendKeys(prductName);
		Thread.sleep(2000);
		productNameManufacturingOrderInput.sendKeys(Keys.ENTER);
		saveManufactoringOrder.click();
		confirmButton.click();
		if(markAsDoneButton.size()>0) {
			markAsDoneButton.get(0).click();
		}	
		if(productConfirmationAlertButton.size()>0) {
			productConfirmationAlertButton.get(0).click();
			alertApplyButton.click();
		}		
		return new ManufacturingOrderPage();
	}	
	
	public String getCreatedManufacturingOrderProduct(){
		String actProductName = createdManufacturingOrderProduct.getText();
		return actProductName;
	}
}
