package AllTests;

import Utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;
    public Utilities utils = new Utilities();

    @Parameters("browserName")
    @BeforeTest
    public void setDriver(String browserName)
    {
        System.out.println("Here's the browserName obtained from the testng.xml file: " + browserName);
        if(browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\All\\Documents\\Commonfloor\\src\\test\\java\\BrowserDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\All\\Documents\\Commonfloor\\src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            Assert.fail("Please provide a valid browserName in the testng.xml file");
        }

        driver.get("https://www.commonfloor.com/");
        driver.manage().window().maximize();

    }
}
