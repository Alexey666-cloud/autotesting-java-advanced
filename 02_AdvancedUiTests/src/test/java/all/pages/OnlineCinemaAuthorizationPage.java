package all.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineCinemaAuthorizationPage extends Page {

    private String url = "https://lm.skillbox.cc/qa_tester/module06/auth/index.html";

    @FindBy(css = "#email")
    public WebElement email;
    @FindBy(css = "#password")
    public WebElement password;
    @FindBy(css = ".form-submit")
    public WebElement submitButton;
    @FindBy(css = ".forgot-password")
    public WebElement forgotPasswordLink;
    @FindBy(css = "#forgot-email")
    public WebElement forgotPasswordEmailInput;
    @FindBy(css = ".form-row:nth-child(2) .form-submit")
    public WebElement submitButtonForgotPasswordForm;
    @FindBy(css = ".mail__message")
    public WebElement letterLink;

    public OnlineCinemaAuthorizationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void addEmail() {
        email.sendKeys("skillbox@test.ru");
    }

    public void addPassword() {
        password.sendKeys("qwerty!123");
    }

    public void addEmail__forgotPasswordForm() {
        forgotPasswordEmailInput.sendKeys("skillbox@test.ru");
    }
}
