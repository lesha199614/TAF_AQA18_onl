package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.DeliveryUser;
import models.User;
import org.testng.annotations.Test;

public class HW_Tests extends BaseTest {


    @Test
    public void login() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        navigationStep.openFirstItemPage();
        userStep.addFirstItemFromItemPage();
        navigationStep.returnToCatalogFromItemPage();
        navigationStep.openCartFromCatalog();
        userStep.completeOrder("Alex", "Vayteh", "1243");
    }

    @Test
    public void chain() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .addToCart.get(0).click();
        navigationStep.openCartFromCatalog()
                .cartCheckOut()
                .setShippingValues("Alex", "Vayeh", "1234")
                .clickContinue()
                .clickFinish()
                .backToCatalog();
    }

    @Test
    public void valueOfObject() {
        user = userStep.createUser();
        DeliveryUser deliveryUser = userStep.createDeliveryUser();
        userStep.loginSuccessful(user);
        userStep.addFirstItemToCartFromCatalog();
        navigationStep.openCartFromCatalog();
        userStep.completeOrder(deliveryUser);
    }

    @Test
    public void builder() {
        User user = new User.Builder()
                .withFirstName(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();
        DeliveryUser deliveryUser = new DeliveryUser.Builder()
                .withFirstName("Alex")
                .withLastName("Vayteh")
                .withPostalCode("1234")
                .build();
        userStep.loginSuccessful(user);
        userStep.addFirstItemToCartFromCatalog();
        navigationStep.openCartFromCatalog();
        userStep.completeOrder(deliveryUser);
    }

}