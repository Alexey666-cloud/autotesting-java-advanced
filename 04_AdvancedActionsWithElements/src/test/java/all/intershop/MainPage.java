package all.intershop;
import all.basePage.Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

    @FindBy(id = "ak-top")
    public WebElement topButton;
    @FindBy(css = "html")
    public WebElement html;

    public NavigationPanel navigationPanel;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        this.navigationPanel = new NavigationPanel(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void scrollToTopButton() {
        for (int i = 0; i < 200; i++) {
            html.sendKeys(Keys.ARROW_DOWN);
        }
    }


    public Boolean topButtonIsDisplayed() {
        return topButton.isDisplayed();
    }
}

