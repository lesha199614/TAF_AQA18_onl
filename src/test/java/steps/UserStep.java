package steps;

import baseEntities.BaseStep;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import pages.*;

public class UserStep extends BaseStep {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private FirstProductPage firstProductPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        firstProductPage = new FirstProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void login(String username, String psw) {
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLogInButtonInput().click();
    }

    public ProductsPage loginSuccessful(String email, String psw) {
        login(email, psw);

        return new ProductsPage(driver);
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }

    public void addToCartFromProductsPage() {
        productsPage.getFirstItemAddToCart().click();
    }

    public void addToCartFromFirstProductPage() {
        firstProductPage.getAddToCart().click();
    }

    public void checkoutCart() {
        cartPage.getCheckout().click();
    }

    public void fillCheckoutForm() {
        checkoutPage.getFirstName().sendKeys(ReadProperties.firstName());
        checkoutPage.getLastName().sendKeys(ReadProperties.lastName());
        checkoutPage.getZip().sendKeys(ReadProperties.zip());

    }
}
