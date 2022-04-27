package all;
import all.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnlineInstituteTests extends TestBase {

    private String personalHeader__errorMessage = "Заголовок отсутствует! Либо не произошёл вход в личный кабинет";
    private String card__errorMessage = "Не отображаются карточки курсов!";

    @Test
    public void authorization__positive__scenario__test() {
        var expectedHeader = "Добро пожаловать, admin!";
        //create Object Class (Page)
        var mainPage = new OnlineInstituteMainPage(driver, wait);
        var headerPanel = new OnlineInstituteHeaderPanel(driver, wait);
        var authorizationPage = new OnlineInstituteAuthorizationPage(driver, wait);
        var personalPage = new OnlineInstitutePersonalPage(driver, wait);
        //open&actions main page & actions in authorization form
        mainPage.open();
        headerPanel.enterPersonalPage.click();
        authorizationPage.authorization("admin", "tester");
        //assert
        Assertions.assertEquals(expectedHeader, personalPage.getPersonalHeaderText(), personalHeader__errorMessage);
    }

    @Test
    public void authorization__deferredCourseLink__positive__scenario__test() {
        //create Object Class (Page)
        var mainPage = new OnlineInstituteMainPage(driver, wait);
        var headerPanel = new OnlineInstituteHeaderPanel(driver, wait);
        var authorizationPage = new OnlineInstituteAuthorizationPage(driver, wait);
        //open&actions main page
        mainPage.open();
        headerPanel.enterPersonalPage.click();
        authorizationPage.authorization("admin", "tester");
        //open&actions personal page
        var personalPage = new OnlineInstitutePersonalPage(driver, wait);
        personalPage.deferredCourseLink.click();
        personalPage.returnCoursesListButtonDeferred.click();
        //check displayed 8 cards
        mainPage.waitForAllCardDisplayed();
        //assert
        Assertions.assertTrue(mainPage.isDisplayedTextHeader(), card__errorMessage);
    }

    @Test
    public void addTwoCardsInDeferredCoursePage__scenario__test() {
        //create Objects Classes (Pages)
        var mainPage = new OnlineInstituteMainPage(driver, wait);
        var authorizationPage = new OnlineInstituteAuthorizationPage(driver, wait);
        var headerPanel = new OnlineInstituteHeaderPanel(driver, wait);
        var personalPage = new OnlineInstitutePersonalPage(driver, wait);
        //open&actions main page
        mainPage.open();
        headerPanel.enterPersonalPage.click();
        authorizationPage.authorization("admin", "tester");
        personalPage.returnCoursesListButton.click();
        //check displayed 8 cards
        mainPage.waitForAllCardDisplayed();
        //add first card action
        mainPage.addFirstCourseCard.click();
        mainPage.waitForThanksButtonDisplayed();
        mainPage.thanksButton.click();

        //add last card action
//        mainPage.addLastCourseCard.click();
//        mainPage.waitForThanksButtonDisplayed();
//        mainPage.thanksButton.click();
    }
}
