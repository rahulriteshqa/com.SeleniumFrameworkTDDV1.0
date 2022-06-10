package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.HomePage;
import com.OrangeHRM.PageObjects.SignInPage;

import TestBase1.TestBase;

public class TestLoginPage extends TestBase {

	@DataProvider(name = "LoginData")
	public Object[][] getLoginCredentials() {

		return new Object[][] { { "Admin", "admin123", "valid" }, { "Anne", "admin1234", "invalid" }, };
	}

	/***
	 * Tests login feature
	 * 
	 * @throws InterruptedException
	 */

	@Test(description = "Verify the login functionality", dataProvider = "LoginData")
	public void testLogin(String userName, String password, String exp) throws InterruptedException {

		SignInPage signInPage = new SignInPage(driver);
		HomePage homePage = signInPage.loginValidUser(userName, password);
		Boolean res = homePage.getDashboardTextElement().isDisplayed();

		if (exp.equals("valid")) {

			if (res.equals(true)) {
				homePage.clickOngetwelcomeModalBox();
				homePage.clickOnLogoutLink();
				Assert.assertTrue(true);

			} else {
				Assert.assertTrue(false);
			}
		} else if(exp.equals("invalid")){
			
			if(res.equals(true)) {
				homePage.clickOngetwelcomeModalBox();
				homePage.clickOnLogoutLink();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}

		}

	}

}
