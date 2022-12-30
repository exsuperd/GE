package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GoogleHomePage {

    @FindBy(how = How.NAME, using = "q")
    public WebElement googleSearchField;

    @FindBy(how = How.CSS, using = "input[name='btnK']")
    public List <WebElement> googleSearchButton;
}
