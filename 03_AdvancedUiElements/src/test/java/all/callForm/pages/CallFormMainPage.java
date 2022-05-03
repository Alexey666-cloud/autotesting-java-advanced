package all.callForm.pages;
import all.basePage.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CallFormMainPage extends Page {
    private String url = "http://qa.skillbox.ru/module11/practice/feedbacksingle/";
    private JavascriptExecutor javascriptExecutor;

    private String calendar = ".vdp-datepicker";

    @FindBy(name = "phone")
    public WebElement phoneInput;
    @FindBy(css = ".baseButton")
    public WebElement submitButton;
    @FindBy(name = "from")
    public WebElement fromTime;
    @FindBy(name = "to")
    public WebElement toTime;
    @FindBy(css = ".firstModul__col:nth-of-type(1) .h2")
    public WebElement dateResultHeader;
    @FindBy(css = ".firstModul__col:nth-of-type(2) .h2")
    public WebElement timeResultHeader;
    @FindBy(linkText = "К сожалению, в это время мы отдыхаем, выберите другое время")
    public WebElement errorMessage;

    public CallFormMainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void addPhone() {
        phoneInput.sendKeys("+7 (956)156-34-32");
    }

    public void setDate(String date) {
        javascriptExecutor.executeScript(String.format("document.querySelector(\"%s\").__vue__.setDate(\"%s\")", calendar, date));

    }

    public String getDate() {
        return String.valueOf(javascriptExecutor.executeScript(String.format("return document.querySelector(\"%s\").__vue__.selectedDate", calendar)));
    }

    public void setFromTime(String value) {
        javascriptExecutor.executeScript("document.querySelector(\"[name=from]\").style = \"display:block;\"");
        var timeFrom = new Select(fromTime);
        timeFrom.selectByValue(value);
    }

    public void setToTime(String value) {
        javascriptExecutor.executeScript("document.querySelector(\"[name=to]\").style = \"display:block;\"");
        var timeTo = new Select(toTime);
        timeTo.selectByValue(value);
    }

    public String getDateResultHeader() {
        wait.until(i -> !dateResultHeader.getText().isEmpty());
        return dateResultHeader.getText();
    }

    public String getTimeResultHeader() {
        wait.until(i -> !timeResultHeader.getText().isEmpty());
        return timeResultHeader.getText();
    }

    public Boolean errorMessageIsDisplayed() {
       if (errorMessage.isDisplayed()) {
           return true;
       } else return false;
    }
}
