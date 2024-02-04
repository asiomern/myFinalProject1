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
import pageObjects.ProductsPage;

public class TestCheckOutPage extends BaseTest {

	// Click continue with valid details

	@Test

	public void tc_01_validInfo() {

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
		AssertJUnit.assertTrue(ovp.isOverViewPage());
		driver.navigate().back();

	}

	// Click continue with blank First name field

	@Test

	public void tc_02_blankFirstName() {
		CheckOutPage cop = new CheckOutPage(driver);
		cop.fillInfo("", "Nuralian", "12345");
		cop.continueBtn();
		AssertJUnit.assertTrue(cop.missingFirstName());
		driver.navigate().refresh();

	}

	// Checkout with blank Last name name field

	@Test

	public void tc_03_blankLastName() {
		CheckOutPage cop = new CheckOutPage(driver);
		cop.fillInfo("Asi", "", "12345");
		cop.continueBtn();
		AssertJUnit.assertTrue(cop.missingLastName());
		driver.navigate().refresh();
	}

	// Checkout with blank Postal code field

	@Test

	public void tc_04_blankPostalCode() {

		CheckOutPage cop = new CheckOutPage(driver);
		cop.fillInfo("Asi", "Nuralian", "");
		cop.continueBtn();
		AssertJUnit.assertTrue(cop.missingPostalCode());
		driver.navigate().refresh();

	}

}
