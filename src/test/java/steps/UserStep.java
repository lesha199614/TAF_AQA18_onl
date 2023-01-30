package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.Cart;
import pages.CatalogPage;
import pages.FirstItemPage;
import pages.LoginPage;

public class UserStep extends BaseStep {
    private LoginPage loginPage;
    private CatalogPage catalogPage;
    private FirstItemPage firstItemPage;
    private Cart cart;

    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
        firstItemPage = new FirstItemPage(driver);
        catalogPage = new CatalogPage(driver);
        cart = new Cart(driver);
    }

    public CatalogPage loginSuccessful(String email, String password) {
        loginPage.userName.sendKeys(email);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        return new CatalogPage(driver);
    }



    public void addFirstItemToCartFromCatalog() {
        catalogPage.addToCartFirstItem.click();
    }

    public void addFirstItemFromItemPage() {
        firstItemPage.addToCartButton.click();
    }

    public void completeOrder(String firstName, String lastName, String postalCode){
        cart.checkoutButton.click();
        setShippingValues(firstName, lastName, postalCode);
        cart.continueButton.click();
        cart.finishButton.click();
    }

    public void setShippingValues(String firstName, String lastName, String postalCode) {
        cart.firstName.sendKeys(firstName);
        cart.lastName.sendKeys(lastName);
        cart.postalCode.sendKeys(postalCode);
    }



}
