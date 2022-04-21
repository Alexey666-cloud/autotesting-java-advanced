package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

    private String url = "http://intershop6.skillbox.ru/";

    @FindBy(css = "#accesspress_storemo-2 .caption")
    public WebElement bookCardLocator;

    @FindBy(css = "#accesspress_storemo-3 .caption")
    public WebElement tabletCardLocator;
    @FindBy(css = "#accesspress_storemo-4 .caption")
    public WebElement cameraCardLocator;
    @FindBy(css = ".promo-widget-wrap-full .btn.promo-link-btn")
    public WebElement seeProductButtonLocator;
    @FindBy(css = ".product_title.entry-title")
    public WebElement tabletTitleHeaderLocator;
    @FindBy(css = "#woocommerce_recently_viewed_products-2")
    public WebElement viewedProductsModuleLocator;

    public By htmlLocator = By.cssSelector("html");


    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.navigate().to(url);
        return this;
    }

    public MainPage clickSeeProductButtonLocator() {
        seeProductButtonLocator.click();
        return this;
    }

    public MainPage clickCameraCardLocator() {
        cameraCardLocator.click();
        return this;
    }

    public MainPage clickTabletCardLocator() {
        tabletCardLocator.click();
        return this;
    }

    public MainPage scrollPage__inTo__requiredBlock() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500)"); //y value '250' can be altered
        return this;
    }
}