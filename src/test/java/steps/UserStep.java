package steps;

import pages.CartPage;
import pages.CatalogPage;
import pages.ItemPage;
import pages.LoginPage;

public class UserStep {
    private LoginPage loginPage;
    private CatalogPage catalogPage;
    private ItemPage itemPage;
    private CartPage cartPage;


    public UserStep() {
        loginPage = new LoginPage();
        catalogPage = new CatalogPage();
        itemPage = new ItemPage();
        cartPage = new CartPage();
    }

    public void login(String email, String psw) {
        loginPage.getEmailInput().val(email);
        loginPage.getPassword().val(psw);
        loginPage.getLogInButton().click();
    }

    public CatalogPage loginSuccessful (String email, String psw) {
        login(email, psw);

        return new CatalogPage();
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }

    public void addItemToCart() {
        itemPage.getAddItemToCartButton().click();
    }

    public void setOrder() {
        cartPage.getCheckoutButton().click();
        cartPage.getFirstName().val();
    }
}
