package all.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineInstituteAuthorizationPage extends Page{

    @FindBy(css = ".baseInput:nth-child(3) .baseInput__field")
    public WebElement loginInput;
    @FindBy(css = ".baseInput:nth-child(4) .baseInput__field")
    public WebElement passwordInput;
    @FindBy(css = ".pageAutorization__button")
    public WebElement submitButton;

    public OnlineInstituteAuthorizationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public OnlineInstituteMainPage authorization(String login, String password) {
        this.loginInput.sendKeys(login);
        this.passwordInput.sendKeys(password);
        submitButton.click();
        return new OnlineInstituteMainPage(driver, wait);
    }
}
