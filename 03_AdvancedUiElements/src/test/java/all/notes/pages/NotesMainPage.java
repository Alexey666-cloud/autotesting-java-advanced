package all.notes.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotesMainPage extends Page {

    private String url = "http://qa.skillbox.ru/module15/bignotes/#/statistic";
    private JavascriptExecutor javascriptExecutor;

    private String cssCalendarLocator = ".vdp-datepicker";

    @FindBy(css = ".pageStatistic__date")
    public WebElement resultHeader;

    public NotesMainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public String getResultHeaderText() {
        return resultHeader.getText();
    }

    public void setDate(String date) {
        javascriptExecutor.executeScript(String.format("document.querySelector(\"%s\").__vue__.setDate(\"%s\")", cssCalendarLocator, date));

    }

    public String getDate() {
        return String.valueOf(javascriptExecutor.executeScript(String.format("return document.querySelector(\"%s\").__vue__.selectedDate", cssCalendarLocator)));
    }
}
