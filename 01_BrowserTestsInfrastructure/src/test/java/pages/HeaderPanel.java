package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPanel extends Page {

    @FindBy(css = "#menu-item-26 > a")
    public WebElement mainPageButtonLocator;

    public HeaderPanel(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public Page clickMainPageButtonLocator() {
        mainPageButtonLocator.click();
        return new Page(driver,wait);
    }
}