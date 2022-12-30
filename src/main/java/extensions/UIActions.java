package extensions;

import utilities.CommonOperations;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UIActions extends CommonOperations {

    @Step("Click on Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Clear Text From Text Field")
    public static void clearText(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.clear();
    }

    @Step("Update Text In Text Field")
    public static void updateText(WebElement elem, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.sendKeys(value);
    }
}