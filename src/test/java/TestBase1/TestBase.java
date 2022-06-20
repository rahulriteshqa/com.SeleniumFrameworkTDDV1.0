package TestBase1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.OrangeHRM.Utilities.DataHandlersPropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public String  configFilePath = System.getProperty("user.dir")+"\\Configuration\\config.properties";
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUpApp() throws IOException {
		
		//Reporter.log("=====Browser Session Started=====", true);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.get("https://www.ebay.com/");
		
		System.out.println(configFilePath);
		//String path = "D:\\IDE2020 projects\\com.SeleniumFrameworkTDDV1.0\\Configuration\\config.properties";
		String AppURL = DataHandlersPropertiesFile.readDataFromPropertiesFile(configFilePath,"url");
		
		
		/*
		 * DataHandlersPropertiesFile.writeDataToPropertiesFile(System.getProperty(
		 * "user.dir")+"\\Configuration\\writeToconfig.properties", "TCID",
		 * "My First TC", "Execution");
		 */
		
		driver.get(AppURL);
		
		
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
