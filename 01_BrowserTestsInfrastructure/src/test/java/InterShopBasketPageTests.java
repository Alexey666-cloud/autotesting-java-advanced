import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.BasketPage;

public class InterShopBasketPageTests extends TestBase {

    private String error__invalid__transition = "Произошёл переход не в тот раздел сайта";
    private String error__incorrect__amount = "Произошёл переход не в тот раздел сайта";
    private String error__not__message = "Не отображается сообщение об ошибке";
    private String error__not__message__delete__coupon = "Не отображается сообщение об удалении купона";
    private String error__goods__not__delete__on__basket = "Товар из корзины не удалился";

    //Позитивный сценарий добавления товара в корзину, и перехода на страницу "Оформление заказа"
    @Test
    public void interShop__BasketPage__PositiveTest() {
        var expectedHeader = "ОФОРМЛЕНИЕ ЗАКАЗА";
        var page = new BasketPage(driver, wait);
        page.open();
        page.addProductButtonLocator.click();
        page.moreInformationProductButtonLocator.click();
        page.confirmOrderButtonLocator.click();
        Assertions.assertEquals(expectedHeader, page.get__header__text__add__goods(), error__invalid__transition);
    }

    //Проверка применения купона на странице "Корзина"
    @Test
    public void interShop__BasketPage__CouponApplicationTest() {
        var expectedResult = "34990,00₽";
        var page = new BasketPage(driver, wait);
        page.open();
        page.addProductButtonLocator.click();
        page.moreInformationProductButtonLocator.click();
        page.inputCouponLocator.sendKeys("sert500");
        page.buttonApplyCouponLocator.click();
        var actualResult = page.finalPriceLocator.getText();
        Assertions.assertEquals(expectedResult, actualResult, error__incorrect__amount);
    }

    //Негативный сценарий. Ввести не корректный купон, в поле для купона, на странице "Корзина"
    @Test
    public void interShop__BasketPage__NegativeCouponApplicationTest() {
        var expectedErrorString = "Неверный купон.";
        var page = new BasketPage(driver, wait);
        page.open();
        page.addProductButtonLocator.click();
        page.moreInformationProductButtonLocator.click();
        page.inputCouponLocator.sendKeys("sert3000");
        page.buttonApplyCouponLocator.click();
        Assertions.assertEquals(expectedErrorString, page.get__error__text__with__delete__coupon(), error__not__message);
    }

    //Проверка удаления купона из корзины
    @Test
    public void interShop__BasketPage__DeleteCouponTest() {
        var expectedCouponString = "Coupon has been removed.";
        var page = new BasketPage(driver, wait);
        page.open();
        page.addProductButtonLocator.click();
        page.moreInformationProductButtonLocator.click();
        page.inputCouponLocator.sendKeys("sert500");
        page.buttonApplyCouponLocator.click();
        page.delete__coupon();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(page.deleteCouponButtonLocator));
        Assertions.assertEquals(expectedCouponString, page.get__error__text(), error__not__message__delete__coupon);
    }

    //Проверка удаления товара из корзины
    @Test
    public void interShop__BasketPage__DeleteProductTest() {
        var expectedHeader = "Корзина пуста.";
        var page = new BasketPage(driver, wait);
        page.open();
        page.addProductButtonLocator.click();
        page.moreInformationProductButtonLocator.click();
        page.delete__product();
        Assertions.assertEquals(expectedHeader, page.get__header__empty__basket(), error__goods__not__delete__on__basket);
    }
}