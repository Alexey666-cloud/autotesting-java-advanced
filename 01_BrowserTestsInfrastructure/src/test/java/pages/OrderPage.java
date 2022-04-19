package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    private WebDriver driver;

    private String url = "http://intershop6.skillbox.ru/product-category/catalog/";

    @FindBy(css = "#menu-item-46 > a")
    public WebElement catalogButtonLocator;
    @FindBy(css = ".product:nth-child(1) .button")
    public WebElement cardAddBasketButtonLocator;
    @FindBy(css = ".added_to_cart")
    public WebElement cardMoreInformationLocator;
    @FindBy(linkText = "ПЕРЕЙТИ К ОПЛАТЕ")
    public WebElement addOrderButtonLocator;
    @FindBy(linkText = "Авторизуйтесь")
    public WebElement pleaseAuthButtonLocator;
    @FindBy(css = "#username")
    public WebElement inputNameAuthLocator;
    @FindBy(css = "#password")
    public WebElement inputPasswordAuthLocator;
    @FindBy(css = "[name='login']")
    public WebElement authButtonLocator;
    @FindBy(css = "#billing_first_name")
    public WebElement nameInputLocator;
    @FindBy(css = "#billing_last_name")
    public WebElement surnameInputLocator;
    @FindBy(css = "#billing_address_1")
    public WebElement addressInputLocator;
    @FindBy(css = "#billing_city")
    public WebElement cityInputLocator;
    @FindBy(css = "#billing_state")
    public WebElement stateInputLocator;
    @FindBy(css = "#billing_postcode")
    public WebElement postCodeInputLocator;
    @FindBy(css = "#billing_phone")
    public WebElement phoneNumberInputLocator;
    @FindBy(css = "#payment_method_cod")
    public WebElement paymentMethodRadioButtonLocator;
    @FindBy(css = "#payment_method_bacs")
    public WebElement paymentSecondPaymentMethodRadioButtonLocator;
    @FindBy(css = "#place_order")
    public WebElement orderByButtonLocator;
    @FindBy(css = "[data-id='billing_last_name']")
    public WebElement errorSurnameExpectedHeaderLocator;
    @FindBy(css = "a[class='showcoupon']")
    public WebElement addCouponButtonLocator;
    @FindBy(css = "#coupon_code")
    public WebElement couponInputLocator;
    @FindBy(css = "[name='apply_coupon']")
    public WebElement applyCouponButton;
    @FindBy(css = ".woocommerce-message")
    public WebElement expectedCouponHeaderLocator;
    @FindBy(css = ".woocommerce-thankyou-order-received")
    public WebElement expectedHeaderLocator;
    @FindBy(css = "[data-id='billing_first_name']")
    public WebElement errorNameExpectedHeaderLocator;

    public By expectedHeaderLocatorWait = By.cssSelector(".woocommerce-thankyou-order-received");
    public By errorNameExpectedHeaderLocatorWait = By.cssSelector("[data-id='billing_first_name']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public String get__header__text() {
        return expectedHeaderLocator.getText();
    }

    public String get__coupon__header__text() {
        return expectedCouponHeaderLocator.getText();
    }

    public String get__error__name__header__text() {
        return errorNameExpectedHeaderLocator.getText();
    }

    public String get__error__surname__header__text() {
        return errorSurnameExpectedHeaderLocator.getText();
    }
}