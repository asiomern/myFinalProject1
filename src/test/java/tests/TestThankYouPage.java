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
import pageObjects.ThankYouPage;

public class TestThankYouPage extends BaseTest {

	// Click back home button

	@Test

	public void backHome() {

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
		ovp.finishBtn();
		ThankYouPage typ = new ThankYouPage(driver);
		typ.backHomeBtn();
		pp= new ProductsPage(driver);
		AssertJUnit.assertTrue(pp.isProductsPage());

	}

}
