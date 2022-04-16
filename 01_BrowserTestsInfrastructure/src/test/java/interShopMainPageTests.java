import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HeaderPanel;
import pages.MainPage;

public class interShopMainPageTests extends TestBase {

    private String error__message = "Заголовок раздела не соответствует выбранной карточке";
    private String incorrect__phone__message = "Заголовок раздела не соответствует выбранной карточке";
    private String incorrect__tablet__message = "Заголовок раздела не соответствует выбранной карточке";
    private String group__is__empty = "Раздел не появился";

    //Проверка перехода в раздел "Книги", кликая на карточку "Книги"
    @Test
    public void interShop__Homepage__BookCardTest() {
        var page = new MainPage(driver);
        page.open();
        page.get__book__card();
        Assert.assertEquals(error__message, "КНИГИ", page.get__title());
    }

    //Проверка перехода в раздел "Планшеты", кликая на карточку "Планшеты"
    @Test
    public void interShop__Homepage__tabletCardTest() {
        var page = new MainPage(driver);
        page.open();
        page.get__tablet__card();
        Assert.assertEquals(error__message, "ПЛАНШЕТЫ", page.get__title());
    }

    //Проверка перехода в раздел "Фото/Видео", кликая на карточку "Фото/Видео"
    @Test
    public void interShop__Homepage__cameraCardTest() {
        var page = new MainPage(driver);
        page.open();
        page.get__camera__card();
        Assert.assertEquals(error__message, "ФОТО/ВИДЕО", page.get__title());
    }

    //Проверка перехода в раздел "Уже в продаже", кликая в карточке "Уже в продаже" на кнопку "Посмотреть товар"
    @Test
    public void interShop__Homepage__ProductButtonTest() {
        var page = new MainPage(driver);
        page.open();
        page.get__discount__card();
        Assert.assertEquals(incorrect__tablet__message, "iPad 2020 32gb wi-fi", driver.findElement(page.tabletTitleHeaderLocator).getText());
    }

    //Проверка появления модуля "Ранее просмотренные товары"
    @Test
    public void interShop__Homepage__viewedProductsModuleTest() {
        var mainPage = new MainPage(driver);
        var headerPanel = new HeaderPanel(driver);
        mainPage.open();
        mainPage.get__products();
        headerPanel.clickMainPageButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(mainPage.viewedProductsModuleLocator));
        Assert.assertTrue(group__is__empty, driver.findElement(mainPage.viewedProductsModuleLocator).isDisplayed());
    }

    //Проверка указанного в разделе контакты, в футере странице телефона
    @Test
    public void footerPhoneTextTest() {
        var page = new MainPage(driver);
        page.open();
        driver.findElement(page.htmlLocator).sendKeys(Keys.END);
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.phoneTextLocator));
        Assert.assertEquals(incorrect__phone__message, "Телефон: +7-999-123-12-12", page.get__phone__sub__title());
    }

    //Проверка указанного в разделе контакты, в футере странице e-mail
    @Test
    public void interShop__Homepage__footerEmailTextTest() {
        var page = new MainPage(driver);
        page.open();
        driver.findElement(page.htmlLocator).sendKeys(Keys.END);
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.emailTextLocator));
        Assert.assertEquals(incorrect__phone__message, "Email: skillbox@skillbox.ru", page.get__email__sub__title());
    }
}