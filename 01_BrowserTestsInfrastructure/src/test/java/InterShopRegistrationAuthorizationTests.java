import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class InterShopRegistrationAuthorizationTests extends TestBase {

    private String errorRegistrationIsMissed = "Регистрация не завершена";
    private String errorAuthorizationIsMissed = "Авторизация не завершена";
    private String errorAuthorizationNegativeIsDone = "Авторизация прошла успешно!";

    //Проверка позитивного сценария регистрации
    @Test
    public void interShop__AuthorizationPage__RegistrationTest() {
        var expectedResult = "Регистрация завершена";
        var page = new RegistrationPage(driver, wait);
        page.open();
        page.enterButtonLocator.click();
        page.registrationButtonLocator.click();
        page.nameInputRegLocator.sendKeys("test@Localtest815.com");
        page.emailInputLocator.sendKeys("test@Localtest48h77587.com");
        page.passwordRegInputLocator.sendKeys("12345678");
        page.submitButtonLocator.click();
        Assertions.assertEquals(expectedResult, page.get__header__done__registration(), errorRegistrationIsMissed);
    }

    //Проверка позитивного сценария авторизации
    @Test
    public void interShop__AuthorizationPage__AuthorizationTest() {
        var expectedHeader = "МОЙ АККАУНТ";
        var page = new RegistrationPage(driver, wait);
        page.open();
        page.enterButtonLocator.click();
        page.nameInputLocator.sendKeys("test@Localtest87.com");
        page.passwordInputLocator.sendKeys("12345678");
        page.submitAuthButtonLocator.click();
        Assertions.assertEquals(expectedHeader, page.get__header__done__auth(), errorAuthorizationIsMissed);
    }

    //Проверка негативного сценария авторизации (оставить поле password пустым)
    @Test
    public void interShop__AuthorizationPage__NegativePasswordAuthorizationTest() {
        var expectedHeader = "Пароль обязателен.";
        var page = new RegistrationPage(driver, wait);
        page.open();
        page.enterButtonLocator.click();
        page.nameInputAuthLocator.sendKeys("test@test.com");
        page.submitAuthButtonLocator.click();
        Assertions.assertEquals(expectedHeader, page.get__header__error(), errorAuthorizationNegativeIsDone);
    }

    //Проверка негативного сценария авторизации (оставить поле name пустым)
    @Test
    public void interShop__AuthorizationPage__NegativeNameAuthorizationTest() {
        var expectedHeader = "Error: Имя пользователя обязательно.";
        var page = new RegistrationPage(driver, wait);
        page.open();
        page.enterButtonLocator.click();
        page.passwordInputLocator.sendKeys("12345678");
        page.submitAuthButtonLocator.click();
        Assertions.assertEquals(expectedHeader, page.get__header__error(), errorAuthorizationNegativeIsDone);
    }
}