package com.OrangeHRM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object encapsulates the Home Page
 */
public class HomePage {
	
	protected WebDriver driver;
	
	//<a href="#" id="welcome" class="panelTrigger" xpath="1">Welcome Mayra</a>
	private By messageBy = By.xpath("//a[@id='welcome']");
	private By welcomeMenuBy = By.xpath("//div[@id='welcome-menu']");
	private By dashboardTextElementBy = By.xpath("//h1[contains(text(),'Dashboard')]");
	
	
	//constructor
	public HomePage(WebDriver driver){
	    this.driver = driver;
	    if (!driver.findElement(dashboardTextElementBy).isDisplayed()) {
	      throw new IllegalStateException("This is not Home Page of logged in user," +
	            " current page is: " + driver.getCurrentUrl());
	    }
	  }

	/**
	    * Get message (h1 tag)
	    *
	    * @return String message text
	    */
	  public String getMessageText() {
	    return driver.findElement(messageBy).getText();
	  }
	  
	  public WebElement getDashboardTextElement() {
		  return driver.findElement(dashboardTextElementBy);
	  }
	  
	  public HomePage manageProfile() {
		    // Page encapsulation to manage profile functionality
		    return new HomePage(driver);
		  }
		  /* More methods offering the services represented by Home Page
		  of Logged User. These methods in turn might return more Page Objects
		  for example click on Compose mail button could return ComposeMail class object */
		
}
