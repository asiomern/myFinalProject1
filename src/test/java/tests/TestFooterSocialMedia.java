package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Footer;
import pageObjects.LoginPage;

public class TestFooterSocialMedia extends BaseTest {

	// enter to LinkEdin link

	@Test
	public void tc_01_linkedin() {
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		Footer f = new Footer(driver);
		AssertJUnit.assertTrue(f.validateLinkedin());

	}

	// enter to facebook link

	@Test
	public void tc_02_facebook() {
		Footer f = new Footer(driver);
		AssertJUnit.assertTrue(f.validateFacebook());

	}

	// enter to twitter link

	@Test
	public void tc_03_twitter() {

		Footer f = new Footer(driver);
		AssertJUnit.assertTrue(f.validateTwitter());

	}

}
