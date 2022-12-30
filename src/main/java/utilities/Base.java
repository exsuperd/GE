package utilities;

import pageObjects.GoogleHomePage;

import pageObjects.GoogleSearchResultsPage;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Base {
    public static WebDriver driver;
    public static Actions action;
    public static WebDriverWait wait;
    public static SoftAssert softAssertion;
    public static GoogleSearchResultsPage googleSearchResults;
    public static GoogleHomePage googleHomePage;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject RequestParameters = new JSONObject();
    public static JsonPath jp;
    public static Document doc;
}
