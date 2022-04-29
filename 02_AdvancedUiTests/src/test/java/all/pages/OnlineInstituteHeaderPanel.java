package all.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineInstituteHeaderPanel extends Page{
    @FindBy(css = ".baseHeader__button")
    public WebElement enterPersonalPage;
    @FindBy(css = ".baseHeader__name")
    public WebElement goToPersonalPage;

    public OnlineInstituteHeaderPanel(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
