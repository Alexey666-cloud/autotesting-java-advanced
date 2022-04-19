import org.junit.Assert;
import org.junit.Test;
import pages.CatalogPage;

public class InterShopCatalogPageTests extends TestBase {

    private String error_message = "Данные в корзине не соответствуют выбранной модели в каталоге";

    //Проверить добавление стиральной машины в корзину, в разделе "Бытовая техника"
    @Test
    public void interShop__CatalogPage__First__householdEquipment__AddBasketTest() {
        var expectedResult = "Стиральная машина BEKO WRE64P1BWW, фронтальная, 6кг, 800об/мин";
        var page = new CatalogPage(driver);
        page.open();
        page.linkHouseholdEquipmentCatalogListLocator.click();
        page.addBasketButton.click();
        page.moreInformationButtonLocator.click();
        Assert.assertEquals(error_message, expectedResult, page.get__equipment__header__card__text());
    }

    //Проверить добавление холодильника в корзину, в разделе "Бытовая техника"
    @Test
    public void interShop__CatalogPage__Second__householdEquipment__AddBasketTest() {
        var expectedResult = "Холодильник БИРЮСА Б-M10, однокамерный, серебристый";
        var page = new CatalogPage(driver);
        page.open();
        page.linkHouseholdEquipmentCatalogListLocator.click();
        page.addRefrigeratorBasketButton.click();
        page.moreInformationButtonLocator.click();
        Assert.assertEquals(error_message, expectedResult, page.get__refrigerator__header__card__text());
    }


    //Проверить добавление холодильника в корзину, в разделе "Бытовая техника"
    @Test
    public void interShop__CatalogPage__First__Catalog__AddBasketTest() {
        var expectedResult = "LED телевизор XIAOMI Mi TV 4A 32 HD READY";
        var page = new CatalogPage(driver);
        page.open();
        page.addCatalogBasketButtonLocator.click();
        page.moreInformationButtonLocator.click();
        Assert.assertEquals(error_message, expectedResult, page.get__first__header__result__text());
    }

    //Проверить работу пагинации, и добавления товара на крайней странице в разделе "Каталог"
    @Test
    public void interShop__CatalogPage__Second__Catalog__AddBasketTest() {
        var expectedResult = "SAMSUNG Galaxy S20 8/128Gb, SM-G980F, серый";
        var page = new CatalogPage(driver);
        page.open();
        page.paginationButtonFirthLocator.click();
        page.addCatalogProductBasketButtonLocator.click();
        page.moreInformationButtonLocator.click();
        Assert.assertEquals(error_message, expectedResult, page.get__second__header__result__text());
    }

    //Проверить добавление товара в корзину, в разделе "Планшеты"
    @Test
    public void interShop__CatalogPage__Tables__AddBasketTest() {
        var expectedResult = "iPad 2020 32gb wi-fi";
        var page = new CatalogPage(driver);
        page.open();
        page.tablesButtonLocator.click();
        page.addBasketButton.click();
        page.moreInformationButtonLocator.click();
        Assert.assertEquals(error_message, expectedResult, page.get__tables__header__text());
    }

    //Проверить добавление товара в корзину, в разделе "Часы"
    @Test
    public void interShop__CatalogPage__Watch__AddBasketTest() {
        var expectedResult = "SAMSUNG Galaxy Watch 46мм, 1.3\", серебристый";
        var page = new CatalogPage(driver);
        page.open();
        page.watchButtonLocator.click();
        page.cardAddButtonLocator.click();
        page.moreInformationButtonLocator.click();
        Assert.assertEquals(error_message, expectedResult, page.get__watch__header__text());
    }

    //Проверить работу пагинации, и добавления товара на крайней странице в разделе "Электроника"
    @Test
    public void interShop__CatalogPage__Electronics__AddBasketTest() {
        var firstExpectedResult = "SAMSUNG Galaxy Watch 46мм, 1.3\", серебристый";
        var secondExpectedResult = "Фотоаппарат CANON EOS M50 kit ( 18-150 IS STM), черный";
        var page = new CatalogPage(driver);
        page.open();
        page.electronicsButtonLocator.click();
        page.electronicsPaginationButtonLocator.click();
        page.cardAddButtonLocator.click();
        page.electronicsSecondAddBasketButtonLocator.click();
        page.electronicsMoreInformationButtonLocator.click();
        Assert.assertEquals(error_message, firstExpectedResult, page.get__electronics__first__header__text());
        Assert.assertEquals(error_message, secondExpectedResult, page.get__electronics__second__header__text());
    }
}