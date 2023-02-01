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
        logger.info("Set email");
        loginPage.userName.sendKeys(email);
        logger.info("Set password");
        loginPage.password.sendKeys(password);
        logger.info("Click Login");
        loginPage.loginButton.click();
        return new CatalogPage(driver);
    }


    public void addFirstItemToCartFromCatalog() {
        logger.info("Add First Item to the Cart");
        catalogPage.addToCart.get(0).click();
    }

    public void addFirstItemFromItemPage() {
        firstItemPage.addToCartButton.click();
    }

    public User createUser() {
        logger.info("Creating user");
        User user = User.builder()
                .userName(ReadProperties.username())
                .password(ReadProperties.password())
                .build();
        logger.info("User created");
        return user;
    }

    public DeliveryUser createDeliveryUser() {
        logger.info("Creating delivery user");
        DeliveryUser deliveryUser = DeliveryUser.builder().build();
        logger.info("Delivery user created");
        logger.info("Setting fake first name");
        deliveryUser.setUserName(Faker.instance().bothify("?????"));
        logger.info("Setting fake last name");
        deliveryUser.setLastName(Faker.instance().bothify("??????"));
        logger.info("Setting fake postal code");
        deliveryUser.setPostalCode(Faker.instance().numerify("#####"));
        logger.info(deliveryUser.toString());
        return deliveryUser;
    }

    public void setShippingValues(String firstName, String lastName, String postalCode) {
        logger.info("Set shipping values");
        logger.info("Set first name");
        cart.firstName.sendKeys(firstName);
        logger.info("Set last name");
        cart.lastName.sendKeys(lastName);
        logger.info("Set postal code");
        cart.postalCode.sendKeys(postalCode);
    }

    public void setShippingValues(DeliveryUser deliveryUser) {
        logger.info("Set shipping values");
        logger.info("Set first name");
        cart.firstName.sendKeys(deliveryUser.getUserName());
        logger.info("Set last name");
        cart.lastName.sendKeys(deliveryUser.getLastName());
        logger.info("Set postal code");
        cart.postalCode.sendKeys(deliveryUser.getPostalCode());
    }

    public Cart completeOrder(DeliveryUser deliveryUser) {
        logger.info("Click CheckOut Button");
        cart.checkoutButton.click();
        setShippingValues(deliveryUser);
        logger.info("Click Continue Button");
        cart.continueButton.click();
        logger.info("Click Finish Button");
        cart.finishButton.click();
        return cart;
    }

    public Cart completeOrder(String firstName, String lastName, String postalCode) {
        logger.info("Click CheckOut Button");
        cart.checkoutButton.click();
        setShippingValues(firstName, lastName, postalCode);
        logger.info("Click Continue Button");
        cart.continueButton.click();
        logger.info("Click Finish Button");
        cart.finishButton.click();
        return cart;
    }
}
