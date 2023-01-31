package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstItemPage extends BasePage {
    public FirstItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "inventory_details_name")
    public WebElement itemName;

    @FindBy(className = "inventory_details_price")
    public WebElement itemPrice;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartButton;

    @FindBy(id = "shopping_cart_container")
    public WebElement cart;

    @FindBy(id = "back-to-products")
    public WebElement BackToCatalogButton;

}
