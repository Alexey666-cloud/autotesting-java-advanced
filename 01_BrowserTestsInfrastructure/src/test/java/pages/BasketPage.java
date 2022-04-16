package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    private WebDriver driver;

    private String url = "http://intershop6.skillbox.ru/product-category/catalog/";

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

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigate().to(url);
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
