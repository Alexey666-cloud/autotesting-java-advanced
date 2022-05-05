package all.skillbox.pages;
import all.basePage.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectElement extends Page {

    private int index;

    @FindBy(css = ".menu-directions__item")
    public List<WebElement> listCourses;

    public SelectElement(WebDriver driver, WebDriverWait wait, int index) {
        this.driver = driver;
        this.index = index;
        PageFactory.initElements(driver, this);
    }

    public void setCourse() {
        listCourses.get(index).click();
    }



    public String getButtonCourseText() {
        return listCourses.get(index).getText();
    }
}
