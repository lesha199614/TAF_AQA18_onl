package pages;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends BasePage {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    private final By titleLocator = By.className("title");
    private final By cart = By.className("shopping_cart_container");
    private final By inventory = By.className("inventory_item_name");
    private final By addToCart = By.className("add-to-cart-sauce-labs-backpack");

    public WebElement getTitle() {
        return new UIElement(driver, titleLocator);
    }
}
