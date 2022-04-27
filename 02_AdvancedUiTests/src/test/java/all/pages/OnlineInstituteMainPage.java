package all.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class OnlineInstituteMainPage extends Page {

    public OnlineInstituteHeaderPanel headerPanel;

    private String url = "http://qa.skillbox.ru/module16/maincatalog/";

    @FindBy(css = ".pageCreate__card:nth-child(1) .baseCard__button")
    public WebElement addFirstCourseCard;
    @FindBy(css = ".pageCreate__card:nth-child(8) .baseCard__button")
    public WebElement addLastCourseCard;
    @FindBy(css = ".baseCard")
    public WebElement courseCards;
    @FindBy(css = ".baseButton--blueFill")
    public WebElement thanksButton;

    public By allCourseCard = By.cssSelector(".baseCard");

    public OnlineInstituteMainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.headerPanel = new OnlineInstituteHeaderPanel(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public Boolean isDisplayedTextHeader() {
        try {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
            return courseCards.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public void waitForAllCardDisplayed() {
        var newWait = new WebDriverWait(driver, 4);
        newWait.until(driver -> driver.findElements(allCourseCard).size() == 8);
    }

    public Boolean waitForThanksButtonDisplayed() {
        try {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(10, TimeUnit.SECONDS);
            return thanksButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(5, TimeUnit.SECONDS);
        }
    }
}
