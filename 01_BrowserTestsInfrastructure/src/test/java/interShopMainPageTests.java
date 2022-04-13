import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class interShopMainPageTests {

    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "http://intershop6.skillbox.ru/";

    private String error__message = "Заголовок раздела не соответствует выбранной карточке";
    private String incorrect__phone__message = "Заголовок раздела не соответствует выбранной карточке";
    private String incorrect__tablet__message = "Заголовок раздела не соответствует выбранной карточке";
    private String group__is__empty = "Раздел не появился";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 6);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public By bookCardLocator = By.cssSelector("#accesspress_storemo-2 .caption");
    public By sectionBookTitleLocator = By.cssSelector("h1.entry-title.ak-container");
    public By tabletCardLocator = By.cssSelector("#accesspress_storemo-3 .caption");
    public By cameraCardLocator = By.cssSelector("#accesspress_storemo-4 .caption");
    public By seeProductButtonLocator = By.cssSelector(".promo-widget-wrap-full .btn.promo-link-btn");
    public By tabletTitleHeaderLocator = By.cssSelector(".product_title.entry-title");
    public By viewedProductsModuleLocator = By.cssSelector("#woocommerce_recently_viewed_products-2");
    public By mainPageButtonLocator = By.cssSelector("#menu-item-26 > a");
    public By phoneTextLocator = By.cssSelector(".text-5-value:nth-child(1)");
    public By htmlLocator = By.cssSelector("html");


    //Проверка перехода в раздел "Книги", кликая на карточку "Книги"
    @Test
    public void interShop__Homepage__BookCardTest() {
        driver.navigate().to(url);
        get__book__card();
        Assert.assertEquals(error__message, "КНИГИ", get__title());
    }

    //Проверка перехода в раздел "Планшеты", кликая на карточку "Планшеты"
    @Test
    public void interShop__Homepage__tabletCardTest() {
        driver.navigate().to(url);
        get__tablet__card();
        Assert.assertEquals(error__message, "ПЛАНШЕТЫ", get__title());
    }

    //Проверка перехода в раздел "Фото/Видео", кликая на карточку "Фото/Видео"
    @Test
    public void interShop__Homepage__cameraCardTest() {
        driver.navigate().to(url);
        get__camera__card();
        Assert.assertEquals(error__message, "ФОТО/ВИДЕО", get__title());
    }

    //Проверка перехода в раздел "Уже в продаже", кликая в карточке "Уже в продаже" на кнопку "Посмотреть товар"
    @Test
    public void interShop__Homepage__ProductButtonTest() {
        driver.navigate().to(url);
        get__discount__card();
        Assert.assertEquals(incorrect__tablet__message, "iPad 2020 32gb wi-fi", driver.findElement(tabletTitleHeaderLocator).getText());
    }

    //Проверка появления модуля "Ранее просмотренные товары"
    @Test
    public void interShop__Homepage__viewedProductsModuleTest() {
        driver.navigate().to(url);
        get__products();
        wait.until(ExpectedConditions.presenceOfElementLocated(viewedProductsModuleLocator));
        Assert.assertTrue(group__is__empty, driver.findElement(viewedProductsModuleLocator).isDisplayed());
    }

    //Проверка указанного в разделе контакты, в футере странице телефона
    @Test
    public void footerPhoneTextTest() {
        driver.navigate().to(url);
        driver.findElement(htmlLocator).sendKeys(Keys.END);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneTextLocator));
        Assert.assertEquals(incorrect__phone__message, "Телефон: +7-999-123-12-12", get__phone__sub__title());
    }

    public By emailTextLocator = By.cssSelector(".text-5-value:nth-child(2)");

    //Проверка указанного в разделе контакты, в футере странице e-mail
    @Test
    public void interShop__Homepage__footerEmailTextTest() {
        driver.navigate().to(url);
        driver.findElement(htmlLocator).sendKeys(Keys.END);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextLocator));
        Assert.assertEquals(incorrect__phone__message, "Email: skillbox@skillbox.ru", get__email__sub__title());
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

    public void get__products() {
        driver.findElement(seeProductButtonLocator).click();
        driver.findElement(mainPageButtonLocator).click();
    }

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