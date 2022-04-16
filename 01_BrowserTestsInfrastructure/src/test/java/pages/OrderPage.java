package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver driver;

    private String url = "http://intershop6.skillbox.ru/product-category/catalog/";

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

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void add__contacts__information() {
        driver.findElement(nameInputLocator).sendKeys("Зина");
        driver.findElement(surnameInputLocator).sendKeys("Малышева");
        driver.findElement(addressInputLocator).sendKeys("ул. Кутузова 16");
        driver.findElement(cityInputLocator).sendKeys("Ульяновск");
        driver.findElement(stateInputLocator).sendKeys("Ульяновская область");
        driver.findElement(postCodeInputLocator).sendKeys("320456");
        driver.findElement(phoneNumberInputLocator).sendKeys("+79173063467");
    }

    public void add__contacts__information__negative() {
        driver.findElement(nameInputLocator).sendKeys("");
        driver.findElement(surnameInputLocator).sendKeys("");
        driver.findElement(addressInputLocator).sendKeys("ул. Кутузова 16");
        driver.findElement(cityInputLocator).sendKeys("Ульяновск");
        driver.findElement(stateInputLocator).sendKeys("Ульяновская область");
        driver.findElement(postCodeInputLocator).sendKeys("320456");
        driver.findElement(phoneNumberInputLocator).sendKeys("+79173063467");
    }

    public void authorization() {
        driver.findElement(inputNameAuthLocator).sendKeys("testing12@test.com");
        driver.findElement(inputPasswordAuthLocator).sendKeys("12345678");
    }

    public void add__coupon() {
        driver.findElement(couponInputLocator).sendKeys("sert500");
    }

    public void authorization__submit() {
        driver.findElement(authButtonLocator).click();
    }

    public void payment__upon__delivery() {
        driver.findElement(paymentMethodRadioButtonLocator).click();
    }

    public void forward__payment__bank() {
        driver.findElement(paymentSecondPaymentMethodRadioButtonLocator).click();
    }

    public void apply__coupon() {
        driver.findElement(addCouponButtonLocator).click();
    }

    public void get__discount() {
        driver.findElement(applyCouponButton).click();
    }

    public void confirm__order() {
        driver.findElement(orderByButtonLocator).click();
    }

    public void add__goods__scenario() {
        driver.findElement(catalogButtonLocator).click();
        driver.findElement(cardAddBasketButtonLocator).click();
        driver.findElement(cardMoreInformationLocator).click();
        driver.findElement(addOrderButtonLocator).click();
        driver.findElement(pleaseAuthButtonLocator).click();
    }

    public String get__header__text() {
        return driver.findElement(expectedHeaderLocator).getText();
    }

    public String get__coupon__header__text() {
        return driver.findElement(expectedCouponHeaderLocator).getText();
    }

    public String get__error__name__header__text() {
        return driver.findElement(errorNameExpectedHeaderLocator).getText();
    }

    public String get__error__surname__header__text() {
        return driver.findElement(errorSurnameExpectedHeaderLocator).getText();
    }
}
