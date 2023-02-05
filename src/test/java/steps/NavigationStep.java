package steps;

import pages.CartPage;
import pages.CatalogPage;
import pages.ItemPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class NavigationStep {
    private LoginPage loginPage;
    private CatalogPage catalogPage;
    private ItemPage itemPage;
    private CartPage cartPage;


    public NavigationStep() {
        loginPage = new LoginPage();
        catalogPage = new CatalogPage();
        itemPage = new ItemPage();
        cartPage = new CartPage();
    }


    public ItemPage openFirstItemFromCatalog() {
        catalogPage.getItems().get(0).click();
        return new ItemPage();
    }

    public CatalogPage openCatalogLink() {
        open(catalogPage.getLink());
        return new CatalogPage();
    }

    public CartPage openCartLink() {
        open(cartPage.getLink());
        return new CartPage();
    }

    public CartPage openCartFromItemPage() {
        itemPage.getCart().click();
        return new CartPage();
    }

    public CartPage openCartFromCatalogPage() {
        catalogPage.getCartButton().click();
        return new CartPage();
    }
}
