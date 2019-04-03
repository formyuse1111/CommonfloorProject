package RestAssuredBased.Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidateCurrentCityTest extends BaseRestTest {

    private final Logger logger = Logger.getLogger(this.getClass());

    @BeforeTest
    public void setupUri()
    {
        RestAssured.basePath="/nm";
    }

    @Test
    public void validateCityNameIsPresent()
    {
        Response resp =
        given()
            .queryParam("pageType", "SerpPage")
            .log().parameters()
        .when()
            .log().all()
            .get("/get-user-city-details")
        .then()
            .log().all()
            .assertThat().statusCode(200)
        .extract().response();

        String cityName = resp.jsonPath().get("cityName");
        logger.info("cityName: " + cityName);
        Assert.assertTrue(cityName != null && cityName.length() > 0, "[Failed] cityName isn't present");
        logger.debug("Completed");
    }

    @Test
    public void validateCityIdIsPresent()
    {
        Response response = given()
                .log().all()
               .queryParam("pageType", "SerpPage")
         .when()
                .get("/get-user-city-details")
        .then()
                .assertThat().statusCode(200)
        .extract().response();

        int cityId = response.jsonPath().get("cityId");
        logger.info("Retrieved cityId is: " + cityId);
        Assert.assertTrue(cityId > 0, "cityId is zero or -ve");
        logger.info("Completed successfully");
    }
}
