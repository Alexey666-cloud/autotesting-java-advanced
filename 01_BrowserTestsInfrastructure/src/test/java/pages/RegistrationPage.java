package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    private String url = "http://intershop6.skillbox.ru/";

    public By enterButtonLocator = By.linkText("Войти");
    public By registrationButtonLocator = By.cssSelector(".custom-register-button");
    public By nameInputLocator = By.cssSelector("#username");
    public By emailInputLocator = By.cssSelector("#reg_email");
    public By passwordInputLocator = By.cssSelector("#password");
    public By passwordRegInputLocator = By.cssSelector("#reg_password");
    public By submitButtonLocator = By.cssSelector(".woocommerce-form-register__submit");
    public By expectedHeaderLocator = By.cssSelector(".content-page > div");
    public By nameInputAuthLocator = By.cssSelector("#username");
    public By nameInputRegLocator = By.cssSelector("#reg_username");
    public By submitAuthButtonLocator = By.cssSelector("button[name=login]");
    public By expectedHeaderAuthLocator = By.cssSelector(".post-title");
    public By expectedErrorHeaderAuthLocator = By.cssSelector(".woocommerce-error > li");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void add__name() {
        driver.findElement(nameInputLocator).sendKeys("test@Localtest87.com");
    }

    public void add__name__reg() {
        driver.findElement(nameInputRegLocator).sendKeys("test@Localtest93348798.com");
    }

    public void add__password__reg() {
        driver.findElement(passwordRegInputLocator).sendKeys("12345678");
    }

    public void add__email__reg() {
        driver.findElement(emailInputLocator).sendKeys("test@Localtest4833h77587.com");
    }

    public void add__password() {
        driver.findElement(passwordInputLocator).sendKeys("12345678");
    }

    public void submit__registration() {
        driver.findElement(submitButtonLocator).click();
    }

    public void submit__authorization() {
        driver.findElement(submitAuthButtonLocator).click();
    }

    public void get__name__negative__test() {
        driver.findElement(nameInputAuthLocator).sendKeys("test@test.com");
    }

    public void get__entry() {
        driver.findElement(enterButtonLocator).click();
    }

    public void get__registration() {
        driver.findElement(registrationButtonLocator).click();
    }

    public String get__header__error() {
        return driver.findElement(expectedErrorHeaderAuthLocator).getText();
    }

    public String get__header__done__registration() {
        return driver.findElement(expectedHeaderLocator).getText();
    }

    public String get__header__done__auth() {
        return driver.findElement(expectedHeaderAuthLocator).getText();
    }
}
