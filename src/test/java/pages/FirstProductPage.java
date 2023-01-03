package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstProductPage extends BasePage {
    private final By itemNameLocator = By.className("inventory_details_name");
    private final By addToCartLocator = By.id("add-to-cart-sauce-labs-backpack");
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
}
