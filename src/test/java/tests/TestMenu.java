package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Menu;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class TestMenu extends BaseTest {

	// enter to about option
	@Test
	public void tc_01_enterAboutPage() {

		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		Menu bm = new Menu(driver);
		bm.aboutoption();
		String actual = bm.aboutValidation();
		String expected = "CASE STUDIES";
		AssertJUnit.assertEquals(actual, expected);
		driver.navigate().back();
	}

	// Back to All Items page

	@Test

	public void tc_02_backToAllItems() {
		ProductsPage pp = new ProductsPage(driver);
		pp.enterProductpage("Sauce Labs Fleece Jacket");
		Menu bm = new Menu(driver);
		bm.allItemsOption();
		pp = new ProductsPage(driver);
		AssertJUnit.assertTrue(pp.isProductsPage());

	}

	// Enter to cart page

	@Test
	public void tc_03_enterToCartPage() {

		Menu mp = new Menu(driver);
		mp.enterCart();
		String actual= mp.isCartPage();
				String expected= "Description";
		AssertJUnit.assertEquals(actual, expected);

	}

	// logging out

	@Test
	public void tc_04_logOut() {
		Menu bm = new Menu(driver);
		bm.logOut();
		LoginPage lp = new LoginPage(driver);
		String actual = lp.logOutValidation();
		String expected = "Accepted usernames are:";
		AssertJUnit.assertEquals(actual, expected);

	}

}
