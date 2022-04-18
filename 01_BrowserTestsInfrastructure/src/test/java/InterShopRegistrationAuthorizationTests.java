import org.junit.Assert;
import org.junit.Test;
import pages.RegistrationPage;

public class InterShopRegistrationAuthorizationTests extends TestBase {

    private String errorRegistrationIsMissed = "Регистрация не завершена";
    private String errorAuthorizationIsMissed = "Авторизация не завершена";
    private String errorAuthorizationNegativeIsDone = "Авторизация прошла успешно!";

    //Проверка позитивного сценария регистрации
    @Test
    public void interShop__AuthorizationPage__RegistrationTest() {
        var expectedResult = "Регистрация завершена";
        var page = new RegistrationPage(driver);
        page.open();
        page.enterButtonLocator.click();
        page.registrationButtonLocator.click();
        page.nameInputRegLocator.sendKeys("test@Localtest815.com");
        page.emailInputLocator.sendKeys("test@Localtest48h77587.com");
        page.passwordRegInputLocator.sendKeys("12345678");
        page.submitButtonLocator.click();
        Assert.assertEquals(errorRegistrationIsMissed, expectedResult, page.get__header__done__registration());
    }

    //Проверка позитивного сценария авторизации
    @Test
    public void interShop__AuthorizationPage__AuthorizationTest() {
        var expectedHeader = "МОЙ АККАУНТ";
        var page = new RegistrationPage(driver);
        page.open();
        page.enterButtonLocator.click();
        page.nameInputLocator.sendKeys("test@Localtest87.com");
        page.passwordInputLocator.sendKeys("12345678");
        page.submitAuthButtonLocator.click();
        Assert.assertEquals(errorAuthorizationIsMissed, expectedHeader, page.get__header__done__auth());
    }

    //Проверка негативного сценария авторизации (оставить поле password пустым)
    @Test
    public void interShop__AuthorizationPage__NegativePasswordAuthorizationTest() {
        var expectedHeader = "Пароль обязателен.";
        var page = new RegistrationPage(driver);
        page.open();
        page.enterButtonLocator.click();
        page.nameInputAuthLocator.sendKeys("test@test.com");
        page.submitAuthButtonLocator.click();
        Assert.assertEquals(errorAuthorizationNegativeIsDone, expectedHeader, page.get__header__error());
    }

    //Проверка негативного сценария авторизации (оставить поле name пустым)
    @Test
    public void interShop__AuthorizationPage__NegativeNameAuthorizationTest() {
        var expectedHeader = "Error: Имя пользователя обязательно.";
        var page = new RegistrationPage(driver);
        page.open();
        page.enterButtonLocator.click();
        page.passwordInputLocator.sendKeys("12345678");
        page.submitAuthButtonLocator.click();
        Assert.assertEquals(errorAuthorizationNegativeIsDone, expectedHeader, page.get__header__error());
    }
}