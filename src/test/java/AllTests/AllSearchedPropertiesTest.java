package AllTests;

import PageObjects.BasePage;
import PageObjects.PropertySearchListingPage;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AllSearchedPropertiesTest extends BaseTest {

    BasePage basePage;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void validateAllSearchedPropertiesHasAValidTitleOnH2() throws InterruptedException
    {
        logger.info("Starting the test: validateAllSearchedPropertiesHasAValidTitleOnH2()");
        basePage = new BasePage(driver);
        basePage = basePage.setCityInitially();
        PropertySearchListingPage propertySearchListingPage = basePage.search("2bhk");
        propertySearchListingPage = propertySearchListingPage.selectApartmentInFilter();
        propertySearchListingPage = propertySearchListingPage.selectMinPriceByValue("1000000", "9000000");

        List<String> allPropertyTitles = propertySearchListingPage.getAllPropertyTitles();

        SoftAssert sa = new SoftAssert();

        for (String str : allPropertyTitles)
        {
            logger.info("Current title: " + str);
            sa.assertFalse(utils.isStringIsNullEmpty(str), "The following title is either empty or null");
        }

        sa.assertAll();
    }


}
