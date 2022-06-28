package TestBase1;
import org.apache.logging.log4j.*;

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

	public static Logger demoLogger = LogManager.getLogger(TestBase.class.getName());
	public WebDriver driver;
	public String  configFilePath = System.getProperty("user.dir")+"\\Configuration\\config.properties";
	
	public String propertiesFilePath="./Configuration/config.properties";
	
	
	@BeforeClass
	public void setUpApp() throws IOException {
		
		demoLogger.info("fetching the browser type from config.properties file");
		String browserName = DataHandlersPropertiesFile.readDataFromPropertiesFile(propertiesFilePath,"browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			demoLogger.info("initializing the chrome driver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			demoLogger.info("initializing the firefox driver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			demoLogger.info("initializing the edge driver");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			demoLogger.info("No browser type is fetched from config.properties file");
		}
		
		driver.manage().window().maximize();
		demoLogger.debug("Maximizing the browser");
		//Integer  = Integer.getInteger(DataHandlersPropertiesFile.readDataFromPropertiesFile(propertiesFilePath,"timeout"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		demoLogger.debug("setting the implicit wait");
		//driver.get("https://www.ebay.com/");
		
		demoLogger.debug(propertiesFilePath);
		//System.out.println(propertiesFilePath);
		//String path = "D:\\IDE2020 projects\\com.SeleniumFrameworkTDDV1.0\\Configuration\\config.properties";
		String AppURL = DataHandlersPropertiesFile.readDataFromPropertiesFile(propertiesFilePath,"url");
		
		
		/*
		 * DataHandlersPropertiesFile.writeDataToPropertiesFile(System.getProperty(
		 * "user.dir")+"\\Configuration\\writeToconfig.properties", "TCID",
		 * "My First TC", "Execution");
		 */
		
		driver.get(AppURL);
		demoLogger.debug("opening the website for testing on the browser");
		
		
	}
	
	/*
	 * @Test public void preTest() {
	 * 
	 * }
	 */
	
	
	@AfterClass
	public void tearDownApp() {
		driver.quit();
		demoLogger.debug("closing the browser");
		//Reporter.log("=====Browser Session End=====", true);
	}
}
