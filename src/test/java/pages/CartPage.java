package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final By headerTitleHeaderLocator = By.className("title");
    private final By checkoutButton = By.id("checkout");
    String pagePath = "cart.html";


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleHeaderLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getCheckout() {
        return driver.findElement(checkoutButton);
    }
}
