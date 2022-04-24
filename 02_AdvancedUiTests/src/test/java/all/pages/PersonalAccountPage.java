package all.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage extends Page{

    @FindBy(css = ".films-title")
    public WebElement myFilmsHeader;

    public PersonalAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText() {
        return myFilmsHeader.getText();
    }
}
