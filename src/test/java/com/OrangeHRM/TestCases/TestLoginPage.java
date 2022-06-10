package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.HomePage;
import com.OrangeHRM.PageObjects.SignInPage;

import TestBase1.TestBase;

public class TestLoginPage extends TestBase {

	@DataProvider(name="LoginData")
	public Object[][] getLoginCredentials() {

		return new Object[][] {
			   { "Admin", "admin123" },
			   //{ "Anne", "admin1234"},
			 };
			}

	

	/***
	 * Tests login feature
	 * @throws InterruptedException 
	 */
	

		@Test(description="Verify the login functionality", dataProvider="LoginData")
		public void testLogin(String userName, String password) throws InterruptedException {
			//setUpApp();
			SignInPage signInPage = new SignInPage(driver);
			HomePage homePage = signInPage.loginValidUser(userName,password);
			// assertThat(homePage.getMessageText(), is("Welcome Mayra"));
			//Thread.sleep(5000);
			Boolean res= homePage.getDashboardTextElement().isDisplayed();
			
			Assert.assertTrue(res);
			//tearDownApp();
		}

	}


