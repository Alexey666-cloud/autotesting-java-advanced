package all.notes.pages;
import all.TestBase;
import all.skillbox.pages.SelectElement;
import all.skillbox.pages.SkillboxCoursePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SkillboxTests extends TestBase {

    private static Stream<Arguments> index__course() {
        return Stream.of(
                arguments(3),
                arguments(4),
                arguments(5)
        );
    }

    @ParameterizedTest
    @MethodSource("index__course")
    public void open__skillboxSelectCourse__test(int index) {
        //arrange
        var page = new SkillboxCoursePage(driver, wait);
        var element = new SelectElement(driver, wait, index);
        page.open();
        page.clickCookieButton();
        //action
        page.selectButton.click();
        var expectedResult = element.getButtonCourseText();
        element.setCourse();
        //assert
        Assertions.assertEquals(expectedResult, page.getResultHeaderText(), "Заголовок курса не соответствует выбранному!");
    }
}
