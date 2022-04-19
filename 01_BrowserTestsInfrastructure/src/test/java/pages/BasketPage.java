package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

    private WebDriver driver;

    private String url = "http://intershop6.skillbox.ru/product-category/catalog/";

    @FindBy(css = ".product:nth-child(1) .button")
    public WebElement addProductButtonLocator;
    @FindBy(css = ".added_to_cart")
    public WebElement moreInformationProductButtonLocator;
    @FindBy(linkText = "ПЕРЕЙТИ К ОПЛАТЕ")
    public WebElement confirmOrderButtonLocator;
    @FindBy(css = ".post-title")
    public WebElement expectedHeaderResult;
    @FindBy(css = "#coupon_code")
    public WebElement inputCouponLocator;
    @FindBy(css = "[name=apply_coupon]")
    public WebElement buttonApplyCouponLocator;
    @FindBy(css = "strong bdi")
    public WebElement finalPriceLocator;
    @FindBy(css = ".woocommerce-error > li")
    public WebElement errorStringLocator;
    @FindBy(css = ".woocommerce-message")
    public WebElement expectedErrorStringLocator;
    @FindBy(css = ".cart-empty")
    public WebElement expectedHeaderLocator;

    public By deleteCouponButtonLocator = By.cssSelector("a.woocommerce-remove-coupon");
    public By deleteProductButtonLocator = By.linkText("×");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void delete__coupon() {
        driver.findElement(deleteCouponButtonLocator).click();
    }

    public void delete__product() {
        driver.findElement(deleteProductButtonLocator).click();
    }

    public String get__header__empty__basket() {
        return expectedHeaderLocator.getText();
    }

    public String get__error__text() {
        return expectedErrorStringLocator.getText();
    }

    public String get__error__text__with__delete__coupon() {
        return errorStringLocator.getText();
    }

    public String get__header__text__add__goods() {
        return expectedHeaderResult.getText();
    }
}