package apiTesting;

import extensions.Verifications;
import io.qameta.allure.Description;
import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.CommonOperations;
import workFlows.APIFlows.PublicAPIFlows;

import java.util.List;

@Listeners(utilities.listeners.class)

public class PublicAPIs extends CommonOperations {

    static final String apiURL = "https://api.publicapis.org/";
    static final String contentType = "json";
    final String resources = "entries?category=authentication";
    final int expectedCount = 7;
    final String expectedCategoryProperty = "Authentication & Authorization";
    final String counter = "count";

    @BeforeClass
    public void initAPI() {
        RestAssured.baseURI = apiURL;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/" + contentType);
        softAssertion = new SoftAssert();
    }

    @Test(description = "test_01: Verify a specific Category property occurrence")
    @Description("Test Description: Count & verify the number of notes with a specific given property")
    public void test_01_verifyNotesWithGivenProperty() {

        List<String> categoryProperty = PublicAPIFlows.getAndPrintListOfProperties(resources);
        int count = jp.get(counter);
        Verifications.compareIntValues(count, expectedCount);
        Verifications.repeatableTextInEachListIndex(categoryProperty, expectedCategoryProperty);
        softAssertion.assertAll("Not all verification passed");
    }
}
