import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.BonusPage;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class InterShopBonusPageTests extends TestBase {

    private final String errorMessage = "Заголовок не найден!";

    private static Stream<Arguments> positive__scenario__test__data() {
        return Stream.of(
                arguments("Alexandr", "89341055132"),
                arguments("Вася", "+79341055132")
        );
    }

    @ParameterizedTest
    @MethodSource("positive__scenario__test__data")
    public void positive__scenario__test(String userName, String phoneNumber) {
        var page = new BonusPage(driver, wait);
        page.open();
        page.userName.sendKeys(userName);
        page.phoneNumber.sendKeys(phoneNumber);
        page.submitButton.click();

        page.waitForLoaderEnds();

        Assertions.assertAll(
                () -> Assertions.assertTrue(page.isDisplayedTextHeader(), errorMessage)
        );
    }

    @Test
    public void bonusPage__open__successResultMessageIsNotDisplayed() {
        var page = new BonusPage(driver, wait);
        page.open();
        Assertions.assertFalse(page.isNotDisplayedTextHeader(), "При открытии страницы сразу отображается заголовок!");
    }

    @Test
    public void negative__name__empty__scenario__test() {
        var expectedResult = "Поле \"Имя\" обязательно для заполнения";
        var page = new BonusPage(driver, wait);
        page.open();
        page.userName.sendKeys("");
        page.phoneNumber.sendKeys("+79615441432");
        page.submitButton.click();
        Assertions.assertEquals(expectedResult, page.getEmptyErrorMessage(), errorMessage);
    }

    @Test
    public void negative__phone__empty__scenario__test() {
        var expectedResult = "Поле \"Телефон\" обязательно для заполнения";
        var page = new BonusPage(driver, wait);
        page.open();
        page.userName.sendKeys("Вася");
        page.phoneNumber.sendKeys("");
        page.submitButton.click();
        Assertions.assertEquals(expectedResult, page.getEmptyErrorMessage(), errorMessage);
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
        Assertions.assertEquals(expectedResult, page.getEmptyErrorMessage(), errorMessage);
    }

    @Test
    public void negative__invalid__format__scenario__test() {
        var expectedResult = "Введен неверный формат телефона";
        var page = new BonusPage(driver, wait);
        page.open();
        page.userName.sendKeys("+79615441432");
        page.phoneNumber.sendKeys("Вася");
        page.submitButton.click();
        Assertions.assertEquals(expectedResult, page.getEmptyErrorMessage(), errorMessage);
    }
}