package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class TestLogin extends BaseTest {

	// Login with a blank User name field
	@Test
	public void tc_01_blankUserNameField() {

		LoginPage lp = new LoginPage(driver);
		lp.login("","secret_sauce");
		String actual = lp.blankLoginFields();
		String expected = "Epic sadface: Username is required";
		AssertJUnit.assertEquals(actual, expected);
		driver.navigate().refresh();
		
		
	}

	
	// Login with a blank password field 
		@Test
		public void tc_02_blankPasswordField()  {

			LoginPage lp = new LoginPage(driver);
			lp.login("standard_user","");
			String actual = lp.blankLoginFields();
			String expected = "Epic sadface: Password is required";
			AssertJUnit.assertEquals(actual, expected);

		}

	
	// Login with a valid User name and wrong Password

	@Test
	public void tc_03_wrongPassLogin() {

		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauc");
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.wrongUserNameOrPassError();
		AssertJUnit.assertEquals(actual, expected);

	}

	// Login with a wrong User name and a valid Password
	@Test
	public void tc_04_wrongUserNameLogin() {

		LoginPage lp = new LoginPage(driver);
		lp.login("Asi", "secret_sauce");
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.wrongUserNameOrPassError();
		AssertJUnit.assertEquals(actual, expected);

	}
	
	//Login with a capital letters on User name and password 
	
	@Test
	public void tc_06_capitalLettersLogin() {
		
	LoginPage lp= new LoginPage(driver);
	lp.login("STANDARD_USER", "SECRET_SAUCE");
	String actual = lp.wrongUserNameOrPassError();
	String expected = "Epic sadface: Username and password do not match any user in this service";
	AssertJUnit.assertEquals(actual, expected);
		
	}

	// Login with a wrong User name and wrong Password

	@Test
	public void tc_05_wrongPassAndUserName() {

		LoginPage lp = new LoginPage(driver);
		lp.login("Asi", "1234");
		String actual = lp.wrongUserNameOrPassError();
		String expected = "Epic sadface: Username and password do not match any user in this service";
		AssertJUnit.assertEquals(actual, expected);

	}

	// Login with a valid User name and Password

	@Test
	public void tc_07_validLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		ProductsPage pp = new ProductsPage(driver);
		AssertJUnit.assertTrue(pp.isProductsPage());

	}
	
	
	


}
