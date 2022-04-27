package all;
import all.pages.OnlineCinemaAuthorizationPage;
import all.pages.OnlineCinemaRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OnlineCinemaTests extends TestBase {

    private String errorMessage = "Заголовок не найден!";

    @Test
    public void authPage__messageLetterIsArrivedIsNotDisplayed__test() {
        //open authorization page&actions
        var pageAuth = new OnlineCinemaAuthorizationPage(driver, wait);
        pageAuth.open();
        // assert
        Assertions.assertFalse(pageAuth.isNotDisplayedForgotPasswordPopup(), "При открытии формы авторизации, отображается pop-up окно, с формой восстановления пароля!");
    }

    @Test
    public void positive__forgotPassword__scenario__test() {
        var expectedHeader = "skillbox@test.ru,";

        //open registration page&actions
        var pageReg = new OnlineCinemaRegistrationPage(driver, wait);
        pageReg.open();
        pageReg.addName();
        pageReg.addEmail();
        pageReg.addPassword();
        pageReg.submitButton.click();
        pageReg.openEmail.click();
        pageReg.linkToAuth.click();

        //open authorization page&actions
        var pageAuth = new OnlineCinemaAuthorizationPage(driver, wait);
        pageAuth.open();
        pageAuth.forgotPasswordLink.click();
        pageAuth.addEmail__forgotPasswordForm();
        pageAuth.submitButtonForgotPasswordForm.click();
        pageAuth.letterLink.click();

        // assert
        Assertions.assertEquals(expectedHeader, pageAuth.getNameHeaderText(), errorMessage);
    }

    @Test
    public void firstNegative__forgotPassword__scenario__test() {
        var expectedMessage = "Введите email";

        //open registration page&actions
        var pageReg = new OnlineCinemaRegistrationPage(driver, wait);
        pageReg.open();
        pageReg.addName();
        pageReg.addEmail();
        pageReg.addPassword();
        pageReg.submitButton.click();
        pageReg.openEmail.click();
        pageReg.linkToAuth.click();

        //open authorization page&actions
        var pageAuth = new OnlineCinemaAuthorizationPage(driver, wait);
        pageAuth.open();
        pageAuth.forgotPasswordLink.click();
        pageAuth.negative__addEmail__forgotPasswordForm();
        pageAuth.submitButtonForgotPasswordForm.click();
        pageAuth.isDisplayedErrorMessageText();

        // assert
        Assertions.assertEquals(expectedMessage, pageAuth.getErrorMessageText(), errorMessage);
    }

    private static Stream<Arguments> invalid__forgotPassword__scenario__test() {
        return Stream.of(
                arguments("234234234234"),
                arguments("sfsdfsfsfsfs")
        );
    }

    @ParameterizedTest
    @MethodSource("invalid__forgotPassword__scenario__test")
    public void secondNegative__forgotPassword__scenario__test(String email) {
        var expectedHeader = "Неверный email";

        //open registration page&actions
        var pageReg = new OnlineCinemaRegistrationPage(driver, wait);
        pageReg.open();
        pageReg.addName();
        pageReg.addEmail();
        pageReg.addPassword();
        pageReg.submitButton.click();
        pageReg.openEmail.click();
        pageReg.linkToAuth.click();

        //open authorization page&actions
        var pageAuth = new OnlineCinemaAuthorizationPage(driver, wait);
        pageAuth.open();
        pageAuth.forgotPasswordLink.click();
        pageAuth.forgotPasswordEmailInput.sendKeys(email);
        pageAuth.submitButtonForgotPasswordForm.click();
        pageAuth.isDisplayedErrorMessageText();

        // assert
        Assertions.assertEquals(expectedHeader, pageAuth.getErrorMessageText(), errorMessage);
    }
}
