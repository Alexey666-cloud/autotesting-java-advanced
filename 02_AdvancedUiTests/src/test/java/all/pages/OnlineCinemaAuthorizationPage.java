package all.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class OnlineCinemaAuthorizationPage extends Page {

    private String url = "https://lm.skillbox.cc/qa_tester/module06/auth/index.html";

    @FindBy(css = ".forgot-password")
    public WebElement forgotPasswordLink;
    @FindBy(css = "#forgot-email")
    public WebElement forgotPasswordEmailInput;
    @FindBy(css = ".form-row:nth-child(2) .form-submit")
    public WebElement submitButtonForgotPasswordForm;
    @FindBy(css = ".mail__message")
    public WebElement letterLink;
    @FindBy(css = ".user__name")
    public WebElement nameHeader;
    @FindBy(css = ".form-error:nth-child(2)")
    public WebElement errorMessage;
    @FindBy(css = "#forgot-password-popup")
    public WebElement forgotPasswordPopup;

    public OnlineCinemaAuthorizationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void addEmail__forgotPasswordForm() {
        forgotPasswordEmailInput.sendKeys("skillbox@test.ru");
    }

    public void negative__addEmail__forgotPasswordForm() {
        forgotPasswordEmailInput.sendKeys("");
    }

    public String getNameHeaderText() {
        return nameHeader.getText();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public Boolean isDisplayedErrorMessageText() {
        try {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public Boolean isNotDisplayedForgotPasswordPopup() {
        try {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
            return forgotPasswordPopup.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(5, TimeUnit.SECONDS);
        }
    }
}
