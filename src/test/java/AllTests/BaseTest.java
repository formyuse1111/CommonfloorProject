package AllTests;

import Utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class BaseTest {

    public WebDriver driver;
    public Utilities utils = new Utilities();
    private final Logger logger = Logger.getLogger(this.getClass());

    @Parameters("browserName")
    @BeforeTest
    public void setDriver(String browserName)
    {
        PropertyConfigurator.configure("src/log4j.properties");

        logger.info("Here's the browserName obtained from the testng.xml file: " + browserName);
        if(browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\All\\Documents\\Commonfloor\\src\\test\\java\\BrowserDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("chrome"))
        {
            logger.debug("Starting chrome!");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\All\\Documents\\Commonfloor\\src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            logger.info("Please provide a valid browserName in the testng.xml file");
            Assert.fail("Please provide a valid browserName in the testng.xml file");
        }

        driver.get("https://www.commonfloor.com/");
        driver.manage().window().maximize();

    }
}
