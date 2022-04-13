import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InterShopRegistrationAuthorizationTests {
    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "http://intershop6.skillbox.ru/";

    private String errorRegistrationIsMissed = "Регистрация не завершена";
    private String errorAuthorizationIsMissed = "Авторизация не завершена";
    private String errorAuthorizationNegativeIsDone = "Авторизация прошла успешно!";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

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

    //Проверка позитивного сценария регистрации
    @Test
    public void interShop__AuthorizationPage__RegistrationTest() {
        var expectedResult = "Регистрация завершена";
        driver.navigate().to(url);
        get__entry();
        get__registration();
        add__name__reg();
        add__email__reg();
        add__password__reg();
        submit__registration();
        Assert.assertEquals(errorRegistrationIsMissed, expectedResult, get__header__done__registration());
    }

    //Проверка позитивного сценария авторизации
    @Test
    public void interShop__AuthorizationPage__AuthorizationTest() {
        var expectedHeader = "МОЙ АККАУНТ";
        driver.navigate().to(url);
        get__entry();
        add__name();
        add__password();
        submit__authorization();
        Assert.assertEquals(errorAuthorizationIsMissed, expectedHeader, get__header__done__auth());
    }

    //Проверка негативного сценария авторизации (оставить поле password пустым)
    @Test
    public void interShop__AuthorizationPage__NegativePasswordAuthorizationTest() {
        var expectedHeader = "Пароль обязателен.";
        driver.navigate().to(url);
        get__entry();
        get__name__negative__test();
        submit__authorization();
        Assert.assertEquals(errorAuthorizationNegativeIsDone, expectedHeader,get__header__error());
    }

    //Проверка негативного сценария авторизации (оставить поле name пустым)
    @Test
    public void interShop__AuthorizationPage__NegativeNameAuthorizationTest() {
        var expectedHeader = "Error: Имя пользователя обязательно.";
        driver.navigate().to(url);
        get__entry();
        add__password();
        submit__authorization();
        Assert.assertEquals(errorAuthorizationNegativeIsDone, expectedHeader, get__header__error());
    }

    private void add__name() {
        driver.findElement(nameInputLocator).sendKeys("test@Localtest87.com");
    }

    private void add__name__reg() {
        driver.findElement(nameInputRegLocator).sendKeys("test@Localtest93348798.com");
    }

    private void add__password__reg() {
        driver.findElement(passwordRegInputLocator).sendKeys("12345678");
    }

    private void add__email__reg() {
        driver.findElement(emailInputLocator).sendKeys("test@Localtest4833h77587.com");
    }

    private void add__password() {
        driver.findElement(passwordInputLocator).sendKeys("12345678");
    }

    private void submit__registration() {
        driver.findElement(submitButtonLocator).click();
    }

    private void submit__authorization() {
        driver.findElement(submitAuthButtonLocator).click();
    }

    private void get__name__negative__test() {
        driver.findElement(nameInputAuthLocator).sendKeys("test@test.com");
    }

    private void get__entry() {
        driver.findElement(enterButtonLocator).click();
    }

    private void get__registration() {
        driver.findElement(registrationButtonLocator).click();
    }

    private String get__header__error() {
       return driver.findElement(expectedErrorHeaderAuthLocator).getText();
    }

    private String get__header__done__registration() {
       return driver.findElement(expectedHeaderLocator).getText();
    }

    private String get__header__done__auth() {
       return driver.findElement(expectedHeaderAuthLocator).getText();
    }
}