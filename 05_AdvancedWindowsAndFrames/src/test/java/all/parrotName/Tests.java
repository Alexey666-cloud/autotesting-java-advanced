package all.parrotName;
import all.base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Tests extends TestBase {

    @Test
    public void getBoyName__test() {
        //arrange
        var expectedTitle = "test@skillbox.ru";
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        //act
        page.boy.click();
        page.addEmail();
        page.submitButton.click();
        //assert
        var actualResult = page.getTitleText();
        Assertions.assertEquals(expectedTitle, actualResult, "Email тображается не коректно!");
    }

    @Test
    public void getGirlName__test() {
        //arrange
        var expectedTitle = "test@skillbox.ru";
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        //act
        page.girl.click();
        page.addEmail();
        page.submitButton.click();
        //assert
        var actualResult = page.getTitleText();
        Assertions.assertEquals(expectedTitle, actualResult, "Email тображается не коректно!");
    }

    private static Stream<Arguments> email_param() {
        return Stream.of(
                arguments("1231313131"),
                arguments("ываыаываыа")
        );
    }

    @ParameterizedTest
    @MethodSource("email_param")
    public void addInvalidEmail__firstAndSecond__test(String value) {
        //arrange
        var expectedErrorMessageText = "Некорректный email";
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        //act
        page.girl.click();
        page.addInvalidEmail(value);
        page.submitButton.click();
        //assert
        var actualResult = page.getErrorMessageText();
        Assertions.assertEquals(expectedErrorMessageText, actualResult, "Ошибка о некоректном email не отображается!");
    }

    @Test
    public void addInvalidEmail__third__test() {
        //arrange
        var expectedErrorMessageText = "Введите email";
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        //act
        page.girl.click();
        page.addInvalidEmail("");
        page.submitButton.click();
        //assert
        var actualResult = page.getErrorMessageText();
        Assertions.assertEquals(expectedErrorMessageText, actualResult, "Ошибка о некоректном email не отображается!");
    }

    @Test
    public void goToFacebookPage__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        page.switchToFrame();
        //act
        page.facebookIcon.click();
        //assert
        var actualWindowCount = getAllWindows();
        Assertions.assertEquals(2, actualWindowCount.size(), "Окно не открылось!");
    }

    @Test
    public void goToVkPage__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        page.switchToFrame();
        //act
        page.vkIcon.click();
        //assert
        var actualWindowCount = getAllWindows();
        Assertions.assertEquals(2, actualWindowCount.size(), "Окно не открылось!");
    }

    @Test
    public void goToTweeterPage__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        page.switchToFrame();
        //act
        page.tweeterIcon.click();
        //assert
        var actualWindowCount = getAllWindows();
        Assertions.assertEquals(2, actualWindowCount.size(), "Окно не открылось!");
    }

    @Test
    public void goToInstagramPage__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        page.switchToFrame();
        //act
        page.instaIcon.click();
        //assert
        var actualWindowCount = getAllWindows();
        Assertions.assertEquals(2, actualWindowCount.size(), "Окно не открылось!");
    }

    @Test
    public void footer__goToSkillboxLink__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        page.switchToFrame();
        //act
        page.skillboxLink.click();
        switchToFirstWindow();
        driver.close();
        switchToWindow(initialWindow);
        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, getAllWindows().size(), "Открылось более одного окна!")
        );
    }

    @Test
    public void getBoyName__andHeaderPannelIsDisplayed__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        //act
        page.boy.click();
        page.addEmail();
        page.submitButton.click();
        page.switchToParrentFrame();
        //assert
        var actualResult = page.header.isDisplayed();
        Assertions.assertTrue(actualResult, "Header не отображается!");
    }

    @Test
    public void submitEmptyInput__and__goToSkillboxLink___backToMainPage__and__errorMessageIsDisplayed__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        //act
        page.girl.click();
        page.submitButton.click();
        page.switchToFrame();
        page.skillboxLink.click();
        switchToFirstWindow();
        driver.close();
        switchToWindow(initialWindow);
        page.switchToFrame();
        //assert
        var actualResult = page.errorMessage.isDisplayed();
        Assertions.assertTrue(actualResult, "Сообщение об ошибке не отображается!");
    }

    @Test
    public void submitEmptyInput__and__goToSkillboxLink___backToMainPage__and__formIsDisplayed__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        page.switchToFrame();
        //act
        page.skillboxLink.click();
        switchToFirstWindow();
        driver.close();
        switchToWindow(initialWindow);
        page.switchToFrame();
        //assert
        var actualResult = page.form.isDisplayed();
        Assertions.assertTrue(actualResult, "Форма на главной странице не отображается!");
    }
}
