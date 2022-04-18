package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPanel {

    @FindBy(css = "#menu-item-26 > a")
    public WebElement mainPageButtonLocator;

    private WebDriver driver;

    public HeaderPanel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
