import PO.*;
import UI.BaseTest;
import Util.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestRozetka extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(TestRozetka.class);

    @Test
    public void hpAddToBasketPlusCheckPriceTest() throws InterruptedException {
        LOGGER.info("Start Test");

        driver.get(PropertyReader.getValue("url"));
        WebElement searchBar = null;
        Main main = new Main(searchBar);
        main.clickOnSearchBar();
        main.clearSearchBar();
        main.inputQueryToSearchBar("laptop");


        AllLaptop allLaptop = new AllLaptop();
        Thread.sleep(3000);
        allLaptop.chooseSellerRozetka();
        Thread.sleep(2500);
        allLaptop.chooseCheckBoxHP();
        allLaptop.clickOnSortingDropdownMenu();
        allLaptop.selectFromHighToLowPriceInSortingDropdownMenu();
        Thread.sleep(1500);
        allLaptop.chooseFirstProduct();

        LaptopHP laptopHP = new LaptopHP();
        LaptopHP.clickOnByButton();
        Thread.sleep(1000);
        LaptopHP.clickOnToOrderButtonInAlertWindow();

        Basket basket = new Basket();
        String countProductsInBasket = basket.getCountProductsInBasket();
        Integer totalPriceOfPRoductInBasket = basket.getTotalPriceProductInBasket();
        String expectResultCountProductsInBasket = null;
        Assert.assertEquals(countProductsInBasket, expectResultCountProductsInBasket);
        Assert.assertTrue(totalPriceOfPRoductInBasket < 2000000);

    }
}
