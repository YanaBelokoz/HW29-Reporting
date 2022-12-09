package PO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SearchBar extends AbstractPO{
    Logger LOGGER = LogManager.getLogManager(SearchBar.class);
    @FindBy(name = "search")
    public WebElement searchInput;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/button")
    public WebElement searchButton;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/rz-catalog-settings/div/rz-sort/select")
    public WebElement chooseDropdown;
    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-cart/button")
    public WebElement buttonBucket;

    public void clickOnChooseDropdownExpensive(){
        LOGGER.info("Select class for dropdown and select item with value - 2: expensive");

        Select select = new Select(chooseDropdown);
        select.selectByValue("2: expensive");
    }

    public void clickButtonBucket(){
        LOGGER.info("Click on bucket button");
        try {
            TimeUnit TimeUtil = null;
            TimeUtil.SECONDS.sleep(1);
            buttonBucket.click();
        } catch (InterruptedException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    public void fillSearchInput(String message){
        LOGGER.info("Fill search input with message - " + message);
        searchInput.sendKeys(message);
    }

    public void clickSearchButton(){
        LOGGER.info("Click on search button");
        searchButton.click();
    }
}
