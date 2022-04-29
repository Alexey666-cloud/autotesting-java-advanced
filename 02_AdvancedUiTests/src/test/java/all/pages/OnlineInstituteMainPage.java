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

    @FindBy(css = ".baseCard")
    public WebElement courseCards;

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

    public OnlineInstituteCourseElement getCourseCard(int index) {
        return new OnlineInstituteCourseElement(driver, index);
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
}
