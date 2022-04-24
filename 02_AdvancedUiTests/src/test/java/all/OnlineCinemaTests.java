package all;

import all.pages.OnlineCinemaAuthorizationPage;
import all.pages.OnlineCinemaRegistrationPage;
import org.junit.jupiter.api.Test;

public class OnlineCinemaTests extends TestBase {

    private String errorMessage = "Заголовок не найден!";

    @Test
    public void positive__scenario() {
//        var expectedHeader = "Мои фильмы";
        var pageReg = new OnlineCinemaRegistrationPage(driver, wait);
        var pageAuth = new OnlineCinemaAuthorizationPage(driver, wait);

        pageReg.open();
        pageReg.addName();
        pageReg.addEmail();
        pageReg.addPassword();
        pageReg.submitButton.click();
        pageReg.openEmail.click();
        pageReg.linkToAuth.click();

        pageAuth.open();
        pageAuth.forgotPasswordLink.click();
        pageAuth.addEmail__forgotPasswordForm();
        pageAuth.submitButtonForgotPasswordForm.click();
        pageAuth.letterLink.click();
//
//        pageAuth.open();
//        pageAuth.addEmail();
//        pageAuth.addPassword();
//        pageAuth.submitButton.click();
//
//        Assertions.assertEquals(expectedHeader, pageAcc.getHeaderText(), errorMessage);
    }
}
