import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.OrderPage;

public class InterShopMakingOrderPageTests extends TestBase{

    private String error__message = "Заказ оформлен! Так быть не должно!";
    private String message__order__is__not__done = "Заказ оформлен! Так быть не должно!";
    private String message__coupon__is__not__done = "Купон не применён!";

    //Ожидаемый результат для тестов interShop__MakingOrderPage__FirstPositiveOrderTest() и interShop__MakingOrderPage__SecondPositiveOrderTest()
    private String expectedResult = "Спасибо! Ваш заказ был получен.";

    //Негативный сценарий офрмления заказа: Оставить незаполнеными два поля first name и last name
    @Test
    public void interShop__MakingOrderPage__NegativeOrderTest() {
        var firstExpectedResult = "Имя для выставления счета обязательное поле.";
        var secondExpectedResult = "Фамилия для выставления счета обязательное поле.";
        var page = new OrderPage(driver);
        page.open();
        page.add__goods__scenario();
        page.authorization();
        page.authorization__submit();
        page.add__contacts__information__negative();
        page.payment__upon__delivery();
        page.confirm__order();
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.errorNameExpectedHeaderLocator));
        Assert.assertEquals(error__message, firstExpectedResult, page.get__error__name__header__text());
        Assert.assertEquals(error__message, secondExpectedResult, page.get__error__surname__header__text());
    }

    //Позитивный сценарий оформления заказа, с выбором способа оплаты "Оплата при доставке"
    @Test
    public void interShop__MakingOrderPage__FirstPositiveOrderTest() {
        var page = new OrderPage(driver);
        page.open();
        page.add__goods__scenario();
        page.authorization();
        page.authorization__submit();
        page.add__contacts__information();
        page.payment__upon__delivery();
        page.confirm__order();
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.expectedHeaderLocator));
        Assert.assertEquals(message__order__is__not__done, expectedResult, page.get__header__text());
    }

    //Позитивный сценарий оформления заказа, с выбором способа оплаты "Банковской картой"
    @Test
    public void interShop__MakingOrderPage__SecondPositiveOrderTest() {
        var page = new OrderPage(driver);
        page.open();
        page.add__goods__scenario();
        page.authorization();
        page.authorization__submit();
        page.add__contacts__information();
        page.forward__payment__bank();
        page.confirm__order();
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.expectedHeaderLocator));
        Assert.assertEquals(message__order__is__not__done, expectedResult, page.get__header__text());
    }

    //Добавить купон в форме оформления заказа
    @Test
    public void interShop__MakingOrderPage__AddCouponTest() {
        var expectedCouponHeader = "Coupon code applied successfully.";
        var page = new OrderPage(driver);
        page.open();
        page.add__goods__scenario();
        page.authorization();
        page.authorization__submit();
        page.add__contacts__information();
        page.apply__coupon();
        page.add__coupon();
        page.get__discount();
        Assert.assertEquals(message__coupon__is__not__done, expectedCouponHeader, page.get__coupon__header__text());
    }
}
