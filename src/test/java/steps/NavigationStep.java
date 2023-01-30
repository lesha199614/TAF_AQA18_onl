package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.Cart;
import pages.CatalogPage;
import pages.FirstItemPage;
import pages.LoginPage;

public class NavigationStep extends BaseStep {
    private LoginPage loginPage;
    private CatalogPage catalogPage;
    private FirstItemPage firstItemPage;
    private Cart cart;

    public NavigationStep(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        firstItemPage = new FirstItemPage(driver);
        catalogPage = new CatalogPage(driver);
        cart = new Cart(driver);
    }
    public FirstItemPage openFirstItemPage() {
        catalogPage.firstItem.click();
        return new FirstItemPage(driver);
    }

    public CatalogPage returnToCatalogFromItemPage() {
        firstItemPage.BackToCatalogButton.click();
        return new CatalogPage(driver);
    }
    public Cart openCartFromCatalog() {
        catalogPage.cart.click();
        return new Cart(driver);
    }
}
