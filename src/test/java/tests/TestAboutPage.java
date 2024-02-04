package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Menu;
import pageObjects.AboutPage;
import pageObjects.LoginPage;

public class TestAboutPage extends BaseTest {

	// Click on the “Try it free” button

	@Test
	public void tc_01_tryItFree() {

		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		Menu mp = new Menu(driver);
		mp.aboutoption();
		AboutPage ap = new AboutPage(driver);
		ap.tryItFree();
		AssertJUnit.assertTrue(ap.isTryItFreeTitlePage());
		driver.navigate().back();
		driver.navigate().refresh();

	}

	// Click on the “Request a Demo” button

	@Test
	public void tc_02_requestAdemo() {

		AboutPage ap = new AboutPage(driver);
		ap.requestAdemo();
		String actual = ap.isRequestAdemoPage();
		String expected = "Let us know what you’re looking for, and we’ll be in touch soon. Our experts can show you how Sauce Labs helps increase development velocity, reduce application risk, and deliver seamless customer experiences.";
		AssertJUnit.assertEquals(actual, expected);

	}

}
