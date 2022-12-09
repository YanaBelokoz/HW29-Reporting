package PO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Main extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    @FindBy(xpath = "//input")
    private final WebElement searchBar;

    public Main(WebElement searchBar) {
        this.searchBar = searchBar;
    }

    public void clickOnSearchBar() {
      LOGGER.info("Click SearchBar);
      searchBar.click();
    }

    public void clearSearchBar() {
        LOGGER.info("Clear SearchBar");
        searchBar.clear();
    }

    public Main inputQueryToSearchBar(String text) {
        LOGGER.info("Send query'" + text + "' to searchBar);
        searchBar.sendKeys(text);
        return this;
    }

}
