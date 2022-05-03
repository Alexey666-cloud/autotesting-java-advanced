package all;

import all.notes.pages.NotesMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotesTests extends TestBase{

    @Test
    public void setDate_in_calendarForm__andEqualsResult__Test() {
        //arrange
        var expectedResultHeader = "5 мая 2022";
        var page = new NotesMainPage(driver, wait);
        page.open();
        //actions
        var initialDate = page.getDate();
        page.setDate("05.05.2022");
        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedResultHeader, page.getResultHeaderText(), "Дата установлена не верно, лиюо не отображается!"),
                () -> Assertions.assertNotEquals(initialDate, page.getDate(), "Дата не изменилась!")
        );
    }
}
