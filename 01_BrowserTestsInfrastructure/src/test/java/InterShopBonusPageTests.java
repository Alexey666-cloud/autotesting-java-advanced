import org.junit.Assert;
import org.junit.Test;
import pages.BonusPage;

public class InterShopBonusPageTests extends TestBase {

    private String errorMessage = "Заголовок не найден!";

    @Test
    public void positive__scenario__test() {
        var page = new BonusPage(driver, wait);
        page.open();
        page.userName.sendKeys("Вася");
        page.phoneNumber.sendKeys("+79615441432");
        page.submitButton.click();
        page.waitForLoaderEnds();

        Assert.assertTrue(errorMessage, page.isDisplayedTextHeader());
    }

    @Test
    public void bonusPage__open__successResultMessageIsNotDisplayed() {
        var page = new BonusPage(driver, wait);
        page.open();
        Assert.assertFalse("При открытии страницы сразу отображается заголовок!", page.isNotDisplayedTextHeader());
    }

    @Test
    public void negative__name__empty__scenario__test() {
        var expectedResult = "Поле \"Имя\" обязательно для заполнения";
        var page = new BonusPage(driver, wait);
        page.open();
        page.userName.sendKeys("");
        page.phoneNumber.sendKeys("+79615441432");
        page.submitButton.click();
        Assert.assertEquals(errorMessage, expectedResult, page.getEmptyErrorMessage());
    }

    @Test
    public void negative__phone__empty__scenario__test() {
        var expectedResult = "Поле \"Телефон\" обязательно для заполнения";
        var page = new BonusPage(driver, wait);
        page.open();
        page.userName.sendKeys("Вася");
        page.phoneNumber.sendKeys("");
        page.submitButton.click();
        Assert.assertEquals(errorMessage, expectedResult, page.getEmptyErrorMessage());
    }

    @Test
    public void negative__empty__field__scenario__test() {
        var expectedResult = "Поле \"Имя\" обязательно для заполнения"
                + "\n"
                + "Поле \"Телефон\" обязательно для заполнения";
        var page = new BonusPage(driver, wait);
        page.open();
        page.userName.sendKeys("");
        page.phoneNumber.sendKeys("");
        page.submitButton.click();
        Assert.assertEquals(errorMessage, expectedResult, page.getEmptyErrorMessage());
    }

    @Test
    public void negative__invalid__format__scenario__test() {
        var expectedResult = "Введен неверный формат телефона";
        var page = new BonusPage(driver, wait);
        page.open();
        page.userName.sendKeys("+79615441432");
        page.phoneNumber.sendKeys("Вася");
        page.submitButton.click();
        Assert.assertEquals(errorMessage, expectedResult, page.getEmptyErrorMessage());
    }
}