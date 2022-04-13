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

public class InterShopMakingOrderPageTests {
    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "http://intershop6.skillbox.ru/product-category/catalog/";

    private String error__message = "Заказ оформлен! Так быть не должно!";
    private String message__order__is__not__done = "Заказ оформлен! Так быть не должно!";
    private String message__coupon__is__not__done = "Купон не применён!";

    //Ожидаемый результат для тестов interShop__MakingOrderPage__FirstPositiveOrderTest() и interShop__MakingOrderPage__SecondPositiveOrderTest()
    private String expectedResult = "Спасибо! Ваш заказ был получен.";


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

    public By catalogButtonLocator = By.cssSelector("#menu-item-46 > a");
    public By cardAddBasketButtonLocator = By.cssSelector(".product:nth-child(1) .button");
    public By cardMoreInformationLocator = By.cssSelector(".added_to_cart");
    public By addOrderButtonLocator = By.linkText("ПЕРЕЙТИ К ОПЛАТЕ");
    public By pleaseAuthButtonLocator = By.linkText("Авторизуйтесь");
    public By inputNameAuthLocator = By.cssSelector("#username");
    public By inputPasswordAuthLocator = By.cssSelector("#password");
    public By authButtonLocator = By.cssSelector("[name='login']");
    public By nameInputLocator = By.cssSelector("#billing_first_name");
    public By surnameInputLocator = By.cssSelector("#billing_last_name");
    public By addressInputLocator = By.cssSelector("#billing_address_1");
    public By cityInputLocator = By.cssSelector("#billing_city");
    public By stateInputLocator = By.cssSelector("#billing_state");
    public By postCodeInputLocator = By.cssSelector("#billing_postcode");
    public By phoneNumberInputLocator = By.cssSelector("#billing_phone");
    public By paymentMethodRadioButtonLocator = By.cssSelector("#payment_method_cod");
    public By paymentSecondPaymentMethodRadioButtonLocator = By.cssSelector("#payment_method_bacs");
    public By orderByButtonLocator = By.cssSelector("#place_order");
    public By expectedHeaderLocator = By.cssSelector(".woocommerce-thankyou-order-received");
    public By errorNameExpectedHeaderLocator = By.cssSelector("[data-id='billing_first_name']");
    public By errorSurnameExpectedHeaderLocator = By.cssSelector("[data-id='billing_last_name']");
    public By addCouponButtonLocator = By.cssSelector("a[class='showcoupon']");
    public By couponInputLocator = By.cssSelector("#coupon_code");
    public By applyCouponButton = By.cssSelector("[name='apply_coupon']");
    public By expectedCouponHeaderLocator = By.cssSelector(".woocommerce-message");

    //Негативный сценарий офрмления заказа: Оставить незаполнеными два поля first name и last name
    @Test
    public void interShop__MakingOrderPage__NegativeOrderTest() {
        var firstExpectedResult = "Имя для выставления счета обязательное поле.";
        var secondExpectedResult = "Фамилия для выставления счета обязательное поле.";
        driver.navigate().to(url);
        add__goods__scenario();
        authorization();
        authorization__submit();
        add__contacts__information__negative();
        payment__upon__delivery();
        confirm__order();
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorNameExpectedHeaderLocator));
        Assert.assertEquals(error__message, firstExpectedResult, get__error__name__header__text());
        Assert.assertEquals(error__message, secondExpectedResult, get__error__surname__header__text());
    }

    //Позитивный сценарий оформления заказа, с выбором способа оплаты "Оплата при доставке"
    @Test
    public void interShop__MakingOrderPage__FirstPositiveOrderTest() {
        driver.navigate().to(url);
        add__goods__scenario();
        authorization();
        authorization__submit();
        add__contacts__information();
        payment__upon__delivery();
        confirm__order();
        wait.until(ExpectedConditions.visibilityOfElementLocated(expectedHeaderLocator));
        Assert.assertEquals(message__order__is__not__done, expectedResult, get__header__text());
    }

    //Позитивный сценарий оформления заказа, с выбором способа оплаты "Банковской картой"
    @Test
    public void interShop__MakingOrderPage__SecondPositiveOrderTest() {
        driver.navigate().to(url);
        add__goods__scenario();
        authorization();
        authorization__submit();
        add__contacts__information();
        forward__payment__bank();
        confirm__order();
        wait.until(ExpectedConditions.visibilityOfElementLocated(expectedHeaderLocator));
        Assert.assertEquals(message__order__is__not__done, expectedResult, get__header__text());
    }

    //Добавить купон в форме оформления заказа
    @Test
    public void interShop__MakingOrderPage__AddCouponTest() {
        var expectedCouponHeader = "Coupon code applied successfully.";
        driver.navigate().to(url);
        add__goods__scenario();
        authorization();
        authorization__submit();
        add__contacts__information();
        apply__coupon();
        add__coupon();
        get__discount();
        Assert.assertEquals(message__coupon__is__not__done, expectedCouponHeader, get__coupon__header__text());
    }

    private void add__contacts__information() {
        driver.findElement(nameInputLocator).sendKeys("Зина");
        driver.findElement(surnameInputLocator).sendKeys("Малышева");
        driver.findElement(addressInputLocator).sendKeys("ул. Кутузова 16");
        driver.findElement(cityInputLocator).sendKeys("Ульяновск");
        driver.findElement(stateInputLocator).sendKeys("Ульяновская область");
        driver.findElement(postCodeInputLocator).sendKeys("320456");
        driver.findElement(phoneNumberInputLocator).sendKeys("+79173063467");
    }

    private void add__contacts__information__negative() {
        driver.findElement(nameInputLocator).sendKeys("");
        driver.findElement(surnameInputLocator).sendKeys("");
        driver.findElement(addressInputLocator).sendKeys("ул. Кутузова 16");
        driver.findElement(cityInputLocator).sendKeys("Ульяновск");
        driver.findElement(stateInputLocator).sendKeys("Ульяновская область");
        driver.findElement(postCodeInputLocator).sendKeys("320456");
        driver.findElement(phoneNumberInputLocator).sendKeys("+79173063467");
    }

    private void authorization() {
        driver.findElement(inputNameAuthLocator).sendKeys("testing12@test.com");
        driver.findElement(inputPasswordAuthLocator).sendKeys("12345678");
    }

    private void add__coupon() {
        driver.findElement(couponInputLocator).sendKeys("sert500");
    }

    private void authorization__submit() {
        driver.findElement(authButtonLocator).click();
    }

    private void payment__upon__delivery() {
        driver.findElement(paymentMethodRadioButtonLocator).click();
    }

    private void forward__payment__bank() {
        driver.findElement(paymentSecondPaymentMethodRadioButtonLocator).click();
    }

    private void apply__coupon() {
        driver.findElement(addCouponButtonLocator).click();
    }

    private void get__discount() {
        driver.findElement(applyCouponButton).click();
    }

    private void confirm__order() {
        driver.findElement(orderByButtonLocator).click();
    }

    private void add__goods__scenario() {
        driver.findElement(catalogButtonLocator).click();
        driver.findElement(cardAddBasketButtonLocator).click();
        driver.findElement(cardMoreInformationLocator).click();
        driver.findElement(addOrderButtonLocator).click();
        driver.findElement(pleaseAuthButtonLocator).click();
    }

    private String get__header__text() {
        return driver.findElement(expectedHeaderLocator).getText();
    }

    private String get__coupon__header__text() {
        return driver.findElement(expectedCouponHeaderLocator).getText();
    }

    private String get__error__name__header__text() {
        return driver.findElement(errorNameExpectedHeaderLocator).getText();
    }

    private String get__error__surname__header__text() {
        return driver.findElement(errorSurnameExpectedHeaderLocator).getText();
    }
}
