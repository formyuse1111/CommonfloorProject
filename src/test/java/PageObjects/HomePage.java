package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "cityFormModal")
    private WebElement selectCityAlert;

    @FindBy(id = "citySuggestInputHomePopup")
    private WebElement citySearchbar;

    @FindBy(xpath = "//ul[@class='cityselectlist clearfix']/li[text()='Bangalore']")
    private WebElement suggestedCityBangalore;


    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage setCityInitially()
    {
        if(selectCityAlert.isDisplayed())
        {
            suggestedCityBangalore.click();
        }

        return new HomePage(driver);
    }







}
