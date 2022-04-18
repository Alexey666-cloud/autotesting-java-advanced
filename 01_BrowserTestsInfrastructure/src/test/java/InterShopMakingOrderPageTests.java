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
        page.catalogButtonLocator.click();
        page.cardAddBasketButtonLocator.click();
        page.cardMoreInformationLocator.click();
        page.addOrderButtonLocator.click();
        page.pleaseAuthButtonLocator.click();
        page.inputNameAuthLocator.sendKeys("testing12@test.com");
        page.inputPasswordAuthLocator.sendKeys("12345678");
        page.authButtonLocator.click();
        page.nameInputLocator.sendKeys("");
        page.surnameInputLocator.sendKeys("");
        page.addressInputLocator.sendKeys("ул. Кутузова 16");
        page.cityInputLocator.sendKeys("Ульяновск");
        page.stateInputLocator.sendKeys("Ульяновская область");
        page.postCodeInputLocator.sendKeys("320456");
        page.phoneNumberInputLocator.sendKeys("+79173063467");
        page.paymentMethodRadioButtonLocator.click();
        page.orderByButtonLocator.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.errorNameExpectedHeaderLocatorWait));
        Assert.assertEquals(error__message, firstExpectedResult, page.get__error__name__header__text());
        Assert.assertEquals(error__message, secondExpectedResult, page.get__error__surname__header__text());
    }

    //Позитивный сценарий оформления заказа, с выбором способа оплаты "Оплата при доставке"
    @Test
    public void interShop__MakingOrderPage__FirstPositiveOrderTest() {
        var page = new OrderPage(driver);
        page.open();
        page.catalogButtonLocator.click();
        page.cardAddBasketButtonLocator.click();
        page.cardMoreInformationLocator.click();
        page.addOrderButtonLocator.click();
        page.pleaseAuthButtonLocator.click();
        page.inputNameAuthLocator.sendKeys("testing12@test.com");
        page.inputPasswordAuthLocator.sendKeys("12345678");
        page.authButtonLocator.click();
        page.nameInputLocator.sendKeys("Зина");
        page.surnameInputLocator.sendKeys("Малышева");
        page.addressInputLocator.sendKeys("ул. Кутузова 16");
        page.cityInputLocator.sendKeys("Ульяновск");
        page.stateInputLocator.sendKeys("Ульяновская область");
        page.postCodeInputLocator.sendKeys("320456");
        page.phoneNumberInputLocator.sendKeys("+79173063467");
        page.paymentMethodRadioButtonLocator.click();
        page.orderByButtonLocator.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.expectedHeaderLocatorWait));
        Assert.assertEquals(message__order__is__not__done, expectedResult, page.get__header__text());
    }

    //Позитивный сценарий оформления заказа, с выбором способа оплаты "Банковской картой"
    @Test
    public void interShop__MakingOrderPage__SecondPositiveOrderTest() {
        var page = new OrderPage(driver);
        page.open();
        page.catalogButtonLocator.click();
        page.cardAddBasketButtonLocator.click();
        page.cardMoreInformationLocator.click();
        page.addOrderButtonLocator.click();
        page.pleaseAuthButtonLocator.click();
        page.inputNameAuthLocator.sendKeys("testing12@test.com");
        page.inputPasswordAuthLocator.sendKeys("12345678");
        page.authButtonLocator.click();
        page.nameInputLocator.sendKeys("Зина");
        page.surnameInputLocator.sendKeys("Малышева");
        page.addressInputLocator.sendKeys("ул. Кутузова 16");
        page.cityInputLocator.sendKeys("Ульяновск");
        page.stateInputLocator.sendKeys("Ульяновская область");
        page.postCodeInputLocator.sendKeys("320456");
        page.phoneNumberInputLocator.sendKeys("+79173063467");
        page.paymentSecondPaymentMethodRadioButtonLocator.click();
        page.orderByButtonLocator.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.expectedHeaderLocatorWait));
        Assert.assertEquals(message__order__is__not__done, expectedResult, page.get__header__text());
    }

    //Добавить купон в форме оформления заказа
    @Test
    public void interShop__MakingOrderPage__AddCouponTest() {
        var expectedCouponHeader = "Coupon code applied successfully.";
        var page = new OrderPage(driver);
        page.open();
        page.catalogButtonLocator.click();
        page.cardAddBasketButtonLocator.click();
        page.cardMoreInformationLocator.click();
        page.addOrderButtonLocator.click();
        page.pleaseAuthButtonLocator.click();
        page.inputNameAuthLocator.sendKeys("testing12@test.com");
        page.inputPasswordAuthLocator.sendKeys("12345678");
        page.authButtonLocator.click();
        page.nameInputLocator.sendKeys("Зина");
        page.surnameInputLocator.sendKeys("Малышева");
        page.addressInputLocator.sendKeys("ул. Кутузова 16");
        page.cityInputLocator.sendKeys("Ульяновск");
        page.stateInputLocator.sendKeys("Ульяновская область");
        page.postCodeInputLocator.sendKeys("320456");
        page.phoneNumberInputLocator.sendKeys("+79173063467");
        page.addCouponButtonLocator.click();
        page.couponInputLocator.sendKeys("sert500");
        page.applyCouponButton.click();
        Assert.assertEquals(message__coupon__is__not__done, expectedCouponHeader, page.get__coupon__header__text());
    }
}
