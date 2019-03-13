package PageObjects;

import Utilities.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    DriverUtils driverUtils;

    @FindBy(xpath = "//div[@id='SrchSelectDw']//input[@type='text' and @placeholder]")
    private WebElement searchbarMain;

    @FindBy(id = "hdrsrchtpbtn")
    private WebElement searchButton;

    //Fiters
    @FindBy(id = "house_type")
    private WebElement propertyTypeFilter;

    @FindBy(id = "budgetValueSetFilter")
    private WebElement budgetFilter;

    @FindBy(xpath = "//ul[@id='multicheck_filter']//input[@value='Apartment']/../label")
    private WebElement apartment;

    @FindBy(id = "Minlist")
    private WebElement minimumPriceDropDown;

    @FindBy(id = "Maxlist")
    private WebElement maximumPriceDropdown;

    @FindBy(id = "form-loader")
    private WebElement loadingImage;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, 30);
        driverUtils = new DriverUtils(driver);
    }

    public PropertySearchListingPage search(String keyword2search)
    {
        //wait.until(ExpectedConditions.elementToBeClickable(searchbarMain));
        //searchbarMain.clear();
        searchbarMain.sendKeys(keyword2search);
        searchButton.click();

        return new PropertySearchListingPage(driver);
    }

    public PropertySearchListingPage selectApartmentInFilter()
    {
        propertyTypeFilter.click();
        wait.until(ExpectedConditions.visibilityOf(apartment)).click();
        waitTillTheLoadingCircularIconGetsRemoved();

        return new PropertySearchListingPage(driver);
    }

    public PropertySearchListingPage selectMinPriceByValue(String minValue, String maxValue)
    {
        budgetFilter.click();
        driverUtils.SelectByValue(minimumPriceDropDown, "500000");
        waitTillTheLoadingCircularIconGetsRemoved();
        driverUtils.SelectByValue(maximumPriceDropdown, "10000000");
        waitTillTheLoadingCircularIconGetsRemoved();

        budgetFilter.click();

        return new PropertySearchListingPage(driver);
    }

    private BasePage waitTillTheLoadingCircularIconGetsRemoved()
    {
        wait.until(ExpectedConditions.invisibilityOf(loadingImage));
        return this;
    }


}
