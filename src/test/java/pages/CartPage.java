package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By headerTitleHeaderLocator = By.className("title");
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
}
