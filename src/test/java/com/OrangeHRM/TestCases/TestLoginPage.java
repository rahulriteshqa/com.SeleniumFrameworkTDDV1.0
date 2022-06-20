package com.OrangeHRM.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.HomePage;
import com.OrangeHRM.PageObjects.SignInPage;
import com.OrangeHRM.Utilities.DataHandlersExcel;
import com.OrangeHRM.Utilities.DataHandlersPropertiesFile;

import TestBase1.TestBase;

public class TestLoginPage extends TestBase {

	// SignInPage signInPage;
	// HomePage homePage;

	// String testDataSheetName=
	// DataHandlersPropertiesFile.readDataFromPropertiesFile(configFilePath,
	// "DataSheetName");

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
				AssertJUnit.assertTrue(true);

			} else {
				AssertJUnit.assertTrue(false);
			}
		} else if (exp.equals("invalid")) {

			if (res.equals(true)) {
				homePage.clickOngetwelcomeModalBox();
				homePage.clickOnLogoutLink();
				AssertJUnit.assertTrue(false);
			} else {
				AssertJUnit.assertTrue(true);
			}

		}

	}

	@Test(description = "Verify test functionality using Data Driven by Excel")
	public void testLoginUsingExcel() throws Exception, IOException {
		
		String dataFilePath = System.getProperty("user.dir") + "\\TestData\\data.xlsx";
		System.out.println(dataFilePath);

		String username1 = DataHandlersExcel.readExcelData(dataFilePath,0, 1, 0);
		System.out.println(username1);
		
		String password1 = DataHandlersExcel.readExcelData(dataFilePath,0, 1, 1);
		System.out.println(password1);

		SignInPage signInPage = new SignInPage(driver);
		HomePage homePage = signInPage.loginValidUser(username1, password1);
		Boolean res = homePage.getDashboardTextElement().isDisplayed();
		if (res.equals(true)) {
			homePage.clickOngetwelcomeModalBox();
			homePage.clickOnLogoutLink();
			AssertJUnit.assertTrue(true);
			DataHandlersExcel.writeDataToExcel(dataFilePath, 1, "Verify test functionality using Data Driven by Excel - TestPassed");

		} else {
			AssertJUnit.assertTrue(false);
			DataHandlersExcel.writeDataToExcel(dataFilePath, 1, "Verify test functionality using Data Driven by Excel - TestFailed");
		}
	}

}
