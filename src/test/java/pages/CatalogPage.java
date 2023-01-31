package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "title")
    public WebElement title;

    @FindBy(id = "item_4_title_link")
    public WebElement firstItem;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartFirstItem;

    @FindBy(id = "shopping_cart_container")
    public WebElement cart;

}
