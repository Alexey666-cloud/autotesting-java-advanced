package all.note;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.UUID;

public class AllNotePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor javascriptExecutor;
    private String url = "http://qa.skillbox.ru/module15/bignotes/#/";

    @FindBy(css = ".popup__wrapper")
    public WebElement popUp;
    @FindBy(css = ".popup__baseInput > .baseInput__field")
    public WebElement titleInput;
    @FindBy(css = ".popup__textarea .baseTextarea__text")
    public WebElement textInput;
    @FindBy(css = ".popup__baseButton")
    public WebElement addNoteButton;
    @FindBy(css = ".baseButtonAdd__text")
    public WebElement addButton;
    @FindBy(id = "icon_delete")
    public WebElement deleteIcon;
    @FindBy(css = ".pageCreate__articlePreview:last-of-type")
    public WebElement lastNote;

    public AllNotePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void addRandomNote(int count) {
        for (int i = 0; i < count; i++) {
            addButton.click();
            wait.until(ExpectedConditions.visibilityOf(popUp));
            titleInput.sendKeys(Integer.toString(i));
            textInput.sendKeys(UUID.randomUUID().toString());
            addNoteButton.click();
        }
    }

    public void deleteNote(int index) {
        var noteLocator = getNoteLocator(index);
        new Actions(driver)
                .moveToElement(driver.findElement(noteLocator))
                .perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDeleteNoteLocator(index)));
        driver.findElement(getDeleteNoteLocator(index));
    }

    private By getDeleteNoteLocator(int index) {
        return By.cssSelector(String.format(".pageCreate__articlePreview:nth-of-type(%d) .articlePreview__button:nth-of-type(2)", index));
    }

    public void scrollToLastNote() {
        new Actions(driver)
                .moveToElement(lastNote)
                .perform();
    }

    private By getNoteLocator(int index) {
        return By.cssSelector(String.format(".pageCreate__articlePreview:nth-of-type(%d)", index));
    }

    public boolean isNoteDispalyed(int index) {
        var noteLocator = getNoteLocator(index);
        var noteElement = driver.findElement(noteLocator);
        return noteElement.isDisplayed();
    }
}
