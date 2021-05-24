import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlanWebForm2 {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    // Test Cases URL 2
    @Test(testName = "Random notification message rendered only one attempt")
    public static void clickhyperlinkmessage(){
        driver.get(Utils.BASE_URL2);
        WebForm2 webForm = new WebForm2(driver);
        webForm.presshyperlinktext();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.verifyActionSuccesful();
    }

    @Test(testName = "Random notification message rendered after two attempts")
    public static void clickhyperlinkmessage2(){
        driver.get(Utils.BASE_URL2);
        WebForm2 webForm = new WebForm2(driver);
        // try the first attempt
        webForm.presshyperlinktext();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.verifyActionSuccesful();
        // try a second attempt
        webForm.presshyperlinktext();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.verifyActionSuccesful();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}

