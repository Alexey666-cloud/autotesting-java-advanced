package all.parrotName;
import all.base.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

    private String url = "http://qajava.skillbox.ru/module5/homework/";

    @FindBy(tagName = "iframe")
    public WebElement iframeElement;
    @FindBy(id = "boy")
    public WebElement boy;
    @FindBy(id = "girl")
    public WebElement girl;
    @FindBy(name = "email")
    public WebElement inputEmail;
    @FindBy(id = "sendMe")
    public WebElement submitButton;
    @FindBy(css = ".your-email")
    public WebElement resultTitle;
    @FindBy(css = ".form-error")
    public WebElement errorMessage;
    @FindBy(css = ".socialLinks__link:nth-of-type(1)")
    public WebElement facebookIcon;
    @FindBy(css = ".socialLinks__link:nth-of-type(2)")
    public WebElement vkIcon;
    @FindBy(css = ".socialLinks__link:nth-of-type(3)")
    public WebElement tweeterIcon;
    @FindBy(css = ".socialLinks__link:nth-of-type(4)")
    public WebElement instaIcon;
    @FindBy(css = ".footer__contactItem:nth-of-type(2)")
    public WebElement skillboxLink;
    @FindBy(css = ".header")
    public WebElement header;
    @FindBy(id = "form")
    public WebElement form;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {driver.navigate().to(url);}

    public void switchToFrame() {
        driver.switchTo().frame(iframeElement);
    }

    public void addEmail() {
      inputEmail.sendKeys("test@skillbox.ru");
    }

    public void addInvalidEmail(String value) {
        inputEmail.sendKeys(value);
    }

    public String getTitleText() {
        return resultTitle.getText();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }

    public void switchToParrentFrame() {
        driver.switchTo().parentFrame();
    }
}
