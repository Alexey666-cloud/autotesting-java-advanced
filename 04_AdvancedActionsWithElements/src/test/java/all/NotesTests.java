package all;
import all.note.AllNotePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotesTests extends TestBase {

    @Test
    public void add10Notes__and__deleteFirstNote__test() {
        var page = new AllNotePage(driver, wait);
        page.open();

        page.addRandomNote(10);
        page.deleteNote(1);
        page.scrollToLastNote();

        Assertions.assertAll(
                () -> Assertions.assertTrue(page.isNoteDispalyed(11), "Не отобрадается первая дефолтная заметка!"),
                () -> Assertions.assertTrue(page.isNoteDispalyed(12), "Не отображается вторая дефолтная заметка!")
        );
    }
}
