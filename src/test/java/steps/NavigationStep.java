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


    public void openFirstItemFromCatalog () {
        catalogPage.getItems().get(0).click();
    }

    public void openCatalogLink() {
        open(catalogPage.getLink());
    }

    public CartPage openCartFromItemPage() {
        itemPage.getCart().click();
        return new CartPage();
    }
}
