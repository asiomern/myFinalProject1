package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Menu;
import pageObjects.CheckOutPage;
import pageObjects.LoginPage;
import pageObjects.MyCartPage;
import pageObjects.OverViewPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;
import pageObjects.ThankYouPage;

public class TestOverViewPage extends BaseTest {

	// Click cancel

	@Test

	public void clickCancel() {

		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Sauce Labs Bike Light");
		Menu mp = new Menu(driver);
		mp.enterCart();
		MyCartPage mcp = new MyCartPage(driver);
		mcp.checkOut();
		CheckOutPage cop = new CheckOutPage(driver);
		cop.fillInfo("Asi", "Nuralian", "12345");
		cop.continueBtn();
		OverViewPage ovp = new OverViewPage(driver);
		ovp.cancelBtn();
		pp = new ProductsPage(driver);
		AssertJUnit.assertTrue(pp.isProductsPage());

	}

	// Click finish

	@Test

	public void clickFinish() {

		Menu mp = new Menu(driver);
		mp.enterCart();
		MyCartPage mcp = new MyCartPage(driver);
		mcp.checkOut();
		CheckOutPage cop = new CheckOutPage(driver);
		cop.fillInfo("Asi", "Nuralian", "12345");
		cop.continueBtn();
		OverViewPage ovp = new OverViewPage(driver);
		ovp.finishBtn();
		ThankYouPage tp = new ThankYouPage(driver);
		AssertJUnit.assertTrue(tp.isThankYouPage());

	}

	// Click on product

	@Test

	public void clickOnProduct() {

		Menu mp = new Menu(driver);
		mp.allItemsOption();
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Sauce Labs Bolt T-Shirt");
		mp = new Menu(driver);
		mp.enterCart();
		MyCartPage mcp = new MyCartPage(driver);
		mcp.checkOut();
		CheckOutPage cop = new CheckOutPage(driver);
		cop.fillInfo("Asi", "Nuralian", "12345");
		cop.continueBtn();
		OverViewPage ovp = new OverViewPage(driver);
		ovp.enterProductPage("Sauce Labs Bolt T-Shirt");
		ProductPage prp = new ProductPage(driver);
		String actual = prp.isProductPage();
		String expected = "Sauce Labs Bolt T-Shirt";
		AssertJUnit.assertEquals(actual, expected);

	}

}
