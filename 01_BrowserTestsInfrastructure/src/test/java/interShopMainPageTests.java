import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.Assertion;
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
        var page = new MainPage(driver, wait)
                .open();
        page.bookCardLocator.click();
        Assertions.assertEquals("КНИГИ", page.get__title(), error__message);
    }

    //Проверка перехода в раздел "Планшеты", кликая на карточку "Планшеты"
    @Test
    public void interShop__Homepage__tabletCardTest() {
        var page = new MainPage(driver, wait)
                .open()
                .clickTabletCardLocator();
        Assertions.assertEquals("ПЛАНШЕТЫ", page.get__title(), error__message);
    }

    //Проверка перехода в раздел "Фото/Видео", кликая на карточку "Фото/Видео"
    @Test
    public void interShop__Homepage__cameraCardTest() {
        var page = new MainPage(driver, wait)
                .open()
                .clickCameraCardLocator();
        Assertions.assertEquals("ФОТО/ВИДЕО", page.get__title(), error__message);
    }

    //Проверка перехода в раздел "Уже в продаже", кликая в карточке "Уже в продаже" на кнопку "Посмотреть товар"
    @Test
    public void interShop__Homepage__ProductButtonTest() {
        var page = new MainPage(driver, wait)
                .open()
                .clickSeeProductButtonLocator();
        Assertions.assertEquals("iPad 2020 32gb wi-fi", page.tabletTitleHeaderLocator.getText(), incorrect__tablet__message);
    }

    //Проверка появления модуля "Ранее просмотренные товары"
    @Test
    public void interShop__Homepage__viewedProductsModuleTest() {
        var mainPage = new MainPage(driver, wait)
                .open();
        var headerPanel = new HeaderPanel(driver, wait);
        mainPage.scrollPage__inTo__requiredBlock();
        mainPage.clickSeeProductButtonLocator();
        headerPanel.clickMainPageButtonLocator();

        Assertions.assertTrue(mainPage.viewedProductsModuleLocator.isDisplayed(), group__is__empty);
    }

    //Проверка указанного в разделе контакты, в футере странице телефона
    @Test
    public void footerPhoneTextTest() {
        var page = new MainPage(driver, wait)
                .open();
        driver.findElement(page.htmlLocator).sendKeys(Keys.END);
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.phoneTextLocator));
        Assertions.assertEquals("Телефон: +7-999-123-12-12", page.get__phone__sub__title(), incorrect__phone__message);
    }

    //Проверка указанного в разделе контакты, в футере странице e-mail
    @Test
    public void interShop__Homepage__footerEmailTextTest() {
        var page = new MainPage(driver, wait)
                .open();
        driver.findElement(page.htmlLocator).sendKeys(Keys.END);
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.emailTextLocator));
        Assertions.assertEquals("Email: skillbox@skillbox.ru", page.get__email__sub__title(), incorrect__phone__message);
    }
}