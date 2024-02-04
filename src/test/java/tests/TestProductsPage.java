package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Menu;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;

public class TestProductsPage extends BaseTest {

	// Add product to cart

	@Test
	public void tc_01_addToCart() {

		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Sauce Labs Onesie");
		Menu mp = new Menu(driver);
		mp.enterCart();
		String actual = pp.productInCart();
		String expected = "Sauce Labs Onesie";
		AssertJUnit.assertEquals(actual, expected);
		driver.navigate().back();
	}

	// Remove product from cart

	@Test
	public void tc_02_removeFromCart() {
		ProductsPage pp = new ProductsPage(driver);
		pp.removeFromCart("Sauce Labs Onesie");
		Menu mp = new Menu(driver);
		mp.enterCart();
		ProductPage prp = new ProductPage(driver);
		driver.navigate().back();
		AssertJUnit.assertTrue(prp.isProductRemovedFromCart("Sauce Labs Onesie"));
		

	}

	// Enter to product page

	@Test
	public void tc_03_productPage() {
		ProductsPage pp = new ProductsPage(driver);
		pp.enterProductpage("Test.allTheThings() T-Shirt (Red)");
		ProductPage prp = new ProductPage(driver);
		String actual = prp.isProductPage();
		String expected = "Test.allTheThings() T-Shirt (Red)";
		AssertJUnit.assertEquals(actual, expected);
		driver.navigate().back();

	}

	// Sorting A to Z

	@Test
	public void tc_04_sortAtoZ() {
		ProductsPage pp = new ProductsPage(driver);

		pp.sortingAtoZ();
		AssertJUnit.assertTrue(pp.isSortAtoZ());

	}

	// Sorting Z to A

	@Test

	public void tc_05_sortZtoA() {

		ProductsPage pp = new ProductsPage(driver);

		pp.sortingZtoA();
		AssertJUnit.assertTrue(pp.isSortZtoA());

	}

	// Sorting Low to High

	@Test
	public void tc_06_sortLowtoHigh() {

		ProductsPage pp = new ProductsPage(driver);

		pp.sortLowToHigh();
		AssertJUnit.assertTrue(pp.isSortLowToHigh());

	}

	// Sorting High to Low

	@Test
	public void tc_07_sortHightoLow() {

		ProductsPage pp = new ProductsPage(driver);

		pp.sortHighToLow();
		AssertJUnit.assertTrue(pp.isSortHighToLow());

	}

}
