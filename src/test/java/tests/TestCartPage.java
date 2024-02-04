package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Menu;
import pageObjects.CheckOutPage;
import pageObjects.LoginPage;
import pageObjects.MyCartPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;

public class TestCartPage extends BaseTest {

	// checkOut with empty cart

	@Test
	public void tc_01_checkOutEmptyCart() {

		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		Menu mp = new Menu(driver);
		mp.enterCart();
		MyCartPage mcp = new MyCartPage(driver);
		mcp.checkOut();
		CheckOutPage cop = new CheckOutPage(driver);
		AssertJUnit.assertTrue(cop.isCheckOutPage());
		driver.navigate().back();

	}

	// continue shopping

	@Test

	public void tc_02_continueShopping() {

		MyCartPage mcp = new MyCartPage(driver);
		mcp.continueShopping();
		ProductsPage pp = new ProductsPage(driver);
		AssertJUnit.assertTrue(pp.isProductsPage());

	}

	// remove product

	@Test

	public void tc_03_removeProduct() {
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Sauce Labs Onesie");
		Menu mp = new Menu(driver);
		mp.enterCart();
		MyCartPage mcp = new MyCartPage(driver);
		mcp.removeProduct("sauce-labs-onesie");
		ProductPage prp = new ProductPage(driver);
		AssertJUnit.assertTrue(prp.isProductRemovedFromCart("sauce-labs-onesie"));
		driver.navigate().back();

	}

	// Enter to product page via the product name on the cart product list

	@Test

	public void tc_04_enterProductPage() {
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Sauce Labs Bike Light");
		Menu mp = new Menu(driver);
		mp.enterCart();
		MyCartPage mcp = new MyCartPage(driver);
		mcp.enterProductPage("Sauce Labs Bike Light");
		ProductPage prp = new ProductPage(driver);
		String actual = prp.isProductPage();
		String expected = "Sauce Labs Bike Light";
		AssertJUnit.assertEquals(actual, expected);

	}
}
