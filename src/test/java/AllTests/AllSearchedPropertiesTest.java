package AllTests;

import PageObjects.BasePage;
import PageObjects.HomePage;
import PageObjects.PropertySearchListingPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AllSearchedPropertiesTest extends BaseTest {

    @Test
    public void validateAllSearchedPropertiesHasAValidTitleOnH2()
    {
        HomePage homePage = new HomePage(driver);
        homePage = homePage.setCityInitially();
        PropertySearchListingPage propertySearchListingPage = homePage.search("2bhk");
        propertySearchListingPage = propertySearchListingPage.selectApartmentInFilter();
        propertySearchListingPage = propertySearchListingPage.selectMinPriceByValue("1000000", "9000000");

        List<String> allPropertyTitles = propertySearchListingPage.getAllPropertyTitles();

        SoftAssert sa = new SoftAssert();

        for (String str : allPropertyTitles)
        {
            sa.assertFalse(utils.isStringIsNullEmpty(str), "The following title is either empty or null");
        }

        sa.assertAll();
    }


}
