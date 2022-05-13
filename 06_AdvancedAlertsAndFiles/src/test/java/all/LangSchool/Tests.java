package all.LangSchool;
import all.LangSchool.pages.MainPage;
import all.base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void uploadPicture__failed__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        //act
        var file = System.getProperty("user.dir") + "\\file\\DSC09005.JPG";
        page.uploadFile(file);
        //assert
        Assertions.assertTrue(page.failIcon.isDisplayed(), "Ошибка, что размер файла больше 5 мгб, не отображается!");
    }
}
