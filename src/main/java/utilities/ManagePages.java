package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.GoogleHomePage;
import pageObjects.GoogleSearchResultsPage;

public class ManagePages extends Base{
    public static void initWeb() {
        googleHomePage = PageFactory.initElements(driver, GoogleHomePage.class);
        googleSearchResults = PageFactory.initElements(driver, GoogleSearchResultsPage.class);
    }
}
