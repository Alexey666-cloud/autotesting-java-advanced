package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public HeaderPanel headerPanel;

    @FindBy(css = "h1.entry-title.ak-container")
    public WebElement sectionBookTitleLocator;

    public By phoneTextLocator = By.cssSelector(".text-5-value:nth-child(1)");
    public By emailTextLocator = By.cssSelector(".text-5-value:nth-child(2)");

    public Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        headerPanel = new HeaderPanel(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public Page() {
    }

    public String get__title() {
        return sectionBookTitleLocator.getText();
    }

    public String get__phone__sub__title() {
        return driver.findElement(phoneTextLocator).getText();
    }

    public String get__email__sub__title() {
        return driver.findElement(emailTextLocator).getText();
    }
}