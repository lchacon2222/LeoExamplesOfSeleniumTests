// Page URL: https://formy-project.herokuapp.com/form
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.DeleteSession;
import org.openqa.selenium.support.FindBy;

public class WebForm extends PageObject{
    private final String CORRECT_USER = "tomsmith";
    private final String INCORRECT_USER = "LeoChacon";
    private final String CORRECT_PASSWD = "SuperSecretPassword!";
    private final String INCORRECT_PASSWD = "NoSuperSecretPassword!";

    // Elements URL 1
    @FindBy(id = "username")
    private WebElement varuser;

    @FindBy(id = "password")
    private WebElement varpasswd;

    @FindBy(xpath = "//i[contains(text(),'Login')]")
    private WebElement submit_button;

    @FindBy(xpath = "//div[contains(text(),'Your username is invalid!')]")
    private WebElement wronguser;

    @FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
    private WebElement wrongpasswd;

    @FindBy(xpath = "//div[contains(text(),'You logged into a secure area!')]")
    private WebElement correctuserandpasswd;

    // Methods URL 1

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void entercorretuser(){
        this.varuser.sendKeys(CORRECT_USER);
    }

    public void enterincorrectuser(){
        this.varuser.sendKeys(INCORRECT_USER);
    }

    public void entercorretpasswd(){
        this.varpasswd.sendKeys(CORRECT_PASSWD);
    }

    public void enterincorretpasswd(){
        this.varpasswd.sendKeys(INCORRECT_PASSWD);
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void verifyWrongUser(){
        this.wronguser.isDisplayed();
    }

    public void verifyWrongPasswd(){
        this.wrongpasswd.isDisplayed();
    }

    public void verifyCorrectUserAndPasswd(){
        this.correctuserandpasswd.isDisplayed();
    }

}
