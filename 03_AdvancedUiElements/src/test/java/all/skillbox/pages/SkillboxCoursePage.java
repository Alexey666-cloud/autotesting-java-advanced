package all.skillbox.pages;
import all.basePage.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SkillboxCoursePage extends Page {
    private String url = "https://skillbox.ru/courses/";

    @FindBy(css = ".toggle-menu")
    public WebElement selectButton;
    @FindBy(css = ".cookies__button")
    public WebElement cookieButton;
    @FindBy(css = ".faculty-blank__title")
    public WebElement resultHeader;

    public SkillboxCoursePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public String getResultHeaderText() {
        wait.until(i -> !resultHeader.getText().isEmpty());
        return resultHeader.getText();
    }

    public void clickCookieButton() {
        wait.until(i -> cookieButton.isDisplayed());
        cookieButton.click();
    }
}
