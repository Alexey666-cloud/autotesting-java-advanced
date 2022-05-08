package all;
import all.intershop.MainPage;
import all.intershop.ResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntershopTests extends TestBase{

    @Test
    public void selectMenu__open__phone__test(){
        var expectedTitle = "ТЕЛЕФОНЫ";
        var mainPage = new MainPage(driver, wait);
        var phonePage = new ResultPage(driver, wait);
        mainPage.open();
        mainPage.navigationPanel.goToElectronicComponent();
        mainPage.navigationPanel.phoneButton.click();

        Assertions.assertEquals(expectedTitle, phonePage.getTitleText(), "Открылась не такая страница какая ожидалась!");
    }

    @Test
    public void selectMenu__open__note__test(){
        var expectedTitle = "ПЛАНШЕТЫ";
        var mainPage = new MainPage(driver, wait);
        var phonePage = new ResultPage(driver, wait);
        mainPage.open();
        mainPage.navigationPanel.goToElectronicComponent();
        mainPage.navigationPanel.noteButton.click();

        Assertions.assertEquals(expectedTitle, phonePage.getTitleText(), "Открылась не такая страница какая ожидалась!");
    }

    @Test
    public void selectMenu__open__tv__test(){
        var expectedTitle = "ТЕЛЕВИЗОРЫ";
        var mainPage = new MainPage(driver, wait);
        var phonePage = new ResultPage(driver, wait);
        mainPage.open();
        mainPage.navigationPanel.goToElectronicComponent();
        mainPage.navigationPanel.tvButton.click();

        Assertions.assertEquals(expectedTitle, phonePage.getTitleText(), "Открылась не такая страница какая ожидалась!");
    }

    @Test
    public void selectMenu__open__photoVideo__test(){
        var expectedTitle = "ФОТО/ВИДЕО";
        var mainPage = new MainPage(driver, wait);
        var phonePage = new ResultPage(driver, wait);
        mainPage.open();
        mainPage.navigationPanel.goToElectronicComponent();
        mainPage.navigationPanel.photoVideoButton.click();

        Assertions.assertEquals(expectedTitle, phonePage.getTitleText(), "Открылась не такая страница какая ожидалась!");
    }

    @Test
    public void selectMenu__open__watch__test(){
        var expectedTitle = "ЧАСЫ";
        var mainPage = new MainPage(driver, wait);
        var phonePage = new ResultPage(driver, wait);
        mainPage.open();
        mainPage.navigationPanel.goToElectronicComponent();
        mainPage.navigationPanel.watchButton.click();

        Assertions.assertEquals(expectedTitle, phonePage.getTitleText(), "Открылась не такая страница какая ожидалась!");
    }

    @Test
    public void scroll__to__topButton__is__displayed__test(){
        var page = new MainPage(driver, wait);
        page.open();
        page.scrollToTopButton();
        Assertions.assertTrue(page.topButtonIsDisplayed(), "Кнопка не отображается!");
    }
}
