// Page URL: https://formy-project.herokuapp.com/form
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.DeleteSession;
import org.openqa.selenium.support.FindBy;

public class WebForm2 extends PageObject{

    // Elements URL 2

    @FindBy(xpath = "//a[contains(text(),'Click here')]")
    private WebElement submit_hyperlink;

    @FindBy(xpath = "//div[contains(text(),'Action successful')]")
    private WebElement actionsuccesful;

    @FindBy(xpath = "//div[contains(text(),'Action unsuccesful, please try again')]")
    private WebElement actionunsuccesful;

    // Methods URL 2

    public WebForm2(WebDriver driver) {
        super(driver);
    }

    public void presshyperlinktext(){
        this.submit_hyperlink.click();
    }

    public void verifyActionSuccesful(){
        try
        {
            this.actionunsuccesful.isDisplayed();
        }
        catch(Exception e)
        {
            this.actionsuccesful.isDisplayed();
            System.out.println("find Action Succesful");
        }
    }

    public void verifyActionUnsuccesful(){
        this.actionunsuccesful.isDisplayed();
    }
}
