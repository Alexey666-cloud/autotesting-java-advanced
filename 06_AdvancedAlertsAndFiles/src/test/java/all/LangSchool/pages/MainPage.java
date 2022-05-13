package all.LangSchool.pages;
import all.base.basePage.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {
    private String url = "https://lm.skillbox.cc/qa_tester/module08/practice2/";
    private JavascriptExecutor javascriptExecutor;

    @FindBy(id = "uploadInput")
    public WebElement uploadForm;
    @FindBy(css = "img[src*='no.png']")
    public WebElement failIcon;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void uploadFile(String file) {
        javascriptExecutor.executeScript("document.getElementById(\"uploadInput\").setAttribute(\"class\", \"bla-bla-bla\");");
        uploadForm.sendKeys(file);
    }
}
