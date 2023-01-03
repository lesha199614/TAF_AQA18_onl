package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

public class NavigationSteps extends BaseStep {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private FirstProductPage firstProductPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    public NavigationSteps(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        firstProductPage = new FirstProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public FirstProductPage openFirstItem() {
        productsPage.getFirstItem().click();

        return new FirstProductPage(driver);
    }

    public CartPage moveToCartFromProducts() {
        productsPage.getCart().click();

        return new CartPage(driver);
    }

    public CartPage moveToCartFromFirstProductPage() {
        firstProductPage.getCart().click();

        return new CartPage(driver);
    }

}
