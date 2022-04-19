package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BonusPage {

    private WebDriver driver;

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

    public BonusPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public String getTextHeader() {
        return resultHeader.getText();
    }

    public String getEmptyErrorMessage() {
        return emptyErrorMessage.getText();
    }
}