package all.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineInstitutePersonalPage extends Page {

    @FindBy(css = ".baseTabs__link:nth-child(2)")
    public WebElement deferredCourseLink;
    @FindBy(css = ".pagePersonal__button:nth-child(1)")
    public WebElement returnCoursesListButtonDeferred;
    @FindBy(css = ".pagePersonal__button")
    public WebElement returnCoursesListButton;
    @FindBy(css = ".pagePersonal__title")
    public WebElement personalHeader;

    public OnlineInstitutePersonalPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String getPersonalHeaderText() {
        return personalHeader.getText();
    }
}
