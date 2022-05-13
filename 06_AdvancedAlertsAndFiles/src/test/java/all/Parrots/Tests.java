package all.Parrots;
import all.Parrots.pages.MainPage;
import all.base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void mainPage__switchEmail__andInvisibleTitle__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        //act
        page.boy.click();
        page.addEmail();
        page.submitButton.click();
        page.switchEmail.click();
        var alert = driver.switchTo().alert();
        alert.dismiss();
        //assert
        var actualInputEmailText = "";
        Assertions.assertAll(
                () -> Assertions.assertFalse(page.switchEmail.isDisplayed(), "Ссылка «Указать другой email» отображается!"),
                () -> Assertions.assertEquals(page.getInputEmailText(), actualInputEmailText, "Поле для воода email не пустое!")
        );
    }

    @Test
    public void mainPage__switchEmail__andGetTitleAlertFrame__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        //act
        page.boy.click();
        page.addEmail();
        page.submitButton.click();
        page.switchEmail.click();
        var alert = driver.switchTo().alert();
        var actualAlertTitle= alert.getText();
        alert.dismiss();
        //assert
        var expectedAlertTitle = "Укажите другой e-mail";
        Assertions.assertEquals(expectedAlertTitle, actualAlertTitle, "Текст заголовка не совпадает с ожидаемым результатом!");
    }
}
