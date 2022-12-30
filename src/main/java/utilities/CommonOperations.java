package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CommonOperations extends Base {

    public static void initBrowser(String browserType, String url, int timeout, int pageLoadTimeout) {
        switch (browserType) {
            case ("chrome"):
                if (driver == null)
                driver = initChromeDriver();
                break;
            case ("firefox"):
                if (driver == null)
                driver = initIFFDriver();
                break;
            case ("internetExplorer"):
                if (driver == null)
                driver = initIEDriver();
                break;
            case ("edge"):
                if (driver == null)
                driver = initEdgeDriver();
                break;
            default:
                throw new RuntimeException(("Invalid browser name stated"));
        }
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds((timeout)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
        action = new Actions(driver);
        softAssertion = new SoftAssert();
    }
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    public static WebDriver initIFFDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }
    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
