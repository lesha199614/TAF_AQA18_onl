package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final By headerTitleHeaderLocator = By.className("title");
    private final By firstItemLocator = By.id("item_4_title_link");
    private final By firstItemAddToCartLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLocator = By.className("shopping_cart_link");

    String pagePath = "inventory.html";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleHeaderLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getFirstItem(){
     return driver.findElement(firstItemLocator);
    }
    public WebElement getFirstItemAddToCart(){
     return driver.findElement(firstItemAddToCartLocator);
    }
    public WebElement getCart(){
     return driver.findElement(cartLocator);
    }
}
