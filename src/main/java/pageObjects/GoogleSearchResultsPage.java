package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GoogleSearchResultsPage {

    @FindBy(how = How.CSS, using = "#rso div.yuRUbf a")
    public List<WebElement> googleSearchResultsList;
}
