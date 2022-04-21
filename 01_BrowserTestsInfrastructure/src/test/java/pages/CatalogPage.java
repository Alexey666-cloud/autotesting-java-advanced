package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends Page{

    private String url = "http://intershop6.skillbox.ru/product-category/catalog/";

    @FindBy(linkText = "Бытовая техника")
    public WebElement linkHouseholdEquipmentCatalogListLocator;
    @FindBy(css = ".product:nth-child(1) .button")
    public WebElement addBasketButton;
    @FindBy(css = ".added_to_cart")
    public WebElement moreInformationButtonLocator;
    @FindBy(linkText = "Стиральная машина BEKO WRE64P1BWW, фронтальная, 6кг, 800об/мин")
    public WebElement expectedHeaderResultLocator;
    @FindBy(css = ".product:nth-child(10) .button")
    public WebElement addRefrigeratorBasketButton;
    @FindBy(linkText = "Холодильник БИРЮСА Б-M10, однокамерный, серебристый")
    public WebElement refrigeratorExpectedHeaderResultLocator;
    @FindBy(css = ".product:nth-child(6) .button")
    public WebElement addCatalogBasketButtonLocator;
    @FindBy(linkText = "LED телевизор XIAOMI Mi TV 4A 32 HD READY")
    public WebElement catalogFirstExpectedHeaderResultLocator;
    @FindBy(css = ".next")
    public WebElement paginationButtonFirthLocator;
    @FindBy(css = ".product:nth-child(1) .button")
    public WebElement addCatalogProductBasketButtonLocator;
    @FindBy(linkText = "SAMSUNG Galaxy S20 8/128Gb, SM-G980F, серый")
    public WebElement catalogSecondExpectedHeaderResultLocator;
    @FindBy(linkText = "Планшеты")
    public WebElement tablesButtonLocator;
    @FindBy(linkText = "iPad 2020 32gb wi-fi")
    public WebElement expectedTablesHeaderLocator;
    @FindBy(linkText = "Часы")
    public WebElement watchButtonLocator;
    @FindBy(css = ".product:nth-child(2) .button")
    public WebElement cardAddButtonLocator;
    @FindBy(linkText = "SAMSUNG Galaxy Watch 46мм, 1.3\", серебристый")
    public WebElement expectedWatchHeaderLocator;
    @FindBy(linkText = "Электроника")
    public WebElement electronicsButtonLocator;
    @FindBy(linkText = "2")
    public WebElement electronicsPaginationButtonLocator;
    @FindBy(css = ".product:nth-child(6) .button")
    public WebElement electronicsSecondAddBasketButtonLocator;
    @FindBy(css = ".added_to_cart")
    public WebElement electronicsMoreInformationButtonLocator;
    @FindBy(linkText = "SAMSUNG Galaxy Watch 46мм, 1.3\", серебристый")
    public WebElement expectedElectronicsFirstHeaderLocator;
    @FindBy(linkText = "Фотоаппарат CANON EOS M50 kit ( 18-150 IS STM), черный")
    public WebElement expectedElectronicsSecondHeaderLocator;

    public CatalogPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }



    public String get__second__header__result__text() {
        return catalogSecondExpectedHeaderResultLocator.getText();
    }

    public String get__first__header__result__text() {
        return catalogFirstExpectedHeaderResultLocator.getText();
    }

    public String get__refrigerator__header__card__text() {
        return refrigeratorExpectedHeaderResultLocator.getText();
    }

    public String get__equipment__header__card__text() {
        return expectedHeaderResultLocator.getText();
    }

    public String get__tables__header__text() {
        return expectedTablesHeaderLocator.getText();
    }

    public String get__watch__header__text() {
        return expectedWatchHeaderLocator.getText();
    }

    public String get__electronics__first__header__text() {
        return expectedElectronicsFirstHeaderLocator.getText();
    }

    public String get__electronics__second__header__text() {
        return expectedElectronicsSecondHeaderLocator.getText();
    }
}