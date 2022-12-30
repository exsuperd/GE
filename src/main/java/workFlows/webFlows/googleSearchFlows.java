package workFlows.webFlows;

import extensions.UIActions;
import org.openqa.selenium.WebElement;
import utilities.CommonOperations;
import io.qameta.allure.Step;
import pageObjects.GoogleHomePage;

import java.util.ArrayList;
import java.util.List;

public class googleSearchFlows extends CommonOperations {

    @Step("Search in Google")
    public static void StartAGoogleSearch(String searchValue) {
        UIActions.clearText(googleHomePage.googleSearchField);
        UIActions.updateText(googleHomePage.googleSearchField, "Java");
        UIActions.click(googleHomePage.googleSearchButton.get(1));
    }

    @Step("Search in Google")
    public static List<String> getGoogleSearchResults() {
        List<String> mainSearchResults = new ArrayList<>();
        for (WebElement elem : googleSearchResults.googleSearchResultsList) {
            if (elem.isDisplayed() && !elem.getAttribute("href").startsWith("https://translate")) {
                System.out.println(elem.getAttribute("href"));
                mainSearchResults.add(elem.getAttribute("href"));
            }
        }
        return mainSearchResults;
    }
}
