package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public By viewedProductsModuleLocator = By.cssSelector("#woocommerce_recently_viewed_products-2");

    public By htmlLocator = By.cssSelector("html");


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.navigate().to(url);
        return this;
    }

    public MainPage clickSeeProductButtonLocator(){
        seeProductButtonLocator.click();
        return this;
    }

    public MainPage clickCameraCardLocator(){
        cameraCardLocator.click();
        return this;
    }

    public MainPage clickTabletCardLocator(){
        tabletCardLocator.click();
        return this;
    }
}