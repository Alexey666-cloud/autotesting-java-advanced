package all;
import all.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OnlineInstituteTests extends TestBase {

    private OnlineInstituteMainPage mainPage;
    private String personalHeader__errorMessage = "Заголовок отсутствует! Либо не произошёл вход в личный кабинет";
    private String card__errorMessage = "Не отображаются карточки курсов!";

    @BeforeEach
    public void authorizationAndOpenMainPage() {
        var authPage = new OnlineInstituteAuthorizationPage(driver, wait);
        authPage.open();
        mainPage = authPage.authorization("admin", "tester");
        mainPage.open();
    }

    @Test
    public void authorization__positive__scenario__test() {
        var expectedHeader = "Добро пожаловать, admin!";
        //create Object Class (Page)
        var personalPage = new OnlineInstitutePersonalPage(driver, wait);
        //open&actions main page & actions in authorization form
        mainPage.headerPanel.goToPersonalPage.click();
        //assert
        Assertions.assertEquals(expectedHeader, personalPage.getPersonalHeaderText(), personalHeader__errorMessage);
    }

    @Test
    public void authorization__deferredCourseLink__positive__scenario__test() {
        //create Object Class (Page)
        var personalPage = new OnlineInstitutePersonalPage(driver, wait);
        //open&actions main page
        mainPage.headerPanel.goToPersonalPage.click();
        //open&actions personal page
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
        var personalPage = new OnlineInstitutePersonalPage(driver, wait);
        //open&actions main page
        mainPage.waitForAllCardDisplayed();
        //add cards
        var firstCourse = mainPage.getCourseCard(0);
        var secondCourse = mainPage.getCourseCard(1);

        var expectedFirstCourseTitle = firstCourse.getTitles();
        var expectedSecondCourseTitle = secondCourse.getTitles();

        firstCourse.add();
        secondCourse.add();
        //go to Personal page
        mainPage.headerPanel.goToPersonalPage.click();
        //go to deferred course page
        personalPage.addedDeferredCourses();
        //assert actualTitles
        var actualFirstCourseTitle = personalPage.getCourseCards(1).getTitles();
        var actualSecondCourseTitle = personalPage.getCourseCards(2).getTitles();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, personalPage.courseCards.size(), "Неверное колличество добавленных курсов!"),
                () -> Assertions.assertEquals(expectedFirstCourseTitle, actualFirstCourseTitle, "Заголовок первого отложенного курса несовпадает с ожидаемым результатом!"),
                () -> Assertions.assertEquals(expectedSecondCourseTitle, actualSecondCourseTitle, "Заголовок второго отложенного курса несовпадает с ожидаемым результатом!"),
                () -> Assertions.assertFalse(actualFirstCourseTitle.equals(actualSecondCourseTitle), "Ошибочно были добавлены одинаковые курсы")
        );
    }
}
