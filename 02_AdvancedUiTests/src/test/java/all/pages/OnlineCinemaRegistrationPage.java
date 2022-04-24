package all.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineCinemaRegistrationPage extends Page {

    private String url = "https://lm.skillbox.cc/qa_tester/module06/register/";

    @FindBy(css = "#name")
    public WebElement name;
    @FindBy(css = "#email")
    public WebElement email;
    @FindBy(css = "#password")
    public WebElement password;
    @FindBy(css = ".form-submit")
    public WebElement submitButton;
    @FindBy(css = ".swal2-header")
    public WebElement openEmail;
    @FindBy(linkText = "по ссылке")
    public WebElement linkToAuth;

    public OnlineCinemaRegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void addName() {
        name.sendKeys("skillbox@test.ru");
    }

    public void addEmail() {
        email.sendKeys("skillbox@test.ru");
    }

    public void addPassword() {
        password.sendKeys("qwerty!123");
    }
}
