import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InterShopBasketPageTests {

    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "http://intershop6.skillbox.ru/product-category/catalog/";

    private String error__invalid__transition = "Произошёл переход не в тот раздел сайта";
    private String error__incorrect__amount = "Произошёл переход не в тот раздел сайта";
    private String error__not__message = "Не отображается сообщение об ошибке";
    private String error__not__message__delete__coupon = "Не отображается сообщение об удалении купона";
    private String error__goods__not__delete__on__basket = "Товар из корзины не удалился";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public By addProductButtonLocator = By.cssSelector(".product:nth-child(1) .button");
    public By moreInformationProductButtonLocator = By.cssSelector(".added_to_cart");
    public By confirmOrderButtonLocator = By.linkText("ПЕРЕЙТИ К ОПЛАТЕ");
    public By expectedHeaderResult = By.cssSelector(".post-title");
    public By inputCouponLocator = By.cssSelector("#coupon_code");
    public By buttonApplyCouponLocator = By.cssSelector("[name=apply_coupon]");
    public By finalPriceLocator = By.cssSelector("strong bdi");
    public By errorStringLocator = By.cssSelector(".woocommerce-error > li");
    public By deleteCouponButtonLocator = By.cssSelector("a.woocommerce-remove-coupon");
    public By expectedErrorStringLocator = By.cssSelector(".woocommerce-message");
    public By deleteProductButtonLocator = By.linkText("×");
    public By expectedHeaderLocator = By.cssSelector(".cart-empty");

    //Позитивный сценарий добавления товара в корзину, и перехода на страницу "Оформление заказа"
    @Test
    public void interShop__BasketPage__PositiveTest() {
        var expectedHeader = "ОФОРМЛЕНИЕ ЗАКАЗА";
        driver.navigate().to(url);
        add__product();
        get__information();
        confirm__order();
        Assert.assertEquals(error__invalid__transition, expectedHeader, get__header__text__add__goods());
    }

    //Проверка применения купона на странице "Корзина"
    @Test
    public void interShop__BasketPage__CouponApplicationTest() {
        var expectedResult = "34990,00₽";
        driver.navigate().to(url);
        add__product();
        get__information();
        add__valid__coupon();
        apply__coupon();
        var actualResult = driver.findElement(finalPriceLocator).getText();
        Assert.assertEquals(error__incorrect__amount, actualResult, expectedResult);
    }

    //Негативный сценарий. Ввести не корректный купон, в поле для купона, на странице "Корзина"
    @Test
    public void interShop__BasketPage__NegativeCouponApplicationTest() {
        var expectedErrorString = "Неверный купон.";
        driver.navigate().to(url);
        add__product();
        get__information();
        add__invalid__coupon();
        apply__coupon();
        Assert.assertEquals(error__not__message, expectedErrorString, get__error__text__with__delete__coupon());
    }

    //Проверка удаления купона из корзины
    @Test
    public void interShop__BasketPage__DeleteCouponTest() {
        var expectedCouponString = "Coupon has been removed.";
        driver.navigate().to(url);
        add__product();
        get__information();
        add__valid__coupon();
        apply__coupon();
        delete__coupon();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteCouponButtonLocator));
        Assert.assertEquals(error__not__message__delete__coupon, expectedCouponString, get__error__text());
    }

    //Проверка удаления товара из корзины
    @Test
    public void interShop__BasketPage__DeleteProductTest() {
        var expectedHeader = "Корзина пуста.";
        driver.navigate().to(url);
        add__product();
        get__information();
        delete__product();
        Assert.assertEquals(error__goods__not__delete__on__basket, expectedHeader, get__header__empty__basket());
    }

    public void add__valid__coupon() {
        driver.findElement(inputCouponLocator).sendKeys("sert500");
    }

    public void add__invalid__coupon() {
        driver.findElement(inputCouponLocator).sendKeys("sert3000");
    }

    public void add__product() {
        driver.findElement(addProductButtonLocator).click();
    }

    public void confirm__order() {
        driver.findElement(confirmOrderButtonLocator).click();
    }

    public void get__information() {
        driver.findElement(moreInformationProductButtonLocator).click();
    }

    public void apply__coupon() {
        driver.findElement(buttonApplyCouponLocator).click();
    }

    public void delete__coupon() {
        driver.findElement(deleteCouponButtonLocator).click();
    }

    public void delete__product() {
        driver.findElement(deleteProductButtonLocator).click();
    }

    public String get__header__empty__basket() {
        return driver.findElement(expectedHeaderLocator).getText();
    }

    public String get__error__text() {
        return driver.findElement(expectedErrorStringLocator).getText();
    }

    public String get__error__text__with__delete__coupon() {
        return driver.findElement(errorStringLocator).getText();
    }

    public String get__header__text__add__goods() {
        return driver.findElement(expectedHeaderResult).getText();
    }

}
