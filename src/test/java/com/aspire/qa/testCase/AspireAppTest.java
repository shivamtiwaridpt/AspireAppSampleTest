package com.aspire.qa.testCase;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aspire.qa.base.ProductInfo;
import com.aspire.qa.base.TestBase;
import com.aspire.qa.pages.CreateNewProductPage;
import com.aspire.qa.pages.HomePage;
import com.aspire.qa.pages.InventoryPage;
import com.aspire.qa.pages.LoginPage;
import com.aspire.qa.pages.ManufacturingOrderPage;
import com.aspire.qa.pages.NewManufacturingOrderPage;
import com.aspire.qa.pages.ProductPage;
import com.aspire.qa.util.TestUtil;

public class AspireAppTest extends TestBase{
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	InventoryPage inventoryPage;
	ProductPage productPage;
	CreateNewProductPage createNewProductPage;
	ManufacturingOrderPage manufacturingOrderPage;
	NewManufacturingOrderPage newManufacturingOrderPage;
	
	String sheetName = "ProductAndManufactureData";
	
	public AspireAppTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
	    inventoryPage = new InventoryPage();
		productPage = new ProductPage();
		createNewProductPage = new CreateNewProductPage();
		manufacturingOrderPage = new ManufacturingOrderPage();
		newManufacturingOrderPage = new NewManufacturingOrderPage();
	}
	
	@Test
	public void LoginUserWithInventoryAndManufacturingTest() throws InterruptedException{
	    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.verifyHomePage());
		homePage.clickOnInventoryLink();
		Assert.assertTrue(inventoryPage.verifyInventoryPage());
		inventoryPage.clickOnProductMenu();		
		Assert.assertTrue(productPage.verifyProductPage());
		productPage.clickOnCreateProductButton();
		Assert.assertTrue(createNewProductPage.verifyNewProductPage());
		Random rand = new Random();
		int randomNum = rand.nextInt(1000);
		String productName = "ShivamTestProduct"+randomNum;
		createNewProductPage.EnterProductName(productName);
		createNewProductPage.UpdateProductQuantityAndSaveProduct(ProductInfo.productQuantity);
		createNewProductPage.ClickHomeMenu();	
		homePage.clickOnManufacturingLink();
		Assert.assertTrue(manufacturingOrderPage.verifyManufacturingPage());
		manufacturingOrderPage.clickOnCreateButton();
		Assert.assertTrue(newManufacturingOrderPage.verifyNewManufacturingOrderPage());
		newManufacturingOrderPage.CreateNewManufactoringOrder(productName, ProductInfo.manufacturingQuantity);		
		Assert.assertEquals(newManufacturingOrderPage.getCreatedManufacturingOrderProduct(), productName);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
