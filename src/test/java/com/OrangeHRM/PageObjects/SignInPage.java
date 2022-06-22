package com.OrangeHRM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage{
	
	protected WebDriver driver;
	/*
	 * The protected access modifier is accessible within package and outside the
	 * package but through inheritance only. The protected access modifier can be
	 * applied on the data member, method and constructor. It can't be applied on
	 * the class. It provides more accessibility than the default modifer.
	 */	
	
	// <input name="user_name" type="text" value="">
	  private By usernameBy = By.id("txtUsername");
	  // <input name="password" type="password" value="">
	  private By passwordBy = By.id("txtPassword");
	  // <input name="sign_in" type="submit" value="SignIn">
	  private By signinBy = By.id("btnLogin");
	
	
	  public SignInPage(WebDriver driver) {  // constructor
		this.driver = driver;
	}
	
	  /**
	    * Login as valid user
	    *
	    * @param userName
	    * @param password
	    * @return HomePage object
	    */
	  
	  public HomePage loginValidUser(String userName, String password) {
		    driver.findElement(usernameBy).sendKeys(userName);
		    driver.findElement(passwordBy).sendKeys(password);
		    driver.findElement(signinBy).click();
		    return new HomePage(driver);
		  }
	  
	  
	public WebElement getUserNameTextField() {
		return driver.findElement(usernameBy);
	}
	
	public void setUserNameTextField() {
		
	}

}
