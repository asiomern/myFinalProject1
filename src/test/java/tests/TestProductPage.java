package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Menu;
import pageObjects.LoginPage;
import pageObjects.MyCartPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;

public class TestProductPage extends BaseTest {

	// back to products page

	@Test
	public void tc_01_backToProductsPage() {

		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		ProductsPage pp = new ProductsPage(driver);
		pp.enterProductpage("Sauce Labs Bolt T-Shirt");
		ProductPage prp = new ProductPage(driver);
		prp.backToProductsPage();
		pp = new ProductsPage(driver);
		pp.isProductsPage();
		AssertJUnit.assertTrue(pp.isProductsPage());

	}

	// Add to cart product

	@Test
	public void tc_02_addToCart() {
		ProductsPage pp = new ProductsPage(driver);
		pp.enterProductpage("Sauce Labs Bolt T-Shirt");
		ProductPage prp = new ProductPage(driver);
		prp.addToCart("sauce-labs-bolt-t-shirt");
		Menu mp = new Menu(driver);
		mp.enterCart();
		prp = new ProductPage(driver);
		AssertJUnit.assertTrue(prp.isProductAddedToCart("Sauce Labs Bolt T-Shirt"));
		driver.navigate().back();

	}

	// remove product from cart

	@Test
	public void tc_03_removeFromCart() {

		ProductPage prp = new ProductPage(driver);

		prp.removeFromCart("sauce-labs-bolt-t-shirt");
		Menu mp = new Menu(driver);
		mp.enterCart();
		prp = new ProductPage(driver);
		AssertJUnit.assertTrue(prp.isProductRemovedFromCart("Sauce Labs Bolt T-Shirt"));
		driver.navigate().back();

	}

	// enter to the cart page

	@Test

	public void tc_04_enterCartPage() {

		Menu mp = new Menu(driver);
		mp.enterCart();
		MyCartPage mcp = new MyCartPage(driver);
		String actual = mcp.isCartPage();
		String expected = "Description";
		AssertJUnit.assertEquals(actual, expected);

	}

}
