import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InterShopCatalogPageTests {

    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "http://intershop6.skillbox.ru/product-category/catalog/";

    private String error_message = "Данные в корзине не соответствуют выбранной модели в каталоге";

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

    public By linkHouseholdEquipmentCatalogListLocator = By.linkText("Бытовая техника");
    public By addBasketButton = By.cssSelector(".product:nth-child(1) .button");
    public By moreInformationButtonLocator = By.cssSelector(".added_to_cart");
    public By expectedHeaderResultLocator = By.linkText("Стиральная машина BEKO WRE64P1BWW, фронтальная, 6кг, 800об/мин");
    public By addRefrigeratorBasketButton = By.cssSelector(".product:nth-child(10) .button");
    public By refrigeratorExpectedHeaderResultLocator = By.linkText("Холодильник БИРЮСА Б-M10, однокамерный, серебристый");
    public By addCatalogBasketButtonLocator = By.cssSelector(".product:nth-child(6) .button");
    public By catalogFirstExpectedHeaderResultLocator = By.linkText("LED телевизор XIAOMI Mi TV 4A 32 HD READY");
    public By paginationButtonFirthLocator = By.cssSelector(".next");
    public By addCatalogProductBasketButtonLocator = By.cssSelector(".product:nth-child(1) .button");
    public By catalogSecondExpectedHeaderResultLocator = By.linkText("SAMSUNG Galaxy S20 8/128Gb, SM-G980F, серый");
    public By tablesButtonLocator = By.linkText("Планшеты");
    public By expectedTablesHeaderLocator = By.linkText("iPad 2020 32gb wi-fi");
    public By watchButtonLocator = By.linkText("Часы");
    public By cardAddButtonLocator = By.cssSelector(".product:nth-child(2) .button");
    public By expectedWatchHeaderLocator = By.linkText("SAMSUNG Galaxy Watch 46мм, 1.3\", серебристый");
    public By electronicsButtonLocator = By.linkText("Электроника");
    public By electronicsPaginationButtonLocator = By.linkText("2");
    public By electronicsSecondAddBasketButtonLocator = By.cssSelector(".product:nth-child(6) .button");
    public By electronicsMoreInformationButtonLocator = By.cssSelector(".added_to_cart");
    public By expectedElectronicsFirstHeaderLocator = By.linkText("SAMSUNG Galaxy Watch 46мм, 1.3\", серебристый");
    public By expectedElectronicsSecondHeaderLocator = By.linkText("Фотоаппарат CANON EOS M50 kit ( 18-150 IS STM), черный");

    //Проверить добавление стиральной машины в корзину, в разделе "Бытовая техника"
    @Test
    public void interShop__CatalogPage__First__householdEquipment__AddBasketTest() {
        var expectedResult = "Стиральная машина BEKO WRE64P1BWW, фронтальная, 6кг, 800об/мин";
        driver.navigate().to(url);
        get__equipment__list();
        add__goods();
        get__information();
        Assert.assertEquals(error_message, expectedResult, get__equipment__header__card__text());
    }

    //Проверить добавление холодильника в корзину, в разделе "Бытовая техника"
    @Test
    public void interShop__CatalogPage__Second__householdEquipment__AddBasketTest() {
        var expectedResult = "Холодильник БИРЮСА Б-M10, однокамерный, серебристый";
        driver.navigate().to(url);
        get__equipment__list();
        add__refrigerator();
        get__information();
        Assert.assertEquals(error_message, expectedResult, get__refrigerator__header__card__text());
    }


    //Проверить добавление холодильника в корзину, в разделе "Бытовая техника"
    @Test
    public void interShop__CatalogPage__First__Catalog__AddBasketTest() {
        var expectedResult = "LED телевизор XIAOMI Mi TV 4A 32 HD READY";
        driver.navigate().to(url);
        add__goods__to__basket();
        get__information();
        Assert.assertEquals(error_message, expectedResult, get__first__header__result__text());
    }

    //Проверить работу пагинации, и добавления товара на крайней странице в разделе "Каталог"
    @Test
    public void interShop__CatalogPage__Second__Catalog__AddBasketTest() {
        var expectedResult = "SAMSUNG Galaxy S20 8/128Gb, SM-G980F, серый";
        driver.navigate().to(url);
        get__pagination__firth();
        add__catalog__product__basket();
        get__information();
        Assert.assertEquals(error_message, expectedResult, get__second__header__result__text());
    }

    //Проверить добавление товара в корзину, в разделе "Планшеты"
    @Test
    public void interShop__CatalogPage__Tables__AddBasketTest() {
        var expectedResult = "iPad 2020 32gb wi-fi";
        driver.navigate().to(url);
        add__tables();
        add__goods();
        get__information();
        Assert.assertEquals(error_message, expectedResult, get__tables__header__text());
    }

    //Проверить добавление товара в корзину, в разделе "Часы"
    @Test
    public void interShop__CatalogPage__Watch__AddBasketTest() {
        var expectedResult = "SAMSUNG Galaxy Watch 46мм, 1.3\", серебристый";
        driver.navigate().to(url);
        add__two__goods__to__basket();
        get__information();
        Assert.assertEquals(error_message, expectedResult, get__watch__header__text());
    }

    //Проверить работу пагинации, и добавления товара на крайней странице в разделе "Электроника"
    @Test
    public void interShop__CatalogPage__Electronics__AddBasketTest() {
        var firstExpectedResult = "SAMSUNG Galaxy Watch 46мм, 1.3\", серебристый";
        var secondExpectedResult = "Фотоаппарат CANON EOS M50 kit ( 18-150 IS STM), черный";
        driver.navigate().to(url);
        get_electronics__list();
        driver.findElement(electronicsPaginationButtonLocator).click();
        driver.findElement(cardAddButtonLocator).click();
        driver.findElement(electronicsSecondAddBasketButtonLocator).click();
        driver.findElement(electronicsMoreInformationButtonLocator).click();
        Assert.assertEquals(error_message, firstExpectedResult, driver.findElement(expectedElectronicsFirstHeaderLocator).getText());
        Assert.assertEquals(error_message, secondExpectedResult, driver.findElement(expectedElectronicsSecondHeaderLocator).getText());
    }

    private void get__information() {
        driver.findElement(moreInformationButtonLocator).click();
    }

    private void add__goods() {
        driver.findElement(addBasketButton).click();
    }

    private void get__equipment__list() {
        driver.findElement(linkHouseholdEquipmentCatalogListLocator).click();
    }

    private String get__equipment__header__card__text() {
        return driver.findElement(expectedHeaderResultLocator).getText();
    }

    private void add__refrigerator() {
        driver.findElement(addRefrigeratorBasketButton).click();
    }

    private String get__refrigerator__header__card__text() {
        return driver.findElement(refrigeratorExpectedHeaderResultLocator).getText();
    }

    private void add__goods__to__basket() {
        driver.findElement(addCatalogBasketButtonLocator).click();
    }

    private void add__two__goods__to__basket() {
        driver.findElement(watchButtonLocator).click();
        driver.findElement(cardAddButtonLocator).click();
        ;
    }

    private String get__first__header__result__text() {
        return driver.findElement(catalogFirstExpectedHeaderResultLocator).getText();
    }

    private void get__pagination__firth() {
        driver.findElement(paginationButtonFirthLocator).click();
    }

    private void add__tables() {
        driver.findElement(tablesButtonLocator).click();
        ;
    }

    private void add__catalog__product__basket() {
        driver.findElement(addCatalogProductBasketButtonLocator).click();
    }

    private void get_electronics__list() {
        driver.findElement(electronicsButtonLocator).click();;
    }

    private String get__second__header__result__text() {
        return driver.findElement(catalogSecondExpectedHeaderResultLocator).getText();
    }

    private String get__tables__header__text() {
        return driver.findElement(expectedTablesHeaderLocator).getText();
    }

    private String get__watch__header__text() {
        return driver.findElement(expectedWatchHeaderLocator).getText();
    }

}
