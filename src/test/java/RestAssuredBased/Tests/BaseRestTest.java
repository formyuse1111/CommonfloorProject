package RestAssuredBased.Tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseRestTest {

    @BeforeClass
    public void setup()
    {
        RestAssured.baseURI = "https://www.commonfloor.com";
    }
}
