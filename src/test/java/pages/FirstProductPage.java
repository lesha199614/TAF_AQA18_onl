package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstProductPage extends BasePage {
    private final By itemNameLocator = By.className("inventory_details_name");
    private final By addToCartLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLocator = By.className("shopping_cart_link");
    String pagePath = "inventory-item.html?id=4";


    public FirstProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return itemNameLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getAddToCart() {
        return driver.findElement(addToCartLocator);
    }
    public WebElement getCart() {
        return driver.findElement(cartLocator);
    }
}
