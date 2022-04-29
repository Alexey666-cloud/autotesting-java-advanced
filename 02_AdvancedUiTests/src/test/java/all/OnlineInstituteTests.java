package all;

import all.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

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
                () -> Assertions.assertEquals(expectedFirstCourseTitle, actualFirstCourseTitle, "Заголовок первого отложенного курса не совпадает с ожидаемым результатом!"),
                () -> Assertions.assertEquals(expectedSecondCourseTitle, actualSecondCourseTitle, "Заголовок второго отложенного курса не совпадает с ожидаемым результатом!"),
                () -> Assertions.assertFalse(actualFirstCourseTitle.equals(actualSecondCourseTitle), "Ошибочно были добавлены одинаковые курсы")
        );
    }

    private static Stream<Arguments> index__cards() {
        return Stream.of(
                arguments(0),
                arguments(1),
                arguments(2),
                arguments(3),
                arguments(4),
                arguments(5),
                arguments(6),
                arguments(7)
        );
    }

    @ParameterizedTest
    @MethodSource("index__cards")
    public void addCardsInDeferredCoursePage__scenario__test(int index) {
        //create Objects Classes (Pages)
        var personalPage = new OnlineInstitutePersonalPage(driver, wait);
        //open&actions main page
        mainPage.waitForAllCardDisplayed();
        //add cards
        var course = mainPage.getCourseCard(index);

        var expectedCourseTitle = course.getTitles();
        var expectedCourseDate = course.getStartDate();
        var expectedCourseVideo = course.getVideoCount();
        var expectedCourseLesson = course.getLessonCount();
        var expectedCourseMonth = course.getMonthCount();

        course.add();
        //go to Personal page
        mainPage.headerPanel.goToPersonalPage.click();
        //go to deferred course page
        personalPage.addedDeferredCourses();
        //assert actualTitles
        var actualCourseTitle = personalPage.getCourseCards(1).getTitles();
        var actualCourseDate = personalPage.getCourseCards(1).getStartDate();
        var actualCourseVideo = personalPage.getCourseCards(1).getVideoCount();
        var actualCourseLesson = personalPage.getCourseCards(1).getLessonCount();
        var actualCourseMonth = personalPage.getCourseCards(1).getMonthCount();

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedCourseTitle, actualCourseTitle, "Заголовок отложенного курса не совпадает с ожидаемым результатом!"),
                () -> Assertions.assertEquals(expectedCourseDate, actualCourseDate, "Дата отложенного курса не совпадает с ожидаемым результатом!"),
                () -> Assertions.assertEquals(expectedCourseVideo, actualCourseVideo, "Колличество видеозаписей отложенного курса не совпадает с ожидаемым результатом!"),
                () -> Assertions.assertEquals(expectedCourseLesson, actualCourseLesson, "Колличество уроков отложенного курса не совпадает с ожидаемым результатом!"),
                () -> Assertions.assertEquals(expectedCourseMonth, actualCourseMonth, "Длительность отложенного курса несовпадает с ожидаемым результатом!")
        );
    }
}
