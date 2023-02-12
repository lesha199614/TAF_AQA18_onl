package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage extends BasePage {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    private final By titleLocator = By.className("title");
    private final By cartLocator = By.className("shopping_cart_container");
    private final By itemLocators = By.className("inventory_item_name");
    private final By addToCartLacators = By.className("add-to-cart-sauce-labs-backpack");

    public WebElement getTitle() {
        return waitsService.waitForExists(titleLocator);
    }

    public WebElement getCart() {
        return waitsService.waitForExists(cartLocator);
    }

    public List<WebElement> getItem() {
        return driver.findElements(itemLocators);
    }
    public List<WebElement> getAddToCart() {
        return driver.findElements(addToCartLacators);
    }
}
