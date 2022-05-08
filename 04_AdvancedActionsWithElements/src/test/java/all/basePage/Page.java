package all.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    private String subUrl;
    private String url = "http://intershop5.skillbox.ru/";
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver, WebDriverWait wait, String subUrl) {
        this.driver = driver;
        this.wait = wait;
        this.subUrl = subUrl;
        PageFactory.initElements(driver, this);
    }

    public Page(WebDriver driver, WebDriverWait wait) {this(driver, wait, "");}

    public Page() {
    }

    public String getPageUrl() {
        return  url + subUrl;
    }

    public void  open() {
        driver.navigate().to(getPageUrl());
    }
}
