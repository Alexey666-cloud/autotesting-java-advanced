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
        page.get__entry();
        page.get__registration();
        page.add__name__reg();
        page.add__email__reg();
        page.add__password__reg();
        page.submit__registration();
        Assert.assertEquals(errorRegistrationIsMissed, expectedResult, page.get__header__done__registration());
    }

    //Проверка позитивного сценария авторизации
    @Test
    public void interShop__AuthorizationPage__AuthorizationTest() {
        var expectedHeader = "МОЙ АККАУНТ";
        var page = new RegistrationPage(driver);
        page.open();
        page.get__entry();
        page.add__name();
        page.add__password();
        page.submit__authorization();
        Assert.assertEquals(errorAuthorizationIsMissed, expectedHeader, page.get__header__done__auth());
    }

    //Проверка негативного сценария авторизации (оставить поле password пустым)
    @Test
    public void interShop__AuthorizationPage__NegativePasswordAuthorizationTest() {
        var expectedHeader = "Пароль обязателен.";
        var page = new RegistrationPage(driver);
        page.open();
        page.get__entry();
        page.get__name__negative__test();
        page.submit__authorization();
        Assert.assertEquals(errorAuthorizationNegativeIsDone, expectedHeader, page.get__header__error());
    }

    //Проверка негативного сценария авторизации (оставить поле name пустым)
    @Test
    public void interShop__AuthorizationPage__NegativeNameAuthorizationTest() {
        var expectedHeader = "Error: Имя пользователя обязательно.";
        var page = new RegistrationPage(driver);
        page.open();
        page.get__entry();
        page.add__password();
        page.submit__authorization();
        Assert.assertEquals(errorAuthorizationNegativeIsDone, expectedHeader, page.get__header__error());
    }
}