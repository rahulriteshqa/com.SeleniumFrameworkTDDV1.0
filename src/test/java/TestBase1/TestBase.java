package TestBase1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.OrangeHRM.Utilities.DataHandlersPropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public String  configFilePath = System.getProperty("user.dir")+"\\Configuration\\config.properties";
	
	public String propertiesFilePath="./Configuration/config.properties";
	
	
	@BeforeClass
	public void setUpApp() throws IOException {
		
		String browserName = DataHandlersPropertiesFile.readDataFromPropertiesFile(propertiesFilePath,"browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Browser Name is not passed");
		}
		
		driver.manage().window().maximize();
		//Integer  = Integer.getInteger(DataHandlersPropertiesFile.readDataFromPropertiesFile(propertiesFilePath,"timeout"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.get("https://www.ebay.com/");
		
		System.out.println(propertiesFilePath);
		//String path = "D:\\IDE2020 projects\\com.SeleniumFrameworkTDDV1.0\\Configuration\\config.properties";
		String AppURL = DataHandlersPropertiesFile.readDataFromPropertiesFile(propertiesFilePath,"url");
		
		
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
