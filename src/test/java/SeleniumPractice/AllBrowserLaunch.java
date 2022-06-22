package SeleniumPractice;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.Utilities.DataHandlersPropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllBrowserLaunch {

	WebDriver driver;
	public String propertiesFilePath = "./Configuration/config.properties";

	@BeforeMethod()
	public void openBrowser() throws IOException {
		String browserName = DataHandlersPropertiesFile.readDataFromPropertiesFile(propertiesFilePath, "browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Browser Name is not passed");
		}

		driver.manage().window().maximize();

	}

	@Test(priority = 1, description = "TC 001 Learning to open the browser")
	public void performTest() throws IOException {
		driver.get("https://www.w3schools.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 2, description = "TC002 basic actions on webElements")
	public void basicActions() throws IOException {

		driver.get("https://letskodeit.teachable.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// https://www.selenium.dev/documentation/webdriver/waits/#explicit-wait -- 0

		/*
		 * Explicit wait IS the correct replacement for implicit waits. Selenium
		 * contributors have stated multiple times that implicit waits are a bad
		 * practice and should be avoided.
		 */
		// By practiceLink = By.xpath("//a[contains(text(),'Practice')]");
		// WebElement practiceLink =
		// driver.findElement(By.xpath("//a[contains(text(),'Practice')]"));
		// Initialize and wait till element(link) became clickable - timeout in 10
		// seconds
		WebElement practiceLink = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Practice')]")));
		// Print the first result
		System.out.println(practiceLink.getText());
		practiceLink.click(); // we can have a generic method for this

		WebElement newPracticeLink = waitForElementTobeClickable(10,
				driver.findElement(By.xpath("//a[@href='https://courses.letskodeit.com/practice']")));
		newPracticeLink.click();
	}
	
	
	@Test(priority=3,description="TC 003 Testing login page error")
	public void testLoginError() {
		driver.get("https://letskodeit.teachable.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Practice')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement(By.id("email")).sendKeys("rahul123");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("rahul@gmail.com");
		driver.findElement(By.id("password")).sendKeys("india@123");
		driver.findElement(By.name("commit")).click();
		WebElement loginError = driver.findElement(By.xpath("//div[contains(text(),'Your email or password is incorrect.')]"));
		Boolean res = loginError.isDisplayed();
		if(res==true) {
			Assert.assertTrue(true,"login error test Passed");
		}else {
			Assert.assertFalse(false, "login error test failed");
		}
	}

	public WebElement waitForElementTobeClickable(long time, WebElement locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(time))
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	@AfterMethod
	public void stopTest() {
		driver.quit();
	}
}
