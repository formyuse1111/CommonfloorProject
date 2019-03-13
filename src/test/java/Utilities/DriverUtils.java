package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class DriverUtils {

    private WebDriver driver;
    private final Logger logger = Logger.getLogger(this.getClass());

    public DriverUtils(WebDriver driver)
    {
        this.driver = driver;
    }

    public void SelectByValue(WebElement element, String valueToSelect)
    {
        logger.debug("Going to SELECT by this value: " + valueToSelect);
        Select select = new Select(element);
        select.selectByValue(valueToSelect);
        logger.debug("Completed selecting this value: " + valueToSelect);
    }



}
