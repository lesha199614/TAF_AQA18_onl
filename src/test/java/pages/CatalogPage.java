package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CatalogPage extends BasePage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "title")
    public WebElement title;

    @FindBy(id = "shopping_cart_container")
    public WebElement cart;

    @FindBys(@FindBy(className = "inventory_item_name"))
    public List<WebElement> items;

    @FindBys(@FindBy(id = "add-to-cart-sauce-labs-backpack"))
    public List<WebElement> addToCart;
}
