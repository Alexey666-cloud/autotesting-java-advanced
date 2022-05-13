package all.Parrots.pages;

import all.base.basePage.Page;
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
    @FindBy(name = "email")
    public WebElement inputEmail;
    @FindBy(id = "sendMe")
    public WebElement submitButton;
    @FindBy(id = "anotherEmail")
    public WebElement switchEmail;


    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void switchToFrame() {
        driver.switchTo().frame(iframeElement);
    }

    public void addEmail() {
        inputEmail.sendKeys("test@skillbox.ru");
    }

    public String getInputEmailText() {
        return inputEmail.getText();
    }

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }

    public void switchToParrentFrame() {
        driver.switchTo().parentFrame();
    }
}
