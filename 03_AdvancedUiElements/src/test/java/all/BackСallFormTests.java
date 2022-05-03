package all;
import all.callForm.pages.CallFormMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BackСallFormTests extends TestBase {

    private static Stream<Arguments> date_and_timeParam() {
        return Stream.of(
                arguments("05.05.2022", "09:00", "18:00"),
                arguments("10.05.2022", "12:00", "14:00"),
                arguments("07.05.2023", "14:00", "17:00"),
                arguments("05.05.2021", "09:00", "18:00"),
                arguments("05.05.2021", "09:00", "19:00"),
                arguments("05.05.2032", "09:00", "18:00")
        );
    }

    @ParameterizedTest
    @MethodSource("date_and_timeParam")
    public void setDate_in_calendarForm__andEqualsResult__Test(String date, String fromTime, String toTime) {
        //arrange
        var page = new CallFormMainPage(driver, wait);
        page.open();
        var initialDate = page.getDate();
        //actions
        page.setDate(date);
        page.addPhone();
        page.setFromTime(fromTime);
        page.setToTime(toTime);
        page.submitButton.click();
        var actualDateHeader = page.getDateResultHeader();
        var actualTimeHeader = page.getTimeResultHeader();
        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(actualTimeHeader, page.getTimeResultHeader(), "Не верно отображается время!"),
                () -> Assertions.assertEquals(actualDateHeader, page.getDateResultHeader(), "Не верно отображается дата!")
        );
    }
}
