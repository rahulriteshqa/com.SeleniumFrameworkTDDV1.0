package TestBase1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUpApp() {
		
		//Reporter.log("=====Browser Session Started=====", true);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.get("https://www.ebay.com/");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	
	/*
	 * @Test public void preTest() {
	 * 
	 * }
	 */
	
	
	@AfterClass
	public void tearDownApp() {
		driver.quit();
		//Reporter.log("=====Browser Session End=====", true);
	}
}
