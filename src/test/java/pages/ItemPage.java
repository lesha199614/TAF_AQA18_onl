package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    private final By itemNameLocator = By.className("inventory_details_name");
    private final By itemPriceLocator = By.className("inventory_details_price");
    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By CartButtonLocator = By.id("shopping_cart_container");
    private final By BackToCatalogButtonLocator = By.id("back-to-products");

    public WebElement getItemName() {
        return driver.findElement(itemNameLocator);
    }

    public WebElement getItemPrice() {
        return driver.findElement(itemPriceLocator);
    }

    public WebElement getAddToCart() {
        return driver.findElement(addToCartButtonLocator);
    }

    public WebElement getCartButton() {
        return driver.findElement(CartButtonLocator);
    }

    public WebElement getBackToCatalog() {
        return driver.findElement(BackToCatalogButtonLocator);
    }
}
