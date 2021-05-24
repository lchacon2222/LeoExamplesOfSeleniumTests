import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlanWebForm {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    // Test Cases URL 1

    @Test(testName = "Verify wrong user")
    public static void verifywronguser(){
        driver.get(Utils.BASE_URL1);
        WebForm webForm = new WebForm(driver);
        webForm.enterincorrectuser();
        webForm.entercorretpasswd();
        webForm.pressSubmitButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.verifyWrongUser();
    }

    @Test(testName = "Verify wrong password")
    public static void verifywrongpasswd(){
        driver.get(Utils.BASE_URL1);
        WebForm webForm = new WebForm(driver);
        webForm.entercorretuser();
        webForm.enterincorretpasswd();
        webForm.pressSubmitButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.verifyWrongPasswd();
    }

    @Test(testName = "Verify correct user and correct password")
    public static void verifycorrectuserandpasswd(){
        driver.get(Utils.BASE_URL1);
        WebForm webForm = new WebForm(driver);
        webForm.entercorretuser();
        webForm.entercorretpasswd();
        webForm.pressSubmitButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.verifyCorrectUserAndPasswd();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
