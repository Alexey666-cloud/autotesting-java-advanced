package all.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class OnlineInstitutePersonalCourseElement {
    @FindBy(css = ".baseCard__label")
    public List<WebElement> startDate;
    @FindBy(css = ".baseCard__title")
    public List<WebElement> titles;
    @FindBy(css = ".baseCard .baseCondition:nth-of-type(1)")
    public List<WebElement> videoCount;
    @FindBy(css = ".baseCard .baseCondition:nth-of-type(2)")
    public List<WebElement> lessonCount;
    @FindBy(css = ".baseCard .baseCondition:nth-of-type(3)")
    public List<WebElement> monthCount;

    private WebDriver driver;
    private int index;

    public OnlineInstitutePersonalCourseElement(WebDriver driver, int index) {
        this.driver = driver;
        this.index = index;
        PageFactory.initElements(driver, this);
    }

    public String getStartDate() {
        return startDate.get(index).getText();
    }

    public String getTitles() {
        return titles.get(index).getText();
    }

    public String getVideoCount() {
        return videoCount.get(index).getText();
    }

    public String getLessonCount() {
        return lessonCount.get(index).getText();
    }

    public String getMonthCount() {
        return  monthCount.get(index).getText();
    }
}
