package webTesting;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOperations;
import utilities.ManagePages;
import workFlows.webFlows.googleSearchFlows;

import java.util.List;

@Listeners(utilities.listeners.class)

public class GoogleSearchSanityTest extends CommonOperations {

    final String url = "https://www.google.co.il/";
    final String browser = "chrome";
    final String firstSearchResultValue = "java";
    final String lastSearchResultNotIncludedValue = "Interview";
    final int timeout = 10;
    final int pageLoadTimeout = 10;


    @BeforeClass
    public void startWebSession() {
        initBrowser(browser, url, timeout, pageLoadTimeout);
        ManagePages.initWeb();
    }

    @Test(description = "test_01: Verify google search results")
    @Description("Test Description: Verify google search results for a given value")
    public void test_01_verifySearchResults() {
        googleSearchFlows.StartAGoogleSearch(firstSearchResultValue);
        List<String> displayedLinks = googleSearchFlows.getGoogleSearchResults();
        Assert.assertTrue(displayedLinks.get(0).contains(firstSearchResultValue));
        Verifications.verifyATextIsIncludedInAString(displayedLinks.get(0), firstSearchResultValue);
        Verifications.verifyATextIsNotIncludedInAString(displayedLinks.get(displayedLinks.size() - 1), lastSearchResultNotIncludedValue);
        softAssertion.assertAll("Not all your verification passed");
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }
}