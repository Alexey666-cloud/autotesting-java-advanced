package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BonusPage extends Page{

    private String url = "http://intershop6.skillbox.ru/bonus/";

    @FindBy(css = "#bonus_username")
    public WebElement userName;
    @FindBy(css = "#bonus_phone")
    public WebElement phoneNumber;
    @FindBy(css = ".woocommerce-Button")
    public WebElement submitButton;
    @FindBy(css = "#bonus_main h3")
    public WebElement resultHeader;
    @FindBy(css = "#bonus_content")
    public WebElement emptyErrorMessage;

    private By loaderLocatorLastPoint = By.className("loaderPoint");

    public BonusPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public Boolean isDisplayedTextHeader() {
        try {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(5, TimeUnit.SECONDS);
            return resultHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public Boolean isNotDisplayedTextHeader() {
        try {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);
            return resultHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public String getEmptyErrorMessage() {
        return emptyErrorMessage.getText();
    }

    public void waitForLoaderEnds() {
        var newWait = new WebDriverWait(driver, 15);
        newWait.until(driver -> driver.findElements(loaderLocatorLastPoint).size() == 4);
    }
}