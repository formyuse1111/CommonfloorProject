package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PropertySearchListingPage  extends BasePage {

    @FindBy(id = "total_result")
    private WebElement header1;

    @FindBy(xpath = "//div[@class='snb-tile']//h2/a[@href]")
    private List<WebElement> allPropertyTitles;

    public PropertySearchListingPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);

        //Assert.assertTrue(getHeader1Text().startsWith("Properties for sale in "), "Currently the Property Listing Page is NOT displayed");
    }

    public String getHeader1Text()
    {
        return header1.getText();
    }

    public List<String> getAllPropertyTitles()
    {
        List<String> allTitles = new ArrayList<String>();
        for (WebElement elem : allPropertyTitles)
        {
            allTitles.add(elem.getText());
        }

        return allTitles;
    }


}
