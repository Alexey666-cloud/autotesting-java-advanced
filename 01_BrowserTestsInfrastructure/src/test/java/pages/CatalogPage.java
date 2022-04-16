package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {

    private WebDriver driver;

    private String url = "http://intershop6.skillbox.ru/product-category/catalog/";

    public By linkHouseholdEquipmentCatalogListLocator = By.linkText("Бытовая техника");
    public By addBasketButton = By.cssSelector(".product:nth-child(1) .button");
    public By moreInformationButtonLocator = By.cssSelector(".added_to_cart");
    public By expectedHeaderResultLocator = By.linkText("Стиральная машина BEKO WRE64P1BWW, фронтальная, 6кг, 800об/мин");
    public By addRefrigeratorBasketButton = By.cssSelector(".product:nth-child(10) .button");
    public By refrigeratorExpectedHeaderResultLocator = By.linkText("Холодильник БИРЮСА Б-M10, однокамерный, серебристый");
    public By addCatalogBasketButtonLocator = By.cssSelector(".product:nth-child(6) .button");
    public By catalogFirstExpectedHeaderResultLocator = By.linkText("LED телевизор XIAOMI Mi TV 4A 32 HD READY");
    public By paginationButtonFirthLocator = By.cssSelector(".next");
    public By addCatalogProductBasketButtonLocator = By.cssSelector(".product:nth-child(1) .button");
    public By catalogSecondExpectedHeaderResultLocator = By.linkText("SAMSUNG Galaxy S20 8/128Gb, SM-G980F, серый");
    public By tablesButtonLocator = By.linkText("Планшеты");
    public By expectedTablesHeaderLocator = By.linkText("iPad 2020 32gb wi-fi");
    public By watchButtonLocator = By.linkText("Часы");
    public By cardAddButtonLocator = By.cssSelector(".product:nth-child(2) .button");
    public By expectedWatchHeaderLocator = By.linkText("SAMSUNG Galaxy Watch 46мм, 1.3\", серебристый");
    public By electronicsButtonLocator = By.linkText("Электроника");
    public By electronicsPaginationButtonLocator = By.linkText("2");
    public By electronicsSecondAddBasketButtonLocator = By.cssSelector(".product:nth-child(6) .button");
    public By electronicsMoreInformationButtonLocator = By.cssSelector(".added_to_cart");
    public By expectedElectronicsFirstHeaderLocator = By.linkText("SAMSUNG Galaxy Watch 46мм, 1.3\", серебристый");
    public By expectedElectronicsSecondHeaderLocator = By.linkText("Фотоаппарат CANON EOS M50 kit ( 18-150 IS STM), черный");

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.navigate().to(url);
    }

    public void get__information() {
        driver.findElement(moreInformationButtonLocator).click();
    }

    public void add__goods() {
        driver.findElement(addBasketButton).click();
    }

    public void get__equipment__list() {
        driver.findElement(linkHouseholdEquipmentCatalogListLocator).click();
    }

    public String get__equipment__header__card__text() {return driver.findElement(expectedHeaderResultLocator).getText(); }

    public void add__refrigerator() {
        driver.findElement(addRefrigeratorBasketButton).click();
    }

    public String get__refrigerator__header__card__text() {return driver.findElement(refrigeratorExpectedHeaderResultLocator).getText();}

    public void add__goods__to__basket() {
        driver.findElement(addCatalogBasketButtonLocator).click();
    }

    public void get__watch__list() {driver.findElement(watchButtonLocator).click();}

    public void add__card__to__basket() {driver.findElement(cardAddButtonLocator).click(); }

    public String get__first__header__result__text() {return driver.findElement(catalogFirstExpectedHeaderResultLocator).getText();}

    public void get__pagination__firth() {
        driver.findElement(paginationButtonFirthLocator).click();
    }

    public void add__tables() {driver.findElement(tablesButtonLocator).click();}

    public void add__catalog__product__basket() {
        driver.findElement(addCatalogProductBasketButtonLocator).click();
    }

    public void get_electronics__list() {driver.findElement(electronicsButtonLocator).click();}

    public String get__second__header__result__text() {return driver.findElement(catalogSecondExpectedHeaderResultLocator).getText();}

    public void add__electronics__to__basket() {
        driver.findElement(electronicsSecondAddBasketButtonLocator).click();
        driver.findElement(electronicsMoreInformationButtonLocator).click();
    }

    public void get__pagination() {driver.findElement(electronicsPaginationButtonLocator).click();}

    public String get__tables__header__text() {
        return driver.findElement(expectedTablesHeaderLocator).getText();
    }

    public String get__watch__header__text() {return driver.findElement(expectedWatchHeaderLocator).getText();}

    public String get__electronics__first__header__text() {return driver.findElement(expectedElectronicsFirstHeaderLocator).getText();}

    public String get__electronics__second__header__text() {return driver.findElement(expectedElectronicsSecondHeaderLocator).getText();}
}
