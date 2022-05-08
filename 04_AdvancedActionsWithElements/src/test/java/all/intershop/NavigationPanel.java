package all.intershop;
import all.basePage.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NavigationPanel extends Page {

    @FindBy(id = "menu-item-46")
    public WebElement catalogMenuButton;
    @FindBy(id = "menu-item-47")
    public WebElement electronicSubmenuButton;
    @FindBy(id = "menu-item-114")
    public WebElement phoneButton;
    @FindBy(id = "menu-item-116")
    public WebElement noteButton;
    @FindBy(id = "menu-item-118")
    public WebElement tvButton;
    @FindBy(id = "menu-item-117")
    public WebElement photoVideoButton;
    @FindBy(id = "menu-item-115")
    public WebElement watchButton;

    public NavigationPanel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToElectronicComponent() {
        new Actions(driver)
                .moveToElement(catalogMenuButton)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(catalogMenuButton));
        new Actions(driver)
                .moveToElement(electronicSubmenuButton)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(electronicSubmenuButton));
    }
}



