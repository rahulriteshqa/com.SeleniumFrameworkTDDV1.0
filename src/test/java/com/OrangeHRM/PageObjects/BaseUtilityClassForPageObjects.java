package com.OrangeHRM.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtilityClassForPageObjects {

	WebDriver driver;

	public BaseUtilityClassForPageObjects(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement waitForElementTobeClickable(long time, WebElement locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(time))
				.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
