package steps;

import baseEntities.BaseStep;
import com.github.javafaker.Faker;
import configuration.ReadProperties;
import models.DeliveryUser;
import models.User;
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
        return login(email, password);
    }

    public CatalogPage loginSuccessful(User user) {
        return login(user.getUserName(), user.getPassword());
    }

    public CatalogPage login(String email, String password) {
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

    public void completeOrder(String firstName, String lastName, String postalCode) {
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


    public User createUser() {
        User user = new User();
        user.setUserName(ReadProperties.username());
        user.setPassword(ReadProperties.password());
        return user;
    }

    public DeliveryUser createDeliveryUser() {
        DeliveryUser deliveryUser = new DeliveryUser();
        deliveryUser.setUserName(Faker.instance().bothify("?????"));
        deliveryUser.setLastName(Faker.instance().bothify("??????"));
        deliveryUser.setPostalCode(Faker.instance().numerify("#####"));
        System.out.println(deliveryUser.toString());
        return deliveryUser;
    }

    public void setShippingValues(DeliveryUser deliveryUser) {
        cart.firstName.sendKeys(deliveryUser.getUserName());
        cart.lastName.sendKeys(deliveryUser.getLastName());
        cart.postalCode.sendKeys(deliveryUser.getPostalCode());
    }

    public void completeOrder(DeliveryUser deliveryUser) {
        cart.checkoutButton.click();
        setShippingValues(deliveryUser);
        cart.continueButton.click();
        cart.finishButton.click();
    }
}
