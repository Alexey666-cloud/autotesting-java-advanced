package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    private String url = "http://intershop6.skillbox.ru/";

    @FindBy(linkText = "Войти")
    public WebElement enterButtonLocator;
    @FindBy(css = ".custom-register-button")
    public WebElement registrationButtonLocator;
    @FindBy(css = "#username")
    public WebElement nameInputLocator;
    @FindBy(css = "#reg_email")
    public WebElement emailInputLocator;
    @FindBy(css = "#password")
    public WebElement passwordInputLocator;
    @FindBy(css = "#reg_password")
    public WebElement passwordRegInputLocator;
    @FindBy(css = ".woocommerce-form-register__submit")
    public WebElement submitButtonLocator;
    @FindBy(css = ".content-page > div")
    public WebElement expectedHeaderLocator;
    @FindBy(css = "#username")
    public WebElement nameInputAuthLocator;
    @FindBy(css = "#reg_username")
    public WebElement nameInputRegLocator;
    @FindBy(css = "button[name=login]")
    public WebElement submitAuthButtonLocator;
    @FindBy(css = ".post-title")
    public WebElement expectedHeaderAuthLocator;
    @FindBy(css = ".woocommerce-error > li")
    public WebElement expectedErrorHeaderAuthLocator;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public String get__header__error() {
        return expectedErrorHeaderAuthLocator.getText();
    }

    public String get__header__done__registration() {
        return expectedHeaderLocator.getText();
    }

    public String get__header__done__auth() {
        return expectedHeaderAuthLocator.getText();
    }
}
