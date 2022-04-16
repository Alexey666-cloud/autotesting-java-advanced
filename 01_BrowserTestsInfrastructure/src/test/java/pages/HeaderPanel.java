package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPanel {
    public By mainPageButtonLocator = By.cssSelector("#menu-item-26 > a");

    private WebDriver driver;

    public HeaderPanel(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMainPageButton() {
        driver.findElement(mainPageButtonLocator).click();
    }
}
