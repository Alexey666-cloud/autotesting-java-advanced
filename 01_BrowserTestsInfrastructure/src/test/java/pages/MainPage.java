package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    public HeaderPanel headerPanel;

    private String url = "http://intershop6.skillbox.ru/";

    public By bookCardLocator = By.cssSelector("#accesspress_storemo-2 .caption");
    public By sectionBookTitleLocator = By.cssSelector("h1.entry-title.ak-container");
    public By tabletCardLocator = By.cssSelector("#accesspress_storemo-3 .caption");
    public By cameraCardLocator = By.cssSelector("#accesspress_storemo-4 .caption");
    public By seeProductButtonLocator = By.cssSelector(".promo-widget-wrap-full .btn.promo-link-btn");
    public By tabletTitleHeaderLocator = By.cssSelector(".product_title.entry-title");
    public By viewedProductsModuleLocator = By.cssSelector("#woocommerce_recently_viewed_products-2");
    public By phoneTextLocator = By.cssSelector(".text-5-value:nth-child(1)");
    public By htmlLocator = By.cssSelector("html");
    public By emailTextLocator = By.cssSelector(".text-5-value:nth-child(2)");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        headerPanel = new HeaderPanel(driver);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void get__book__card() {
        driver.findElement(bookCardLocator).click();
    }

    public void get__tablet__card() {
        driver.findElement(tabletCardLocator).click();
    }

    public void get__camera__card() {
        driver.findElement(cameraCardLocator).click();
    }

    public void get__discount__card() {
        driver.findElement(seeProductButtonLocator).click();
    }

    public void get__products() { driver.findElement(seeProductButtonLocator).click(); }

    public String get__title() {
        return driver.findElement(sectionBookTitleLocator).getText();
    }

    public String get__phone__sub__title() {
        return driver.findElement(phoneTextLocator).getText();
    }

    public String get__email__sub__title() {
        return driver.findElement(emailTextLocator).getText();
    }
}
